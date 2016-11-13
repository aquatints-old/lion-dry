package com.example.wendy.lion_dry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ResHall extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_hall);

        Button btn = (Button) findViewById(R.id.dingus);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                //go();
                Intent i = new Intent(ResHall.this,Floor_View.class);
                startActivity(i);
            }
        });

    }





    public void go() {
        // go the heck to that new area let's assume it's hamilton until we figure it the heck out
        Intent intent = new Intent(this,Floor_View.class);
        startActivity(intent);
    }
}
