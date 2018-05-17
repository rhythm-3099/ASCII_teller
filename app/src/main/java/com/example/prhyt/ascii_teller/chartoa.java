package com.example.prhyt.ascii_teller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class chartoa extends AppCompatActivity {

    EditText input;
    Button gobtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chartoa);

        input = findViewById(R.id.char_input);
        gobtn = findViewById(R.id.btn_go_char);

        input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;
                message = input.getText().toString();
                if (message.length() != 1) {
                    Toast.makeText(getApplicationContext(), "Enter only a character!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), res_char.class);
                    intent.putExtra("message", message);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            }
        });
    }

    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }

    public void hideKeyboard(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
