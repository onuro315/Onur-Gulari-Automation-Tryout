package constant;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;


public class ApiConstant {


    //Paths
    public static final String BASEURL = "https://petstore.swagger.io/v2";

    public static final String CREATE_PET_PATH = "/pet";
    public static final String UPDATE_PET_PATH = "/pet";
    public static final String FIND_PET_BY_STATUS_PATH = "/pet/findByStatus?status=available";
    public static final String FIND_PET_BY_ID_PATH = "/pet/:petId";




    //Values
    public static final String CREATE_PET_NAME = getString("PetCreateSuccess", "name");
    public static final String CREATE_PET_STATUS = getString("PetCreateSuccess", "status");
    public static final JSONArray CREATE_PET_PHOTOS = getJSONArray("PetCreateSuccess", "photoUrls");
    public static final JSONObject CREATE_PET_CATEGORY = getJSONObject("PetCreateSuccess", "category");

    public static final String UPDATE_PET_NAME = getString("PetUpdateSuccess", "name");
    public static final String UPDATE_PET_STATUS = getString("PetUpdateSuccess", "status");
    public static final JSONArray UPDATE_PET_PHOTOS = getJSONArray("PetUpdateSuccess", "photoUrls");
    public static final JSONObject UPDATE_PET_CATEGORY = getJSONObject("PetUpdateSuccess", "category");

    public static final String STATUS_AVAILABLE = "available";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_SOLD = "sold";

    public static final String INVALID_PET_ID = "39955298";
    public static final String SUCCESS_PET_ID = "1";


    //Texts
    public static final String CREATE_PET_400_MESSAGE = "bad input";
    public static final String UPDATE_PET_400_MESSAGE = "bad input";













    public static JSONObject readJson(String file){
        JSONParser jsonP = new JSONParser();
        try {
            String path = "src/test/java/resources/" + file +".json";
            JSONObject jsonO = (JSONObject)jsonP.parse(new FileReader(path));
            return  jsonO;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public static JSONArray getJSONArray(String fileName, String variable){
        JSONObject json = readJson(fileName);
        JSONArray var = (JSONArray) json.get(variable);
        return var;
    }

    public static String getString(String fileName, String variable){
        JSONObject json = readJson(fileName);
        String var = (String) json.get(variable);
        return var;
    }

    public static JSONObject getJSONObject(String fileName, String variable){
        JSONObject json = readJson(fileName);
        JSONObject var = (JSONObject) json.get(variable);
        return var;
    }

}

