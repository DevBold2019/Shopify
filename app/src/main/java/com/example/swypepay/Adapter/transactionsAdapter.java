package com.example.swypepay.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.swypepay.Model.transactionsModel;
import com.example.swypepay.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class transactionsAdapter extends RecyclerView.Adapter<transactionsAdapter.viewholder> {

    List<transactionsModel> list;
    Context context;

    public transactionsAdapter(List<transactionsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public transactionsAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.transaction_layout,parent,false);


        return new viewholder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull transactionsAdapter.viewholder holder, int position) {

        transactionsModel model=list.get(position);

        holder.amount.setText("-Ksh "+model.getAmount());
        holder.amount.setTextColor(Color.parseColor(model.getColor()));
        //holder.imageView.setImageResource(Color.parseColor(model.toString()));
        holder.title.setText(model.getTitle());
        holder.date.setText(model.getDate());
        holder.description.setText(model.getDescription());


       // Glide.with(context).load(Color.parseColor(model.getColor())).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView date;
        TextView amount;
        CircleImageView imageView;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.transactionTitle);
            description=itemView.findViewById(R.id.transactionDescription);
            date=itemView.findViewById(R.id.transactionDate);
            amount=itemView.findViewById(R.id.transactionAmount);
            imageView=itemView.findViewById(R.id.statusImage);



        }
    }
}
