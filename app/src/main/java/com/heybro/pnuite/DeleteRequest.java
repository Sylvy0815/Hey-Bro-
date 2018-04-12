package com.heybro.pnuite;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hjune08 on 2017-12-06.
 */

public class DeleteRequest extends StringRequest {

    final static private String URL = "http://hjune08.cafe24.com/Delete.php";
    private Map<String, String> parameters;

    public DeleteRequest(String userID, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
