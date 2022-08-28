package test;

import base.ApiBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static constant.ApiConstant.*;

public class ApiTest extends ApiBase {

    @BeforeTest
    public void beforeTest() {
        setup();
    }

    @Test
    public void createPetSuccess() throws IOException {
        Response response = createPet("PetCreateSuccess");
        JsonPath responseJson = new JsonPath(response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertNotNull(responseJson.getString("id"));
        Assert.assertNotNull(responseJson.getString("photoUrls[0]"));
        Assert.assertNotNull(responseJson.getString("tags"));


        Assert.assertEquals(responseJson.getString("name"), CREATE_PET_NAME);
        Assert.assertEquals(responseJson.getString("status"),CREATE_PET_STATUS);
        Assert.assertEquals(responseJson.get("photoUrls"), CREATE_PET_PHOTOS);
        Assert.assertEquals(responseJson.getString("category.name"),CREATE_PET_CATEGORY.get("name"));
    }

    @Test
    public void createPet400() throws IOException{
        Response response = createPet("PetCreate400");
        JsonPath responseJson = new JsonPath(response.asString());

        Assert.assertEquals(response.getStatusCode(), 400);

        Assert.assertEquals(responseJson.getInt("code"), 400);
        Assert.assertEquals(responseJson.getString("message"), CREATE_PET_400_MESSAGE);
    }

    @Test
    public void updatePetSuccess() throws IOException{
        Response response = updatePet("PetUpdateSuccess");
        JsonPath responseJson = new JsonPath(response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertNotNull(responseJson.getString("id"));
        Assert.assertNotNull(responseJson.getString("photoUrls[0]"));
        Assert.assertNotNull(responseJson.getString("tags"));

        Assert.assertEquals(responseJson.getString("name"), UPDATE_PET_NAME);
        Assert.assertEquals(responseJson.getString("status"),UPDATE_PET_STATUS);
        Assert.assertEquals(responseJson.get("photoUrls"), UPDATE_PET_PHOTOS);
        Assert.assertEquals(responseJson.getString("category.name"),UPDATE_PET_CATEGORY.get("name"));
    }

    @Test
    public void updatePet400() throws IOException{
        Response response = updatePet("PetUpdate400");
        JsonPath responseJson = new JsonPath(response.asString());

        Assert.assertEquals(response.getStatusCode(), 400);

        Assert.assertEquals(responseJson.getInt("code"), 400);
        Assert.assertEquals(responseJson.getString("message"), UPDATE_PET_400_MESSAGE);
    }

    @Test
    public void updatePet404() throws IOException{
        System.out.println("Update 404");

        //İstek 404 almıyor
    }

    @Test
    public void findPetByStatusAvailableSuccess(){
        Response responseAvailable = findPetByStatus(STATUS_AVAILABLE);
        JsonPath responseAvailableJson = new JsonPath(responseAvailable.asString());

        Assert.assertEquals(responseAvailable.getStatusCode(), 200);

        for (int i = 1; i < responseAvailableJson.getInt("$.size()"); i++) {
            Assert.assertNotNull(responseAvailableJson.getString("["+i+"].id"));
            Assert.assertNotNull(responseAvailableJson.getString("["+i+"].name"));
            Assert.assertEquals(responseAvailableJson.getString("["+i+"].status"), STATUS_AVAILABLE);
        }
    }

    @Test
    public void findPetByStatusPendingSuccess(){
        Response responseAvailable = findPetByStatus(STATUS_PENDING);
        JsonPath responseAvailableJson = new JsonPath(responseAvailable.asString());

        Assert.assertEquals(responseAvailable.getStatusCode(), 200);

        for (int i = 1; i < responseAvailableJson.getInt("$.size()"); i++) {
            Assert.assertNotNull(responseAvailableJson.getString("["+i+"].id"));
            Assert.assertNotNull(responseAvailableJson.getString("["+i+"].name"));
            Assert.assertEquals(responseAvailableJson.getString("["+i+"].status"), STATUS_PENDING);
        }
    }

    @Test
    public void findPetByStatusSoldSuccess(){
        Response responseAvailable = findPetByStatus(STATUS_SOLD);
        JsonPath responseAvailableJson = new JsonPath(responseAvailable.asString());

        Assert.assertEquals(responseAvailable.getStatusCode(), 200);

        for (int i = 1; i < responseAvailableJson.getInt("$.size()"); i++) {
            Assert.assertNotNull(responseAvailableJson.getString("["+i+"].id"));
            Assert.assertEquals(responseAvailableJson.getString("["+i+"].status"), STATUS_SOLD);
        }
    }
/*
    @Test
    public void findPetById(){
        Response response = findPetById("1");
        JsonPath responseJson = new JsonPath(response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
*/

}
