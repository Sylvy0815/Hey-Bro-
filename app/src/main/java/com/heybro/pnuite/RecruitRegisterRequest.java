package com.heybro.pnuite;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hjune08 on 2017-12-07.
 */

public class RecruitRegisterRequest extends StringRequest {
    final static private String URL = "http://hjune08.cafe24.com/RecruitRegister.php";
    private Map<String, String> parameters;

    public RecruitRegisterRequest(int recruitNum, String recruitID, String recruitName, String recruitPosition,
                           String recruitLocation, String recruitDate, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("recruitNum", recruitNum+"");
        parameters.put("recruitID", recruitID);
        parameters.put("recruitName", recruitName);
        parameters.put("recruitPosition", recruitPosition);
        parameters.put("recruitLocation", recruitLocation);
        parameters.put("recruitDate", recruitDate);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
