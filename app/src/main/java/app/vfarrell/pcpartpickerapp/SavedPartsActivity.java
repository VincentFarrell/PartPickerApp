package app.vfarrell.pcpartpickerapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import app.vfarrell.pcpartpickerapp.Adapters.GPUAdapter;
import app.vfarrell.pcpartpickerapp.Adapters.MOBOAdapter;
import app.vfarrell.pcpartpickerapp.Adapters.RAMAdapter;
import app.vfarrell.pcpartpickerapp.Adapters.RecyclerTouchListener;
import app.vfarrell.pcpartpickerapp.Adapters.CPUAdapter;
import app.vfarrell.pcpartpickerapp.Constructors.CPU;
import app.vfarrell.pcpartpickerapp.Constructors.GPU;
import app.vfarrell.pcpartpickerapp.Constructors.MOBO;
import app.vfarrell.pcpartpickerapp.Constructors.RAM;

public class SavedPartsActivity extends AppCompatActivity {

    private List<CPU> cpusList = new ArrayList<>();
    private List<MOBO> mobosList = new ArrayList<>();
    private List<RAM> ramList = new ArrayList<>();
    private List<GPU> gpuList = new ArrayList<>();;
    private CPUAdapter cpuAdapter;
    private MOBOAdapter moboAdapter;
    private RAMAdapter ramAdapter;
    private GPUAdapter gpuAdapter;
    private CPU cpu;
    private MOBO mobo;
    private RAM ram;
    private GPU gpu;
    private RecyclerView mRecyclerView;
    private FirebaseDatabase firebaseDb;
    private DatabaseReference databaseRef;
    private TextView noSavedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_parts);

        noSavedText = findViewById(R.id.savedHiddenText);
        noSavedText.setVisibility(View.VISIBLE);

        databaseRef = FirebaseDatabase.getInstance().getReference("Saved/");


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        loadSavedData();




        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                cpu = cpusList.get(position);
                Toast.makeText(getApplicationContext(), cpu.getCpuModel() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                cpu = cpusList.get(position);

                removePart(cpu);
            }
        }));
    }

    private List<CPU> loadSavedData() {
        databaseRef.addChildEventListener(new ChildEventListener() {
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

                if(!cpusList.isEmpty()) {
                    noSavedText.setVisibility(View.INVISIBLE);
                }

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

    private void removePart(CPU cpu) {

        databaseRef = FirebaseDatabase.getInstance().getReference("Saved/" +cpu.getCpuModel());
        databaseRef.removeValue();

        Toast.makeText(this, "Part Removed from List", Toast.LENGTH_SHORT).show();

    }
}
