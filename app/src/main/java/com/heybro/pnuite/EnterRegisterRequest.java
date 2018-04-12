package com.heybro.pnuite;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hjune08 on 2017-12-07.
 */

public class EnterRegisterRequest extends StringRequest{
    final static private String URL = "http://hjune08.cafe24.com/EnterRegister.php";
    private Map<String, String> parameters;

    public EnterRegisterRequest(int enterNum, String enterID, String enterName, String enterPosition,
                                String enterLocation, String enterDate, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("enterNum", enterNum+"");
        parameters.put("enterID", enterID);
        parameters.put("enterName", enterName);
        parameters.put("enterPosition", enterPosition);
        parameters.put("enterLocation", enterLocation);
        parameters.put("enterDate", enterDate);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
