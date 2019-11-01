package com.example.android_intern_test.AsyncTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class AsyncDownloadImage extends AsyncTask<String, Void, Bitmap> {

    private ImageView img;
    public AsyncDownloadImage(ImageView img){
        this.img = img;
    }
    @Override
    protected Bitmap doInBackground(String... url) {
        String imageURL = url[0];
        Bitmap bitmap = null;
        try{
            InputStream is = new java.net.URL(imageURL).openStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        img.setImageBitmap(result);
    }
}
