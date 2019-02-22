package app.vfarrell.pcpartpickerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import app.vfarrell.pcpartpickerapp.Adapters.RecyclerViewAdapter;
import app.vfarrell.pcpartpickerapp.Constructors.CPU;

public class RecyclerViewList extends AppCompatActivity {
    private List<CPU> cpusList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cpusList = new ArrayList<>();






        //add cardlist to recyclerview



        prepareMovieData();
        mAdapter = new RecyclerViewAdapter(cpusList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


    }

    private void prepareMovieData() {
        CPU cpu = new CPU("AMD", "Ryzen 3 1200", "4 Cores", "3.1GHz", "3.4GHz", "AM4", "64 GB", "65W");
        cpusList.add(cpu);

        cpu = new CPU("AMD", "Ryzen 5 1600", "6 Cores", "3.2GHz", "3.6GHz", "AM4", "64 GB", "65W");
        cpusList.add(cpu);

        cpu = new CPU("Intel", "i5-6600K", "4 Cores", "3.5GHz", "3.9GHz", "FCLGA1151", "64 GB", "91W");
        cpusList.add(cpu);

        cpu = new CPU("AMD", "FX-8350", "8 Cores", "4Hz", "4.2GHz", "AM3+", "64 GB", "125W");
        cpusList.add(cpu);

        mAdapter.notifyDataSetChanged();
    }
}