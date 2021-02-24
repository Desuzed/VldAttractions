package com.example.vldattractions.utils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.vldattractions.R;

public class FragmentToolbar extends Fragment {
    private ImageView toolbarImage;
    private TextView tvFragmentToolbar;
    private String resUri;
    private int position;
    public FragmentToolbar(String resUri, int position) {
        this.resUri = resUri;
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.toolbar_fragment, container, false);
        toolbarImage = view.findViewById(R.id.toolbarImage);
        tvFragmentToolbar = view.findViewById(R.id.tvFragmentToolbar);
        Glide.with(this).load(resUri).into(toolbarImage);
        toolbarImage.setImageResource(R.drawable.not_bookmarked);
        tvFragmentToolbar.setText((position + 1) + "/3");
        return view;
    }
}
