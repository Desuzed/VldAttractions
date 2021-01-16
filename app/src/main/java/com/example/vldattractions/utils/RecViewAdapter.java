package com.example.vldattractions.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vldattractions.ListContentActivity;
import com.example.vldattractions.MainActivity;
import com.example.vldattractions.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {
    private List<String> captArray = new ArrayList<>();
    private static final String TAG = "RecViewAdapter";
    private Context contextMainActivity;
    private String [] picsArray;
 //   public static int categoryIndex;

    public RecViewAdapter(Context contextMainActivity) {
        this.contextMainActivity = contextMainActivity;
    }

    public void setItems(String[] captionsArray, String [] picsArray) {
        captArray = new ArrayList<>(Arrays.asList(captionsArray));
        this.picsArray = picsArray;
        notifyDataSetChanged();
    }

    public void clearItems() {
        captArray.clear();
        picsArray = new String[1];
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rec_view, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(captArray.get(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: on bind " + position);
                Intent intent = new Intent(contextMainActivity, ListContentActivity.class);
                intent.putExtra("categoryIndex", MainActivity.categoryIndex);
                intent.putExtra("position", position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextMainActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return captArray.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemRV;
        private ImageView imgItemRV;
        

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItemRV = itemView.findViewById(R.id.imgItemRV);
            tvItemRV = itemView.findViewById(R.id.tvItemRV);
            
//
        }

        public void bind(String name, int position) {
            tvItemRV.setText(name);
            Glide
                    .with(contextMainActivity)
                    .load(picsArray[position])
                    .into(imgItemRV);
        }

    }
}
