package app.vfarrell.pcpartpickerapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import app.vfarrell.pcpartpickerapp.Adapters.MOBOAdapter;
import app.vfarrell.pcpartpickerapp.Adapters.RecyclerTouchListener;
import app.vfarrell.pcpartpickerapp.Adapters.CPUAdapter;
import app.vfarrell.pcpartpickerapp.Constructors.CPU;
import app.vfarrell.pcpartpickerapp.Constructors.MOBO;

public class RecyclerViewActivity extends AppCompatActivity {
    private List<CPU> cpusList = new ArrayList<>();
    private List<MOBO> mobosList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private CPUAdapter cpuAdapter;
    private MOBOAdapter moboAdapter;
    private CPU cpu;
    private MOBO mobo;
    private FirebaseDatabase firebaseDb;
    private DatabaseReference databaseRef;

    String getChoice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        databaseRef = FirebaseDatabase.getInstance().getReference("Components/");


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        Bundle extras = getIntent().getExtras();


        getChoice = extras.getString("choice");

        if (getChoice.equals("CPUs"))
        {
            Log.i("CHOICE>>>>>>", getChoice);
            loadCPUData();
        }
        else if (getChoice.equals("Motherboards"))
        {
            Log.i("CHOICE>>>>>>", getChoice);
            loadMOBOData();
        }
        else
        {
            loadCPUData();
        }



//        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                cpu = cpusList.get(position);
//                Toast.makeText(getApplicationContext(), cpu.getCpuModel() + " is selected!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//                cpu = cpusList.get(position);
//
//                onClickAddItem(cpu);
//            }
//        }));



    }

    private List<CPU> loadCPUData() {
        databaseRef.child("cpu").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                cpu = dataSnapshot.getValue(CPU.class);
                cpusList.add(cpu);

                cpuAdapter = new CPUAdapter(cpusList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(cpuAdapter);

                cpuAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return cpusList;
    }

    private List<MOBO> loadMOBOData() {
        databaseRef.child("motherboards").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { mobo = dataSnapshot.getValue(MOBO.class);
                mobosList.add(mobo);

                moboAdapter = new MOBOAdapter(mobosList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(moboAdapter);

                moboAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return mobosList;
    }
























    public void onClickAddItem(final CPU cpu) {


        databaseRef = FirebaseDatabase.getInstance().getReference();
        databaseRef.child("Saved").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (cpu.getCpuModel() == null) {
                    Toast.makeText(RecyclerViewActivity.this, "Error could not fetch Part Info", Toast.LENGTH_SHORT).show();
                } else if (dataSnapshot.hasChild(cpu.getCpuModel())) {
                    Toast.makeText(RecyclerViewActivity.this, "This Part is already the List", Toast.LENGTH_SHORT).show();
                } else {
                    addPart(cpu);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("getItem:onCancelled", databaseError.toException());
            }
        });
    }

    private void addPart(CPU cpu) {

        databaseRef = FirebaseDatabase.getInstance().getReference("Saved/" +cpu.getCpuModel());
        databaseRef.setValue(cpu);

        Toast.makeText(this, "Part added to List", Toast.LENGTH_SHORT).show();

    }

    private void removeItem(CPU cpu) {

        databaseRef = FirebaseDatabase.getInstance().getReference("Saved/" +cpu.getCpuModel());
        databaseRef.removeValue();

        Toast.makeText(this, "Part Removed from List", Toast.LENGTH_SHORT).show();

        cpuAdapter.notifyDataSetChanged();
    }
}
