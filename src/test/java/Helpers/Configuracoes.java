package Helpers;


import io.restassured.http.ContentType;

import java.util.UUID;

public interface Configuracoes {

    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    String URL= "https://jsonplaceholder.typicode.com";

    boolean printLocalLog = true;
}
