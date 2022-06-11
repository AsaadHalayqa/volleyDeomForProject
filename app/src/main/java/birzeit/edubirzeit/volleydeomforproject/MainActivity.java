package birzeit.edubirzeit.volleydeomforproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import birzeit.edubirzeit.volleydeomforproject.models.Category;
import birzeit.edubirzeit.volleydeomforproject.models.UserInfo;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;

//    private List<Category> items = new ArrayList<>();
    private RecyclerView recycler;
    private static  final String BASE_URL = "http://10.0.2.2:84/project/get_cats.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.cat_recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        queue = Volley.newRequestQueue(this);
    }

    public void btn_getCats_OnClick(View view) {

        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, BASE_URL,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<Category> categories =new ArrayList<>();

                for (int i = 0; i < response.length(); i++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        categories.add(new Category(obj.getInt("catId"), obj.getString("catName"),
                                obj.getString("catImage")));

                    }catch(JSONException exception){
                        Log.d("Error", exception.toString());
                    }
                }
                CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(MainActivity.this,
                        categories);
                recycler.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, error.toString(),
                        Toast.LENGTH_SHORT).show();
                Log.d("Error_json", error.toString());
            }
        });
        queue.add(request);
    }

    //get All users and store them in UserInfo Object
//    public void btn_getUsers_OnClick(View view) {
//        ListView lst = findViewById(R.id.lst_cats);
//        String url = "http://10.0.2.2:84/project/get_users.php";
//
//        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, url,
//                null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                ArrayList<UserInfo> users =new ArrayList<>();
//
//                for (int i = 0; i < response.length(); i++){
//                    try {
//                        JSONObject obj = response.getJSONObject(i);
//                        users.add(new UserInfo(obj.getInt("userInfoId"
//                        ), obj.getString("firstName"), obj.getString("lastName"),
//                                obj.getString("phoneNum"), obj.getString("userPassword"),
//                                obj.getString("userRole"), obj.getString("email"),
//                                obj.getInt("points"), obj.getString("address")));
//
//                    }catch(JSONException exception){
//                        Log.d("Error", exception.toString());
//                    }
//                }
//
//                ArrayAdapter<UserInfo> adapter =new ArrayAdapter<>(
//                        MainActivity.this, android.R.layout.simple_list_item_1, users);
//
//                lst.setAdapter(adapter);
////                Log.d("Asaad", "Hi Hi Hi ");
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Toast.makeText(MainActivity.this, error.toString(),
//                        Toast.LENGTH_SHORT).show();
//                Log.d("Error_json", error.toString());
//            }
//        });
//        queue.add(request);
//    }



}