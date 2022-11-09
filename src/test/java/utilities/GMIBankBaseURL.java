package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GMIBankBaseURL extends Authentication{

    protected RequestSpecification spec01;

    @Before
    public void setUp(){
        spec01 = new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api/").build();
    }
}
