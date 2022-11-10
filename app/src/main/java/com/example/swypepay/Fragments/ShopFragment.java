package com.example.swypepay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.swypepay.Adapter.stock_adapter;
import com.example.swypepay.R;
import com.example.swypepay.Model.outOfStockModel;


import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    RecyclerView recyclerView;
    List<outOfStockModel> list;
    stock_adapter adapter;
    outOfStockModel model;
    outOfStockModel model1;

    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_shop, container, false);

        textView=view.findViewById(R.id.seeAllTextView_2);


        recyclerView=view.findViewById(R.id.stockRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);

        list=new ArrayList<>();



         list.add(new outOfStockModel(R.drawable.guy,"Men T-Shirt","Out of stock"));
        list.add(new outOfStockModel(R.drawable.girl_yellow,"Women T-Shirt","Out of stock"));
         list.add(new outOfStockModel(R.drawable.trench,"Trench coat","Out of stock"));
         list.add(new outOfStockModel(R.drawable.tshirt,"Men T-Shirt","Out of stock"));
         list.add(new outOfStockModel(R.drawable.jumper,"Jumper Sweater","Out of stock"));
         list.add(new outOfStockModel(R.drawable.girl_1,"Crop Top","Out of stock"));
         list.add(new outOfStockModel(R.drawable.guy_1,"Turtle neck","Out of stock"));





        adapter=new stock_adapter(list,getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recyclerView.scrollToPosition(adapter.getItemCount()-2);

            }
        });



        return view;
    }
}