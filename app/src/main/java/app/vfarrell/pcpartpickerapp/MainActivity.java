package app.vfarrell.pcpartpickerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton launchPickerBtn;
    private ImageButton launchListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        launchPickerBtn = findViewById(R.id.launchPickerBtn);

        launchPickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ComponentPickerMenu.class));
            }
        });


        launchListBtn = findViewById(R.id.launchListBtn);
        launchListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SavedPartsActivity.class));
            }
        });
    }
}
