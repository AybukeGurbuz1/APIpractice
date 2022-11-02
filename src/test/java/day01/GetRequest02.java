package day01;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {

    @Test
    public void test01(){

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
        //given().when().get(url) --> request
        //Response response --> response

        //Header Test

        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType("application/json; charset=utf-8");

        //Body Test

        /* idsi 1 olanın datalarınının aşağıdaki gibi olduğunu test ediniz
             "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
         */

        // 3) Matcher Class ile
        response.then().body("data[0].email", Matchers.equalTo("george.bluth@reqres.in")
                ,"data[0].first_name", Matchers.equalTo("George")
                ,"data[0].last_name", Matchers.equalTo("Bluth"));


    }
}
