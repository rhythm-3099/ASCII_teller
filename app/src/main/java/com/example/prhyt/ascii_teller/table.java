package com.example.prhyt.ascii_teller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class table extends AppCompatActivity {

    Button main_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        main_menu = findViewById(R.id.btn_main_menu);

        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}
