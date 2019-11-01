package com.example.android_intern_test.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android_intern_test.Model.Shows;
import com.example.android_intern_test.R;
import java.util.List;

/*
    Defining an adapter to adapt view
 */
public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {

    private List<Shows> mShowList;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView showImage;
        TextView showSummary;

        public ViewHolder(View view){
            super(view);
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
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //set data in the item view
    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ViewHolder viewHolder, int i) {
        Shows shows = mShowList.get(i);
        viewHolder.showImage.setImageURI();
        viewHolder.showSummary.setText(shows.getSummary());
    }

    //return size
    @Override
    public int getItemCount() {
        return mShowList.size();
    }
}
