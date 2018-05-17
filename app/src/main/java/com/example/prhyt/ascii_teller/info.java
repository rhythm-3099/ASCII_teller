package com.example.prhyt.ascii_teller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class info extends AppCompatActivity {

    ImageButton github,linkedin;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        github = findViewById(R.id.github);
        linkedin = findViewById(R.id.linkedin);

        back = findViewById(R.id.btn_back);

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.linkedin.com/in/rhythm-patel-300499/"));
                startActivity(intent);
                //finish();
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/rhythm-3099"));
                startActivity(intent);
                //finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(info.this,MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                finish();
            }
        });
    }

    public void onBackPressed(){
        startActivity(new Intent(info.this,MainActivity.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}
