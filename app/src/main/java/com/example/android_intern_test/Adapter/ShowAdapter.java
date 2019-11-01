package com.example.android_intern_test.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_intern_test.AsyncTask.AsyncDownloadImage;
import com.example.android_intern_test.Model.Shows;
import com.example.android_intern_test.R;
import com.example.android_intern_test.View.MainActivity;
import com.example.android_intern_test.View.ShowsDetailActivity;

import java.util.List;

/*
    Defining an adapter to adapt view
 */
public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {

    private List<Shows> mShowList;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        View showView;
        ImageView showImage;
        TextView showSummary;

        public ViewHolder(View view){
            super(view);
            showView = view;
            showImage = view.findViewById(R.id.show_image);
            showSummary = view.findViewById(R.id.show_summary);
        }
    }

    public ShowAdapter(List<Shows> showsList){
        mShowList = showsList;
    }

    //inflate the view holder
    @NonNull
    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.show_item_view,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.showView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Shows show = mShowList.get(position);
//                Intent intent = new Intent(mContext, ShowsDetailActivity.class);
//                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    //set data in the item view
    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ViewHolder viewHolder, int i) {
        Shows shows = mShowList.get(i);

        new AsyncDownloadImage(viewHolder.showImage).execute(shows.getImage().getMedium());
        viewHolder.showSummary.setText(Html.fromHtml(shows.getSummary()).toString());
    }

    //return size
    @Override
    public int getItemCount() {
        return mShowList.size();
    }
}
