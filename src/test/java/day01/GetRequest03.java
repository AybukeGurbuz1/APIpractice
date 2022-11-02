package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest03 {

     /* Matchers ile dataları doğrulayınız
             "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
     */

    @Test
    public void test03() {
        String url="https://reqres.in/api/users";
        Response response = given().when().get(url);
        response.then().assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType(ContentType.JSON);

        response.then().body("data[4].email", equalTo("charles.morris@reqres.in"));
        response.then().body("data[4].first_name", equalTo("Charles"));
        response.then().body("data[4].last_name", equalTo("Morris"));
        response.then().body("data[4].avatar", equalTo("https://reqres.in/img/faces/5-image.jpg"));
    }
}
