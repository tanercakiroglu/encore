package configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JSONUtil {

    private static final String PARSE_EXCEPTION="Json parse exception";
    private static final String SUCCESS_PROCESS="İşlemeniz başarıyla gerçekleşti";

    public static String getJSONResultWithBusinessError(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "business_error");
        map.put("message", message);
        String response = null;
        try {
            response=	convertToJSON(map);
        } catch (Exception e) {
            response="Json parse exception ";
        }
        return response;
    }

    public static String getJSONResultWithSystemError(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "system_error");
        map.put("message", message);
        String response;
        try {
            response=	convertToJSON(map);
        } catch (Exception e) {
            response=PARSE_EXCEPTION;
        }
        return response;
    }


    public static String getJSONResultWithSuccess(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "success");
        map.put("message", SUCCESS_PROCESS);
        map.put("data", data);
        String response = null;
        try {
            response=	convertToJSON(map);
        } catch (Exception e) {
            response=PARSE_EXCEPTION;
        }
        return response;
    }


    public static String getJSONResultWithValidationError(Object message) {

        Map<String, Object> map = new HashMap<>();
        map.put("status", "validation_error");
        map.put("message", message);
        String response = null;
        try {
            response=	convertToJSON(map);
        } catch (Exception e) {
            response=PARSE_EXCEPTION;
        }
        return response;

    }

    private static String convertToJSON(Object data) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(data);
    }
}
