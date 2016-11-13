package com.example.wendy.lion_dry;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;


public class Floor_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor__view);



        ArrayList<Machine> machineList = getWasherFloorList();

        for(int i = 0; i < 3; i++){

            ImageButton theButton = (ImageButton) findViewByID(R.id.wash_ + i);
            Machine theMachine = machineList.get(i);

            if(theMachine.isBusy){
                theButton.setImageResource(R.drawable.washer_red);
            }

        }

        machineList = getDryerFloorList();

        for(int i = 0; i < 3; i++){

            ImageButton theButton = (ImageButton) findViewByID(R.id.wash_ + i);
            Machine theMachine = machineList.get(i);

            if(theMachine.isBusy){
                theButton.setImageResource(R.drawable.dryer_red);
            }



        }

    }



}
