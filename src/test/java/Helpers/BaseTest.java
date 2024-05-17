package Helpers;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Locale;


public class BaseTest implements Configuracoes {


    public static Faker faker = new Faker(new Locale("pt-BR"));
    public StringWriter requestWriter;
    public PrintStream requestCapture;
    public StringWriter responseWriter;
    public PrintStream responseCapture;

    String log = System.getProperty("logInfo");
    @BeforeTest
    public void setUp() {
            RestAssured.baseURI = URL;
            RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
            reqBuilder.setContentType(APP_CONTENT_TYPE);
            RestAssured.requestSpecification = reqBuilder.build();
            ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
            RestAssured.responseSpecification = resBuilder.build();
    }

    @BeforeMethod
    public void initLog(){
        requestWriter = new StringWriter();
        responseWriter = new StringWriter();
        requestCapture = new PrintStream(new WriterOutputStream(requestWriter));
        responseCapture = new PrintStream(new WriterOutputStream(responseWriter));
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.addFilter((new RequestLoggingFilter(requestCapture)));
        reqBuilder.addFilter((new ResponseLoggingFilter(responseCapture)));
        RestAssured.requestSpecification = reqBuilder.build();
    }

    @AfterMethod
    public void addLog(){
        requestCapture.flush();
        responseCapture.flush();
        if (log==null){
            if (printLocalLog) {
                System.out.println(requestWriter.toString());
                System.out.println(responseWriter.toString());
            }
        }

        Listener.insertLogToReport("Request: ", requestWriter.toString() );
        Listener.insertLogToReport("Response: ",responseWriter.toString());
    }
}
