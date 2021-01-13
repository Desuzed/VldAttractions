package com.example.vldattractions.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vldattractions.R;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter <ListItemClass> {
    private LayoutInflater inflater;
    private List <ListItemClass> list = new ArrayList<>();
    private Context context;


    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull List <ListItemClass> list, LayoutInflater layoutInflater) {
        super(context, resource, list);
        this.inflater = layoutInflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        ListItemClass listItemClass = list.get(position);
        if (convertView==null){
            convertView = inflater.inflate(R.layout.list_view_item, null, false);
            viewHolder = new ViewHolder();
            viewHolder.image = convertView.findViewById(R.id.imageItem);
            viewHolder.name = convertView.findViewById(R.id.tvName);
            viewHolder.secondName = convertView.findViewById(R.id.tvSecondName);

        }else   {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.name.setText(listItemClass.getName());
        viewHolder.secondName.setText(listItemClass.getSecondName());
        viewHolder.image.setImageResource(listItemClass.getImageId());

        return convertView;
    }

    private class ViewHolder {
        TextView name;
        TextView secondName;
        ImageView image;

    }
}
