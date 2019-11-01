package com.example.android_intern_test.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_intern_test.AsyncTask.AsyncDownloadImage;
import com.example.android_intern_test.R;

public class ShowsDetailActivity extends AppCompatActivity {

    private ImageView imgView;
    private TextView idView;
    private TextView urlView;
    private TextView nameView;
    private TextView seasonView;
    private TextView numberView;
    private TextView airdateView;
    private TextView airtimeView;
    private TextView airstampView;
    private TextView runtimeView;
    private TextView summaryView;
    private TextView linksView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows_detail);
        Intent intent = getIntent();
        int id = intent.getIntExtra(getString(R.string.id),0);
        String url = intent.getStringExtra(getString(R.string.url));
        String name = intent.getStringExtra(getString(R.string.name));
        int season = intent.getIntExtra(getString(R.string.season),0);
        int number = intent.getIntExtra(getString(R.string.number),0);
        String airdate = intent.getStringExtra(getString(R.string.airdate));
        String airtime = intent.getStringExtra(getString(R.string.airtime));
        String airstamp = intent.getStringExtra(getString(R.string.airstamp));
        int runtime = intent.getIntExtra(getString(R.string.runtime),0);
        String image = intent.getStringExtra(getString(R.string.image));
        String summary = intent.getStringExtra(getString(R.string.summary));
        String links = intent.getStringExtra(getString(R.string.links));

        imgView = findViewById(R.id.image_detail);
        idView = findViewById(R.id.id_detail);
        urlView = findViewById(R.id.url_detail);
        nameView = findViewById(R.id.name_detail);
        seasonView = findViewById(R.id.season_detail);
        numberView = findViewById(R.id.number_detail);
        airdateView = findViewById(R.id.airdate_detail);
        airtimeView = findViewById(R.id.airtime_detail);
        airstampView = findViewById(R.id.airstamp_detail);
        runtimeView = findViewById(R.id.runtime_detail);
        summaryView = findViewById(R.id.summary_detail);
        linksView = findViewById(R.id._links_detail);

        new AsyncDownloadImage(imgView).execute(image);
        idView.setText(String.valueOf(id));
        urlView.setText(url);
        nameView.setText(name);
        seasonView.setText(String.valueOf(season));
        numberView.setText(String.valueOf(number));
        airdateView.setText(airdate);
        airtimeView.setText(airtime);
        airstampView.setText(airstamp);
        runtimeView.setText(String.valueOf(runtime));
        summaryView.setText(Html.fromHtml(summary));
        linksView.setText(links);

        urlView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowsDetailActivity.this, WebViewActivity.class);
                intent.putExtra(getString(R.string.url), urlView.getText().toString());
                startActivity(intent);
            }
        });

        linksView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowsDetailActivity.this, WebViewActivity.class);
                intent.putExtra(getString(R.string.links), linksView.getText().toString());
                startActivity(intent);
            }
        });
    }
}
