package app.vfarrell.pcpartpickerapp;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

public class RecyclerViewActivity extends AppCompatActivity {
    private List<CPU> cpusList = new ArrayList<>();
    private List<MOBO> mobosList = new ArrayList<>();
    private List<RAM> ramList = new ArrayList<>();
    private List<GPU> gpuList = new ArrayList<>();;
    private RecyclerView mRecyclerView;
    private CPUAdapter cpuAdapter;
    private MOBOAdapter moboAdapter;
    private RAMAdapter ramAdapter;
    private GPUAdapter gpuAdapter;
    private CPU cpu;
    private MOBO mobo;
    private RAM ram;
    private GPU gpu;
    private FirebaseDatabase firebaseDb;
    private DatabaseReference databaseRef;

    private Button addCPU;

    String getChoice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        addCPU = findViewById(R.id.AddCPUBtn);
        addCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCPU();
            }
        });

        databaseRef = FirebaseDatabase.getInstance().getReference("Components/");


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        Bundle extras = getIntent().getExtras();


        getChoice = extras.getString("choice");

        if (getChoice.equals("CPUs"))
        {
            loadCPUData();

        }
        else if (getChoice.equals("Motherboards"))
        {
            loadMOBOData();
        }
        else if (getChoice.equals("Memory"))
        {
            loadRAMData();
        }
        else if (getChoice.equals("Graphics Cards"))
        {
            loadGPUData();
        }
        else
        {
            loadCPUData();
        }


        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                if (getChoice.equals("CPUs")) {
                    cpu = cpusList.get(position);
                    Toast.makeText(getApplicationContext(), cpu.getCpuModel() + " is selected!", Toast.LENGTH_SHORT).show();
                } else if (getChoice.equals("Motherboards")) {
                    mobo = mobosList.get(position);
                    Toast.makeText(getApplicationContext(), mobo.getMoboModel() + " is selected!", Toast.LENGTH_SHORT).show();
                } else if (getChoice.equals("Memory")) {
                    ram = ramList.get(position);
                    Toast.makeText(getApplicationContext(), ram.getRamModel() + " is selected!", Toast.LENGTH_SHORT).show();
                } else if (getChoice.equals("Graphics Cards")) {
                    gpu = gpuList.get(position);
                    Toast.makeText(getApplicationContext(), gpu.getGpuModel() + " is selected!", Toast.LENGTH_SHORT).show();
                } else {
                    cpu = cpusList.get(position);
                    Toast.makeText(getApplicationContext(), cpu.getCpuModel() + " is selected!", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onLongClick(View view, int position) {
                if (getChoice.equals("CPUs")) {
                    cpu = cpusList.get(position);
                    Toast.makeText(getApplicationContext(), cpu.getCpuModel() + " is selected!", Toast.LENGTH_SHORT).show();
                    onClickAddCPU(cpu);

                } else if (getChoice.equals("Motherboards")) {
                    mobo = mobosList.get(position);
                    Toast.makeText(getApplicationContext(), mobo.getMoboModel() + " is selected!", Toast.LENGTH_SHORT).show();
                    onClickAddMOBO(mobo);

                } else if (getChoice.equals("Memory")) {
                    ram = ramList.get(position);
                    Toast.makeText(getApplicationContext(), ram.getRamModel() + " is selected!", Toast.LENGTH_SHORT).show();
                    onClickAddRAM(ram);

                } else if (getChoice.equals("Graphics Cards")) {
                    gpu = gpuList.get(position);
                    Toast.makeText(getApplicationContext(), gpu.getGpuModel() + " is selected!", Toast.LENGTH_SHORT).show();
                    onClickAddGPU(gpu);

                } else {
                    cpu = cpusList.get(position);
                    Toast.makeText(getApplicationContext(), cpu.getCpuModel() + " is selected!", Toast.LENGTH_SHORT).show();
                    onClickAddCPU(cpu);
                }

            }
        }));



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


    private List<RAM> loadRAMData() {
        databaseRef.child("ram").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { ram = dataSnapshot.getValue(RAM.class);
                ramList.add(ram);

                ramAdapter = new RAMAdapter(ramList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(ramAdapter);

                ramAdapter.notifyDataSetChanged();
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
        return ramList;
    }

    private List<GPU> loadGPUData() {
        databaseRef.child("gpu").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { gpu = dataSnapshot.getValue(GPU.class);
                gpuList.add(gpu);

                gpuAdapter = new GPUAdapter(gpuList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.setAdapter(gpuAdapter);

                gpuAdapter.notifyDataSetChanged();
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
        return gpuList;
    }








    public void onClickAddCPU(final CPU cpu) {

        databaseRef = FirebaseDatabase.getInstance().getReference();
        databaseRef.child("Saved").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (cpu.getCpuModel() == null) {
                    Toast.makeText(RecyclerViewActivity.this, "Error could not fetch Part Info", Toast.LENGTH_SHORT).show();
                } else if (dataSnapshot.hasChild(cpu.getCpuModel())) {
                    Toast.makeText(RecyclerViewActivity.this, "This Part is already the List", Toast.LENGTH_SHORT).show();
                } else {
                    addCPU(cpu);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("getItem:onCancelled", databaseError.toException());
            }
        });
    }
    private void addCPU (final CPU cpu) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerViewActivity.this);
        builder.setTitle("Add CPU to Saved List?");
        builder.setCancelable(true);
        builder.setPositiveButton("Add CPU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseRef = FirebaseDatabase.getInstance().getReference("Saved/" +cpu.getCpuModel());
                databaseRef.setValue(cpu);

                Toast.makeText(RecyclerViewActivity.this, "CPU added to List", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }




    public void onClickAddMOBO(final MOBO mobo) {

        databaseRef = FirebaseDatabase.getInstance().getReference();
        databaseRef.child("Saved").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (mobo.getMoboModel() == null) {
                    Toast.makeText(RecyclerViewActivity.this, "Error could not fetch Motherboard Info", Toast.LENGTH_SHORT).show();
                } else if (dataSnapshot.hasChild(mobo.getMoboModel())) {
                    Toast.makeText(RecyclerViewActivity.this, "This Motherboard is already the List", Toast.LENGTH_SHORT).show();
                } else {
                    addMOBO(mobo);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("getItem:onCancelled", databaseError.toException());
            }
        });
    }
    private void addMOBO (final MOBO mobo) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerViewActivity.this);
        builder.setTitle("Add Motherboard to Saved List?");
        builder.setCancelable(true);
        builder.setPositiveButton("Add Motherboard", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseRef = FirebaseDatabase.getInstance().getReference("Saved/" +mobo.getMoboModel());
                databaseRef.setValue(mobo);

                Toast.makeText(RecyclerViewActivity.this, "Motherboard added to List", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }




    public void onClickAddRAM(final RAM ram) {

        databaseRef = FirebaseDatabase.getInstance().getReference();
        databaseRef.child("Saved").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (ram.getRamModel() == null) {
                    Toast.makeText(RecyclerViewActivity.this, "Error could not fetch Memory Info", Toast.LENGTH_SHORT).show();
                } else if (dataSnapshot.hasChild(ram.getRamModel())) {
                    Toast.makeText(RecyclerViewActivity.this, "This Memory is already the List", Toast.LENGTH_SHORT).show();
                } else {
                    addRAM(ram);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("getItem:onCancelled", databaseError.toException());
            }
        });
    }
    private void addRAM (final RAM ram) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerViewActivity.this);
        builder.setTitle("Add Memory to Saved List?");
        builder.setCancelable(true);
        builder.setPositiveButton("Add Memory", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseRef = FirebaseDatabase.getInstance().getReference("Saved/" +ram.getRamModel());
                databaseRef.setValue(ram);

                Toast.makeText(RecyclerViewActivity.this, "Memory added to List", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }




    public void onClickAddGPU(final GPU gpu) {

        databaseRef = FirebaseDatabase.getInstance().getReference();
        databaseRef.child("Saved").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (gpu.getGpuModel() == null) {
                    Toast.makeText(RecyclerViewActivity.this, "Error could not fetch GPU Info", Toast.LENGTH_SHORT).show();
                } else if (dataSnapshot.hasChild(gpu.getGpuModel())) {
                    Toast.makeText(RecyclerViewActivity.this, "This GPU is already the List", Toast.LENGTH_SHORT).show();
                } else {
                    addGPU(gpu);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("getItem:onCancelled", databaseError.toException());
            }
        });
    }
    private void addGPU (final GPU gpu) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerViewActivity.this);
        builder.setTitle("Add GPU to Saved List?");
        builder.setCancelable(true);
        builder.setPositiveButton("Add GPU", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseRef = FirebaseDatabase.getInstance().getReference("Saved/" +gpu.getGpuModel());
                databaseRef.setValue(gpu);

                Toast.makeText(RecyclerViewActivity.this, "Graphics Card added to List", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }



    private void createCPU() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerViewActivity.this);
        builder.setTitle("Create New CPU");


        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);


        final EditText text_manu = new EditText(this);
        text_manu.setHint("Manufacturer");
        layout.addView(text_manu);

        final EditText text_model = new EditText(this);
        text_model.setHint("Model");
        layout.addView(text_model);

        final EditText text_cores = new EditText(this);
        text_cores.setHint("Cores");
        layout.addView(text_cores);

        final EditText text_clock = new EditText(this);
        text_clock.setHint("ClockSpeed");
        layout.addView(text_clock);

        final EditText text_boost = new EditText(this);
        text_boost.setHint("BoostSpeed");
        layout.addView(text_boost);

        final EditText text_socket = new EditText(this);
        text_socket.setHint("SocketType");
        layout.addView(text_socket);

        final EditText text_memory = new EditText(this);
        text_memory.setHint("MemoryMax");
        layout.addView(text_memory);

        final EditText text_tdp = new EditText(this);
        text_tdp.setHint("TDP");
        layout.addView(text_tdp);


        builder.setView(layout);


        builder.setCancelable(true);
        builder.setPositiveButton("Add to CPU List", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String manu = text_manu.getText().toString();
                String model = text_model.getText().toString();
                String cores = text_cores.getText().toString();
                String clock = text_clock.getText().toString();
                String boost = text_boost.getText().toString();
                String socket = text_socket.getText().toString();
                String maxMemory = text_memory.getText().toString();
                String tdp = text_tdp.getText().toString();


                if (manu.isEmpty() || model.isEmpty() || cores.isEmpty() || clock.isEmpty()|| boost.isEmpty() || socket.isEmpty() || maxMemory.isEmpty() || tdp.isEmpty())
                {
                    Toast.makeText(RecyclerViewActivity.this, "Enter all Fields", Toast.LENGTH_LONG).show();
                }
                else {
                    CPU cpu = new CPU(manu, model, cores, clock, boost, socket, maxMemory, tdp);


                    databaseRef = FirebaseDatabase.getInstance().getReference("Components/cpu/" + cpu.getCpuModel());
                    databaseRef.setValue(cpu);
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }



    private void removeItem(CPU cpu) {

        databaseRef = FirebaseDatabase.getInstance().getReference("Saved/" +cpu.getCpuModel());
        databaseRef.removeValue();

        Toast.makeText(this, "Part Removed from List", Toast.LENGTH_SHORT).show();

        cpuAdapter.notifyDataSetChanged();
    }
}
