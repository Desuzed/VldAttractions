package com.example.vldattractions.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vldattractions.VldContentActivity;
import com.example.vldattractions.R;
import com.example.vldattractions.factory.VldObject;

import java.util.ArrayList;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {
    private static final String TAG = "RecViewAdapter";
    private Context contextMainActivity;
    private ArrayList <VldObject> vldObjectList = new ArrayList<>();
    private Typeface typeface;

    public RecViewAdapter(Context contextMainActivity) {
        this.contextMainActivity = contextMainActivity;
    }

    public void setItems(ArrayList <VldObject> list) {
        vldObjectList = list;
        notifyDataSetChanged();
    }

    public void clearItems() {
        if ( !vldObjectList.isEmpty()){
            vldObjectList.clear();
        }
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
        // Log.d(TAG, "onBindViewHolder: \n holder.getAdapterPosition() = " + holder.getAdapterPosition() + "; \n holder.getLayoutPosition() = " + holder.getLayoutPosition() + "; \n holder.getOldPosition() "+ holder.getOldPosition());
        VldObject vldObject = vldObjectList.get(position);
        holder.bind(vldObject);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.i(TAG, "onClick: on bind " + position);
                Intent intent = new Intent(contextMainActivity, VldContentActivity.class);
                intent.putExtra("vldObject", vldObject);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextMainActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vldObjectList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemRV;
        private ImageView imgItemRV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItemRV = itemView.findViewById(R.id.imgItemRV);
            tvItemRV = itemView.findViewById(R.id.tvItemRV);
            typeface = Typeface.createFromAsset(contextMainActivity.getAssets(), "fonts/PTMono-Regular.ttf");
            tvItemRV.setTypeface(typeface);
        }

        public void bind(VldObject object) {
            tvItemRV.setText(object.getCaption());
            Glide
                    .with(contextMainActivity)
                    .load(object.getPreviewImage())
                    .into(imgItemRV);
        }
    }
}
