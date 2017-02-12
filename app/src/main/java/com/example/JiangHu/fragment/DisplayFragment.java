package com.example.JiangHu.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.JiangHu.R;

/**
 * Created by zhibinxiao on 2017/2/12.
 */

public class DisplayFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_image,null);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_content);
        Bundle bundle = getArguments();
        int imageID = bundle.getInt("ImageSource");
        Glide.with(getActivity()).load(imageID)
                .placeholder(R.mipmap.empty)
                .error(R.mipmap.error)
                .fitCenter()
                .into(imageView);
        return  view;

    }
}
