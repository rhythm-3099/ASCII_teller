package com.example.prhyt.ascii_teller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class res_ascii extends AppCompatActivity {

        TextView ascii_tv,char_tv;
        Button btn_main_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_ascii);
        setID();

        String ascii_maate;
        ascii_maate = getIntent().getStringExtra("message");
        ascii_tv.setText(ascii_maate);

        int ascii_number;
        ascii_number = Integer.parseInt(ascii_maate);

        if(ascii_number==0)
            char_tv.setText("NULL");
        else {
            char_tv.setText(Character.toString((char) ascii_number));
        }
        btn_main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(),asciitoc.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }

    public void setID(){
        ascii_tv = findViewById(R.id.ascii_res_ascii);
        char_tv = findViewById(R.id.char_res_ascii);
        btn_main_menu = findViewById(R.id.btn_main_menu);
    }
}
