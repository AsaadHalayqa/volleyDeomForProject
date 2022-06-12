package birzeit.edubirzeit.volleydeomforproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    EditText edtFName;
    EditText edtLName;
    EditText edtPhone;
    EditText edtPassword;
    EditText edtEmail;
    EditText edtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtFName = findViewById(R.id.edtFName);
        edtLName = findViewById(R.id.edtLName);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtLoginEmail);
        edtAddress = findViewById(R.id.edtAddress);


    }

    public void btnSignUp_onClick(View view) {
//        UserInfo newUser = new UserInfo(null, edtFName.getText().toString(),
//                edtLName.getText().toString(),
//                edtPhone.getText().toString(), edtPassword.getText().toString(),
//                "c",edtEmail.getText().toString(),0,
//                edtAddress.getText().toString() );

        String firstName = edtFName.getText().toString();
        String lastName = edtLName.getText().toString();
        String phoneNum = edtPhone.getText().toString();
        String userPassword = edtPassword.getText().toString();
        String userRole = "c";
        String email = edtEmail.getText().toString();
        int points = 0;
        String address = edtAddress.getText().toString();

        addNewUserInfo( firstName, lastName,  phoneNum,  userPassword, userRole,
                email,  points,  address );


    }

    private void addNewUserInfo(String firstName,String lastName, String phoneNum, String userPassword,
    String userRole, String email, int points, String address ){
        String url = "http://10.0.2.2:84/project/add_user_info.php";

        RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(SignUpActivity.this,
                            jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(SignUpActivity.this,
                        "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.

                params.put("firstName", firstName);
                params.put("lastName", lastName);
                params.put("phoneNum", phoneNum);
                params.put("userPassword", userPassword);
                params.put("userRole", userRole);
                params.put("email", email);
                params.put("points", points +"");
                params.put("address", address);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);

    }
}