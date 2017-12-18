package charge.prueba1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NB23626 on 15/11/2017.
 */

public class RegisterEstacionRequest extends StringRequest {
    private static final String REGISTERESTATION_REQUEST_URL="http://192.168.1.37/RegisterStation.php";
    private Map<String,String> params;
    public RegisterEstacionRequest (String name, String price1, String price2, int cargadores, int energy, String latitude, String longitude, Response.Listener<String> listener) {

        super(Method.POST, REGISTERESTATION_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("price1",price1);
        params.put("price2", price2);
        params.put("cargadores",cargadores+"");
        params.put("energy",energy+"");
        params.put("latitude",latitude);
        params.put("longitude",longitude);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
