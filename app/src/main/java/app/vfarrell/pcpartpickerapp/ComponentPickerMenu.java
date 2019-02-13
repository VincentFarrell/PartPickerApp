package app.vfarrell.pcpartpickerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import app.vfarrell.pcpartpickerapp.Adapters.MenuListAdapter;


public class ComponentPickerMenu extends AppCompatActivity {

    int[] images = {R.drawable.navcpu, R.drawable.navmotherboard, R.drawable.navmemory, R.drawable.navvideocard, R.drawable.navssd, R.drawable.navpowersupply, R.drawable.navcase};

    String[] components = {"CPUs", "Motherboards", "Memory", "Graphics Cards", "SSDs", "PSUs", "Cases"};

    ListView listView;

    MenuListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_picker_menu);

        listView = (ListView) findViewById(R.id.menu_ListView);

        listAdapter = new MenuListAdapter(ComponentPickerMenu.this, components, images);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(ComponentPickerMenu.this, components[i], Toast.LENGTH_SHORT).show();

            }
        });


    }
}
