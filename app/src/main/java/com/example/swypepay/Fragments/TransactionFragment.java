package com.example.swypepay.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swypepay.Adapter.transactionsAdapter;
import com.example.swypepay.R;

import com.example.swypepay.Model.transactionsModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;


public class TransactionFragment extends Fragment {

    RecyclerView recyclerView;
    List<transactionsModel> list;
    transactionsAdapter adapter;

    LineChart linechart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        linechart=view.findViewById(R.id.weeklyLineGraph);


        ArrayList<Entry> dataValues=new ArrayList<>();
        dataValues.add(new Entry(0,40));
        dataValues.add(new Entry(1,20));
        dataValues.add(new Entry(2,30));
        dataValues.add(new Entry(3,28));
        dataValues.add(new Entry(4,36));
        dataValues.add(new Entry(5,25));
        dataValues.add(new Entry(6,18));

        //LineData data = new LineData(dataSets);

      /*  LineDataSet set = new LineDataSet(dataValues, "Amount");
        ArrayList <ILineDataSet> dataSets=new ArrayList<>();

        set.setColor(Color.RED);
        LineData data = new LineData();
        data.addDataSet(set);
        linechart.setData(data);
        linechart.invalidate();*/

        ArrayList<String> xAXES = new ArrayList<>();
        ArrayList<Entry> yAXESsin = new ArrayList<>();
        ArrayList<Entry> yAXEScos = new ArrayList<>();
        double x = 0 ;
        int numDataPoints = 1000;
        for(int i=0;i<numDataPoints;i++){
            float sinFunction = Float.parseFloat(String.valueOf(Math.sin(x)));
            float cosFunction = Float.parseFloat(String.valueOf(Math.cos(x)));
            x = x + 0.1;
            yAXESsin.add(new Entry(sinFunction,i));
            yAXEScos.add(new Entry(cosFunction,i));
            xAXES.add(i, String.valueOf(x));
        }
        String[] xaxes = new String[xAXES.size()];
        for(int i=0; i<xAXES.size();i++){
            xaxes[i] = xAXES.get(i).toString();
        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet lineDataSet2 = new LineDataSet(yAXESsin,"Amount");
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColor(Color.RED);

        lineDataSets.add(lineDataSet2);

        linechart.setData(new LineData(xaxes,lineDataSets));

        linechart.setVisibleXRangeMaximum(65f);





        recyclerView=view.findViewById(R.id.transactionRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);

        list=new ArrayList<>();

        list.add(new transactionsModel("1500","Transfer to bank - completed","Complete","Sep 01","Equity Bank","#BC86F5"));
        list.add(new transactionsModel("500","Transfer to bank - completed","Complete","Sep 02","Payment from Sam","#FFA8A3"));
        list.add(new transactionsModel("1000","Transfer to bank - completed","Complete","Sep 03","Invoice from Obare","#6AF0E2"));
        list.add(new transactionsModel("100","Transfer to M-pesa - completed","Complete","Sep 04","M-Pesa Transfer","#4090B0"));
        list.add(new transactionsModel("800","Transfer to bank - completed","Complete","Sep 05","KWFT Bank","#F9FEFA"));
        list.add(new transactionsModel("200","Transfer to M-pesa- completed","Complete","Sep 06","Bank to Mpesa","#EEA900"));




        adapter=new transactionsAdapter(list,getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        return view;
    }
}