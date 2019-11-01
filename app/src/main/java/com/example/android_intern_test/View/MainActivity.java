package com.example.android_intern_test.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.android_intern_test.Adapter.ShowAdapter;
import com.example.android_intern_test.Model.Shows;
import com.example.android_intern_test.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Shows> showsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ShowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fetching data
        initData();
        recyclerView = findViewById(R.id.recycler_view);
        //use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ShowAdapter(showsList);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 10; i++){
            showsList.add(new Shows("This is show" + i));
        }
    }
}
