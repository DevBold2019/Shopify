package com.example.swypepay.Fragments;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swypepay.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;


public class HomeFragment extends Fragment {

    LinearLayout linearLayoutHome;
    LinearLayout linearLayoutOverview;

    LinearLayout details;
    LinearLayout graph;

    TextView homeTextView;
    TextView overviewTextView;

    TextView graphViewTextView;
    TextView detailsTextView;

    PieChart pieChart;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


       View view=inflater.inflate(R.layout.fragment_home, container, false);

       linearLayoutHome = view.findViewById(R.id.homeLayout);
       linearLayoutOverview = view.findViewById(R.id.overviewLayout);

       graph = view.findViewById(R.id.graphLayout);
       details = view.findViewById(R.id.detailsLayout);

       homeTextView = view.findViewById(R.id.homeTextView);
       overviewTextView = view.findViewById(R.id.overviewTextView);


       graphViewTextView = view.findViewById(R.id.graphViewText);
       detailsTextView = view.findViewById(R.id.detailsTextView);
        graphViewTextView.setPaintFlags(graphViewTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        pieChart = view.findViewById(R.id.overViewChart);

       linearLayoutOverview.setVisibility(View.GONE);
       details.setVisibility(View.GONE);
       linearLayoutHome.setVisibility(View.VISIBLE);

       overviewTextView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               linearLayoutOverview.setVisibility(View.VISIBLE);
               linearLayoutHome.setVisibility(View.GONE);

           }
       });

        homeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayoutOverview.setVisibility(View.GONE);
                linearLayoutHome.setVisibility(View.VISIBLE);

            }
        });


        graphViewTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                graph.setVisibility(View.VISIBLE);
                details.setVisibility(View.GONE);

            }
        });

        detailsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                graph.setVisibility(View.GONE);
                details.setVisibility(View.VISIBLE);

            }
        });

       PopulateChart();



        return view;
    }

   public void PopulateChart(){

       ArrayList amount = new ArrayList();

       amount.add(new Entry(1500f, 0));
       amount.add(new Entry(15000f, 1));

       PieDataSet dataSet = new PieDataSet(amount, "");

       ArrayList year = new ArrayList();

       year.add("Money Out");
       year.add("Money in");


       PieData data = new PieData(year, dataSet);
       pieChart.setData(data);
       dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
       dataSet.setValueTextColor(Color.WHITE);
       dataSet.setSliceSpace(2f);
       pieChart.animateXY(5000, 5000);




   }




}