package com.example.android_intern_test.View;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.android_intern_test.Adapter.ShowAdapter;
import com.example.android_intern_test.AsyncTask.AsyncDownloadImage;
import com.example.android_intern_test.Model.Shows;
import com.example.android_intern_test.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private List<Shows> showsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ShowAdapter adapter;
    private static final int UPDATED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fetching data
        sendRequestWithOkHttp();
        recyclerView = findViewById(R.id.recycler_view);
        //use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ShowAdapter(showsList);
        recyclerView.setAdapter(adapter);
    }
    private Handler handler = new Handler() {
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATED:
                    adapter = new ShowAdapter(showsList);
                    recyclerView.setAdapter(adapter);
                    break;
                default:
                    break;
            }
        }
    };
    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(getString(R.string.api))
                            .build();
                    //return json array
                    Response response = client.newCall(request).execute();
                    //convert json to string
                    String responseData = response.body().string();
                    Log.d("MainActivity", responseData);
                    parseJSONWithGSON(responseData);
                    //send message to handler after update
                    Message message = new Message();
                    message.what = UPDATED;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithGSON(String jsonData){
        Gson gson = new Gson();
        showsList = gson.fromJson(jsonData, new TypeToken<List<Shows>>(){}.getType());
        for (Shows shows: showsList){
            Log.d("MainActivity", "id is " + shows.getImage().getMedium());
        }
    }
}
