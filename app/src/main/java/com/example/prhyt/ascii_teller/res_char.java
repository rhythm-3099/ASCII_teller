package com.example.prhyt.ascii_teller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class res_char extends AppCompatActivity {

    Button btn_main_menu;
    TextView char_tv,ascii_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_char);

        setID();

        String char_maate;

        char_maate = getIntent().getStringExtra("message");
        char_tv.setText(char_maate);

        int ascii_number;
        char ch = char_maate.charAt(0);
        ascii_number = (int)ch;
        ascii_tv.setText(Integer.toString(ascii_number));

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
        startActivity(new Intent(getApplicationContext(),chartoa.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }

    public void setID(){

        btn_main_menu = findViewById(R.id.btn_main_menu);
        char_tv = findViewById(R.id.char_res_char);
        ascii_tv = findViewById(R.id.ascii_res_char);
    }
}
