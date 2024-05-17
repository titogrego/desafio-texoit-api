package Tests;

import DTO.UserDTO;
import Data.UsersData;
import Helpers.BaseTest;
import Requests.Requests;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;


public class DesafioTest extends BaseTest {
    Requests request = new Requests();


    @Test(description = "Validar o retorno da API", priority = 0)
    public void validarRetornoApiGetComments() {
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("name","alias odio sit");
        request.GETComments(queryParam)
                .then()
                .statusCode(200)
                .body("email", hasItem("Lew@alysha.tv"))
                ;

    }

    @Test(description = "Validar o retorno da API", priority = 0)
    public void validarRetornoApiPostUsers() {
        UserDTO body = UsersData.retornaUser();
        request.POSTUsers(body)
                .then()
                .statusCode(201)
                .body("id", is(instanceOf(Integer.class)))
                .body("id", is(notNullValue()))
                .body("id", is(11))
        ;

    }

    @Test(description = "Validar o retorno da API", priority = 0)
    public void validarRetornoApiPutUsers() {
        UserDTO user = UsersData.retornaUser();
        int id =1;
        request.PUTUsers(user,id)
                .then()
                .statusCode(200)
                .body(  "id", is(id),
                        "name", is(user.name),
                        "username",is(user.username),
                        "email",is(user.email),
                        "address.street",is(user.address.street),
                        "address.suite",is(user.address.suite),
                        "address.city",is(user.address.city),
                        "address.zipcode",is(user.address.zipcode),
                        "address.geo.lat",is(user.address.geo.lat),
                        "address.geo.lng",is(user.address.geo.lng),
                        "phone",is(user.phone),
                        "website",is(user.website),
                        "company.name",is(user.company.name),
                        "company.catchPhrase",is(user.company.catchPhrase),
                        "company.bs",is(user.company.bs)
                )

        ;

    }


}

