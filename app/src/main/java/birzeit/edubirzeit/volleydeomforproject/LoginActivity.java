package birzeit.edubirzeit.volleydeomforproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import birzeit.edubirzeit.volleydeomforproject.models.UserInfo;

public class LoginActivity extends AppCompatActivity {
    private RequestQueue queue;

    public static final String EMAIL = "EMAIL";
    public static final String PASS = "PASS";
    public static final String FLAG = "FLAG";
    private boolean flag = false;
    TextInputEditText edtLoginEmail;
    TextInputEditText edtLoginPassword;
    CheckBox chBox_RememberMe;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    ArrayList<UserInfo> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtLoginEmail = findViewById(R.id.edtLoginEmail);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);
        chBox_RememberMe = findViewById(R.id.chBox_RememberMe);

        setupSharedPreference();
        checkPrefs();

    }

    private void setupSharedPreference() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void checkPrefs() {
        flag = prefs.getBoolean(FLAG, false);

        if (flag){
            String email = prefs.getString(EMAIL, "");
            String password = prefs.getString(PASS, "");
            edtLoginEmail.setText(email);
            edtLoginPassword.setText(password);
            chBox_RememberMe.setChecked(true);


        }
    }

    public void btnLogin_onClick(View view) {

        String email = edtLoginEmail.getText().toString();
        String password = edtLoginPassword.getText().toString();

        //check if user in the database or not
        getUsers();

        for (int i= 0; i< users.size(); i++){
            if (users.get(i).getEmail().equals(email) && users.get(i).getUserPassword().equals(password)){
                if(chBox_RememberMe.isChecked()){
                    if(!flag){
                        editor.putString(EMAIL, email);
                        editor.putString(PASS, password);
                        editor.putBoolean(FLAG, true);
                        editor.commit();

                    }
                }
                Toast.makeText(this, "Yessssss", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Data entered incorrect!!", Toast.LENGTH_LONG).show();
            }

        }

    }


    //get All users and store them in UserInfo Object
    private void getUsers() {
        String url = "http://10.0.2.2:84/project/get_users.php";

        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                users =new ArrayList<>();

                for (int i = 0; i < response.length(); i++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        users.add(new UserInfo(obj.getInt("userInfoId"
                        ), obj.getString("firstName"), obj.getString("lastName"),
                                obj.getString("phoneNum"), obj.getString("userPassword"),
                                obj.getString("userRole"), obj.getString("email"),
                                obj.getInt("points"), obj.getString("address")));

                    }catch(JSONException exception){
                        Log.d("Error", exception.toString());
                    }
                }

                ArrayAdapter<UserInfo> adapter =new ArrayAdapter<>(
                        LoginActivity.this, android.R.layout.simple_list_item_1, users);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(LoginActivity.this, error.toString(),
                        Toast.LENGTH_SHORT).show();
                Log.d("Error_json", error.toString());
            }
        });
        queue.add(request);
    }


}