package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static constant.ApiConstant.*;
import static io.restassured.RestAssured.given;

public class ApiBase {

    public void setup(){
        RestAssured.baseURI = BASEURL;
    }

    public String generateStringFromResource(String fileName) throws IOException {
        String path = "src/test/java/resources/" + fileName + ".json";
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public Response createPet(String file) throws IOException{
        return given()
                .header("Content-Type","application/json")
                .log()
                .all()
                .body(generateStringFromResource(file))
                .when()
                .post(CREATE_PET_PATH);
    }


    public Response updatePet(String file) throws IOException{
        return given()
                .header("Content-Type","application/json")
                .log()
                .all()
                .body(generateStringFromResource(file))
                .when()
                .put(UPDATE_PET_PATH);
    }

    public Response findPetByStatus(String status){
        return given()
                .header("Accept","application/json")
                .log()
                .all()
                .when()
                .queryParam("status",status)
                .get(FIND_PET_BY_STATUS_PATH);
    }

    public Response findPetById(String petId){
        return given()
                .header("Accept","application/json")
                .log()
                .all()
                .when()
                .get(FIND_PET_BY_ID_PATH + petId);
    }



}
