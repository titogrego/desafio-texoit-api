package Requests;

import DTO.UserDTO;
import Helpers.BaseTest;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Requests extends BaseTest {


    public Response GETComments(Map<String,String> queryParam) {

        return given()
                .params(queryParam)
                .when()
                .get("comments");
    }

    public Response POSTUsers(UserDTO body) {

        return given()
                .body(body)
                .when()
                .post("users");
    }

    public Response PUTUsers(UserDTO body,int id) {

        return given()
                .pathParam("id",id)
                .body(body)
                .when()
                .put("users/{id}");
    }


}
