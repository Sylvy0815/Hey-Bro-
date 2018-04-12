package com.heybro.pnuite;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hjune08 on 2017-12-06.
 */

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://hjune08.cafe24.com/Register.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userName, int userAge,
                           String userEmail, String userLocation, String userPosition, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        parameters.put("userAge", userAge + "");
        parameters.put("userEmail", userEmail);
        parameters.put("userLocation", userLocation);
        parameters.put("userPosition", userPosition);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}


