package charge.prueba1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NB23626 on 08/11/2017.
 */

public class RegisterRequest extends StringRequest{

 private static final String REGISTER_REQUEST_URL="http://192.168.1.37/Register.php";
    private Map<String,String> params;
    public RegisterRequest (String name, String username, String age, String password, String email, String pais, String dni, int telefono, Response.Listener<String> listener) {

        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("age", age);
        params.put("password", password);
        params.put("email", email);
        params.put("pais", pais);
        params.put("dni", dni);
        params.put("telefono", telefono+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
