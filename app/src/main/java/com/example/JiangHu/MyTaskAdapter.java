package com.example.JiangHu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.JiangHu.adapter.AutoRVAdapter;

import java.util.List;

/**
 * Created by nick on 15/10/26.
 */
public class MyTaskAdapter extends AutoRVAdapter {

    private Context context;

    public MyTaskAdapter(Context context, List<TaskItem> list) {
        super(context, list);
        this.context = context;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.item_order_recyclerview;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final TaskItem item=(TaskItem) list.get(position);
        holder.getTextView(R.id.titleTextView).setText(item.getTitle());
        holder.getTextView(R.id.dateTextView).setText(item.getBeginDate());
        holder.getImageView(R.id.titleImageView).setImageResource(item.getImageID());


        String status = item.getStatus();
        if (status.equals("1")){
            status = Constant.Status_doing;
            holder.getTextView(R.id.orderType).setTextColor(context.getResources().getColor(R.color.awesome_orange));
        }else{
            status = Constant.Status_done;
            holder.getTextView(R.id.orderType).setTextColor(context.getResources().getColor(R.color.awesome_gray));
        }

        String missionType = item.getType() > 0 ? Constant.MissionTypes[item.getType()] : Constant.DISTANCETYPE[Constant.Distatnce_system];
        holder.getTextView(R.id.orderType).setText(missionType);
        holder.getTextView(R.id.info).setText(item.getContent());
        holder.getTextView(R.id.orderPrice).setText(item.getPayment());
        holder.getTextView(R.id.distance).setText(item.getDistance() > 0 ? String.format("%.1f", item.getDistance()/1000.0) + "km" : "");
        holder.getImageView(R.id.titleImageView).setImageResource(item.getImageID());

        holder.getConvertView().findViewById(R.id.item_order_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra(Constant.ID, item.getId());
                context.startActivity(intent);
            }
        });

    }
}