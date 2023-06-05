package services;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static base_page.BasePage.HOME_PAGE_URL;

@Getter
public class UserApiService {

    private static final String LOGIN_ENDPOINT = "/api/auth/login";
    private static final String AUTH_ENDPOINT = "/api/auth/user";
    private static final String REGISTER_ENDPOINT = "/api/auth/register";
    private static String accessToken = "";
    private static String refreshToken = "";
    private final RestClientService restClientService = new RestClientService();
    private static final Faker faker = new Faker();
    public static Map<String, String> fake = null;

    public static String getAccessToken() {
        return accessToken;
    }

    public static String getRefreshToken() {
        return refreshToken;
    }

    @Step("Логин пользователя")
    public Response loginUser() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("email", fake.get("email"));
        requestBody.put("password", fake.get("password"));
        RestAssured.baseURI = HOME_PAGE_URL;
        return restClientService.sendRequestWithBody(Method.POST, LOGIN_ENDPOINT, requestBody);
    }

    @Step("генерируем пользователя")
    public static Map<String, String> generateUser(boolean shortPassword) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", faker.internet().emailAddress());
        requestBody.put("password", shortPassword ? faker.lorem().characters(1, 5) : faker.internet().password());
        requestBody.put("name", faker.name().firstName());
        return requestBody;
    }

    @Step("получаем accessToken из запроса -{response}")
    public String retrievedAccessToken(Response response) {
        return response.jsonPath().getString("accessToken");
    }

    @Step("получаем RefreshToken из запроса -{response}")
    public String retrievedRefreshToken(Response response) {
        return response.jsonPath().getString("refreshToken");
    }


    @Step("Создание тестового пользователя")
    public void createTestUser() {
        RestAssured.baseURI = HOME_PAGE_URL;
        fake = generateUser(false);
        Response response = restClientService.sendRequestWithBody(Method.POST, REGISTER_ENDPOINT, fake);
        accessToken = retrievedAccessToken(response);
        refreshToken = retrievedRefreshToken(response);
        restClientService.validateResponse(response, 200);
    }

    @Step("Удаляем созданного юзера")
    public void deleteTestUser() {
        if (fake == null) {
            return;
        }
        Response response = loginUser();
        if (response != null && response.getStatusCode() == 200) {
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", retrievedAccessToken(response));
            Response response1 = restClientService.sendRequestWithHeaders(Method.DELETE, AUTH_ENDPOINT, headers);
            restClientService.validateResponse(response1, 202);
            fake = null;
        }
    }
}
