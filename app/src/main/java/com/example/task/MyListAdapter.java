package com.example.task;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.task.model.ResultItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private List<ResultItem> listdata;
    private Context context;

    // RecyclerView recyclerView;
    public MyListAdapter(List<ResultItem> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        context = parent.getContext();
        View listItem= layoutInflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ResultItem myListData = listdata.get(position);
        holder.tv_title.setText(myListData.getTitle());
        SimpleDateFormat formatOut = new SimpleDateFormat("dd MMMM yyyy");
        SimpleDateFormat formatIn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            holder.tv_date.setText(formatOut.format(formatIn.parse(myListData.getPublishedAt())));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Glide.with(context)
                .load(myListData.getImageUrl())
                .into(holder.imageView);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.card_dailog);
               TextView tv_title =  dialog.findViewById(R.id.tv_title);
               TextView tv_desc=  dialog.findViewById(R.id.tv_decs);
               ImageView iv_image=  dialog.findViewById(R.id.iv_top_image);

               tv_title.setText(myListData.getTitle());
               tv_desc.setText(myListData.getDescription());

                Glide.with(context)
                        .load(myListData.getImageUrl())
                        .circleCrop()
                        .into(iv_image);

                dialog.show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tv_title;
        public TextView tv_date;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }


    /*rivate void showdialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.customview, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }*/
}
