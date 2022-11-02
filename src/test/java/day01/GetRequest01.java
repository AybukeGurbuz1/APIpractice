package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01(){

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().when().get(url);  //
        //given().when().get(url) --> end point e göndermek için reuest oluşturmuş olduk
        //Response response --> api tarafından bana dönen response (cevap)

        //Response response = given().auth().basic("user", "password").when().get(url)
        //basic aut ile reuest göndermek için



        //response.prettyPrint();    // response daki body i yazdırır

        //response.prettyPeek();   // response daki herşeyi yazdırır


        //response.peek();     // string olarak datayı verir

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        // 1) Junit Assertleri ila API testi yapabiliriz
        Assert.assertEquals("Status Kod Hatalı",200, response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK", response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8", response.contentType());

        // 2) assertthat ile
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");


    }
}
