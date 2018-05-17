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

public class asciitoc extends AppCompatActivity {

    EditText input;
    Button gobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asciitoc);

        input = findViewById(R.id.ascii_input);
        gobtn = findViewById(R.id.btn_go_ascii);

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
                String uppercase;
                message = input.getText().toString();
                double check;

                if (message.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter a valid ASCII Code!", Toast.LENGTH_SHORT).show();
                } else {

                    if (!check_for_alpha(message)){
                        Toast.makeText(getApplicationContext(), "Enter a valid ASCII Code!", Toast.LENGTH_SHORT).show();
                    } else {
                        check = Double.parseDouble(message);
                        if (check != Math.ceil(check)) {
                            Toast.makeText(getApplicationContext(), "Enter a whole number!", Toast.LENGTH_SHORT).show();
                        } else {
                            if (message.length() > 3) {
                                Toast.makeText(getApplicationContext(), "Enter a valid ASCII code!", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(getApplicationContext(), res_ascii.class);
                                intent.putExtra("message", message);
                                startActivity(intent);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                finish();
                            }
                        }
                    }
                }
            }
        });
    }

    public void onBackPressed(){

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }

    public boolean check_for_alpha(String s){

        boolean ans=true;
        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            if((int)ch>57 || (int)ch<48){
                ans=false;
                break;
            }
        }
        return ans;
    }

    public void hideKeyboard(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
