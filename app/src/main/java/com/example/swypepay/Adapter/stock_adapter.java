package com.example.swypepay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.swypepay.Model.outOfStockModel;
import com.example.swypepay.R;

import java.util.List;

public class stock_adapter extends RecyclerView.Adapter<stock_adapter.viewholder> {

    List<outOfStockModel> list;
    Context context;

    public stock_adapter(List<outOfStockModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.stock_layout,parent,false);


        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        outOfStockModel model=list.get(position);

        String name=model.getItem_name();
        String status=model.getStock_status();

        holder.status.setText(status);
        holder.name.setText(name);

        Glide.with(context).load(model.getPicture()).placeholder(R.drawable.jumper).into(holder.image);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView status;
        TextView name;

        public viewholder(@NonNull View itemView) {
            super(itemView);

           image=itemView.findViewById(R.id.stockImage);
           status=itemView.findViewById(R.id.stockStatus);
           name=itemView.findViewById(R.id.stockName);


        }
    }
}
