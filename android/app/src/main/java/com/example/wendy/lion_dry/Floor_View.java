package com.example.wendy.lion_dry;


import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBQueryExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedQueryList;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;

import java.util.ArrayList;
import java.util.Arrays;


public class Floor_View extends AppCompatActivity {

    String bldg; // stores what building we're lookin in

    AmazonDynamoDBClient ddbClient;
    DynamoDBMapper mapper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor__view);

        Button btn = (Button) findViewById(R.id.brapple);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //go();
                Intent i = new Intent(Floor_View.this,TrendView.class);
                startActivity(i);
            }
        });



        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-east-1:9ab3a587-a013-440b-b86d-7d50e8861f75", // Identity Pool ID
                Regions.US_EAST_1 // Region
        );

        ddbClient = new AmazonDynamoDBClient(credentialsProvider);
        mapper = new DynamoDBMapper(ddbClient);

        //temporarily assign to hamilton until we figure out how to pass bldg in from reshall
        bldg = "Hamilton";

        ArrayList<ImageButton> buttonList = new ArrayList<>();
        ArrayList<Machine> machineList = new ArrayList<>();
//        System.err.println(getWasherFloorList(bldg).get(0).getLocalID());

        ImageButton btn_wash_1 = (ImageButton) findViewById(R.id.wash_1);
        ImageButton btn_wash_2 = (ImageButton) findViewById(R.id.wash_2);
        ImageButton btn_wash_3 = (ImageButton) findViewById(R.id.wash_3);
        ImageButton btn_dryer_1 = (ImageButton) findViewById(R.id.dryer_1);
        ImageButton btn_dryer_2 = (ImageButton) findViewById(R.id.dryer_2);
        ImageButton btn_dryer_3 = (ImageButton) findViewById(R.id.dryer_3);

        buttonList.add(btn_wash_1);
        buttonList.add(btn_wash_2);
        buttonList.add(btn_wash_3);
        buttonList.add(btn_dryer_1);
        buttonList.add(btn_dryer_2);
        buttonList.add(btn_dryer_3);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        //Wash1
        if (SDK_INT > 8) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ImageButton b = buttonList.get(0);
            Machine machineToFind = new Machine(1); //create local machine w/ id 3
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().withHashKeyValues(machineToFind);
            PaginatedQueryList<Machine> result = mapper.query(Machine.class, queryExpression);

            if(result.get(0).isBusy()) {
                b.setImageResource(R.drawable.washer_red);
            }
            else {
                b.setImageResource(R.drawable.washer_white);
            }
        }
        //Wash2
        if (SDK_INT > 8) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ImageButton b = buttonList.get(1);
            Machine machineToFind = new Machine(2); //create local machine w/ id 3
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().withHashKeyValues(machineToFind);
            PaginatedQueryList<Machine> result = mapper.query(Machine.class, queryExpression);

            if(result.get(0).isBusy()) {
                b.setImageResource(R.drawable.washer_red);
            }
            else {
                b.setImageResource(R.drawable.washer_white);
            }
        }
        //Wash3
        if (SDK_INT > 8) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ImageButton b = buttonList.get(2);
            Machine machineToFind = new Machine(3); //create local machine w/ id 3
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().withHashKeyValues(machineToFind);
            PaginatedQueryList<Machine> result = mapper.query(Machine.class, queryExpression);

            if(result.get(0).isBusy()) {
                b.setImageResource(R.drawable.washer_red);
            }
            else {
                b.setImageResource(R.drawable.washer_white);
            }
        }
        //Dry1
        if (SDK_INT > 8) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ImageButton b = buttonList.get(3);
            Machine machineToFind = new Machine(7); //create local machine w/ id 3
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().withHashKeyValues(machineToFind);
            PaginatedQueryList<Machine> result = mapper.query(Machine.class, queryExpression);

            if(result.get(0).isBusy()) {
                b.setImageResource(R.drawable.dryer_red);
            }
            else {
                b.setImageResource(R.drawable.dryer_white);
            }
        }
        //Dry2
        if (SDK_INT > 8) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ImageButton b = buttonList.get(4);
            Machine machineToFind = new Machine(8); //create local machine w/ id 3
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().withHashKeyValues(machineToFind);
            PaginatedQueryList<Machine> result = mapper.query(Machine.class, queryExpression);

            if(result.get(0).isBusy()) {
                b.setImageResource(R.drawable.dryer_red);
            }
            else {
                b.setImageResource(R.drawable.dryer_white);
            }
        }
        //Dry3
        if (SDK_INT > 8) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ImageButton b = buttonList.get(5);
            Machine machineToFind = new Machine(8); //create local machine w/ id 3
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().withHashKeyValues(machineToFind);
            PaginatedQueryList<Machine> result = mapper.query(Machine.class, queryExpression);

            if(result.get(0).isBusy()) {
                b.setImageResource(R.drawable.dryer_red);
            }
            else {
                b.setImageResource(R.drawable.dryer_white);
            }
        }



/*
        for(int i=0;i<3;i++) {
            ImageButton b = buttonList.get(i);
            Machine m = machineList.get(i);

            if(m.isBusy()) {
                b.setImageResource(R.drawable.washer_red);
            }
            else {
                b.setImageResource(R.drawable.washer_white);
            }
        }

        machineList = getDryerFloorList(bldg);

        for(int i=3; i<6;i++) {
            ImageButton b = buttonList.get(i);
            Machine m = machineList.get(i-3);

            if(m.isBusy()) {
                b.setImageResource(R.drawable.dryer_red);
            }
            else {
                b.setImageResource(R.drawable.dryer_white);
            }
        }


        /*

        // A crushed dream...

        for(int i = 0; i < 3; i++){

            String tmpID = "wash_" + i;
            ImageButton theButton = (ImageButton) findViewById(R.id.wash_ + i);
            Machine theMachine = machineList.get(i);

            if(theMachine.isBusy){
                theButton.setImageResource(R.drawable.washer_red);
            }
            else {
                theButton.setImageResource(R.drawable.washer_white);
            }

        }

         for(int i = 0; i < 3; i++){

            ImageButton theButton = (ImageButton) findViewById(R.id.dryer_ + i);
            Machine theMachine = machineList.get(i);

            if(theMachine.isBusy){
                theButton.setImageResource(R.drawable.dryer_red);
            }
            else {
                theButton.setImageResource(R.drawable.dryer_white);
            }


        }
        */





    }

    private ArrayList<Machine> getWasherFloorList(String bldg) {
        ArrayList<Machine> returnThis = new ArrayList<>();

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //network code stuff goes here ahahaha IM SO TIRED
            CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                    getApplicationContext(),
                    "us-east-1:9ab3a587-a013-440b-b86d-7d50e8861f75", // Identity Pool ID
                    Regions.US_EAST_1 // Region
            );

            ddbClient = new AmazonDynamoDBClient(credentialsProvider);
            mapper = new DynamoDBMapper(ddbClient);

            String queryString = bldg;

            Condition rangeKeyCondition = new Condition().withComparisonOperator(ComparisonOperator.BEGINS_WITH.toString()).withAttributeValueList(new AttributeValue().withS(queryString.toString()));



            Machine m = new Machine(bldg);
            //DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().(m);
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().withHashKeyValues(m).withRangeKeyCondition("Building",rangeKeyCondition).withConsistentRead(false);
            PaginatedQueryList<Machine> result = mapper.query(Machine.class, queryExpression);
            for(int i=0;i<result.size();i++) {
                if(result.get(i).getLocalID().toLowerCase().contains("a")) {
                    System.err.println("\n\nHEY CHECK THIS OUT: " + result.get(i).getLocalID() + "\n\n");
                    returnThis.add(result.get(i));
                }
            }



        }


        return returnThis;
    }


    private ArrayList<Machine> getDryerFloorList(String bldg) {
        ArrayList<Machine> returnThis = new ArrayList<>();

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //network code stuff goes here ahahaha IM SO TIRED
            CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                    getApplicationContext(),
                    "us-east-1:9ab3a587-a013-440b-b86d-7d50e8861f75", // Identity Pool ID
                    Regions.US_EAST_1 // Region
            );

            ddbClient = new AmazonDynamoDBClient(credentialsProvider);
            mapper = new DynamoDBMapper(ddbClient);

            String queryString = bldg;

            Condition rangeKeyCondition = new Condition().withComparisonOperator(ComparisonOperator.BEGINS_WITH.toString()).withAttributeValueList(new AttributeValue().withS(queryString.toString()));



            Machine m = new Machine(bldg);
            //DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().(m);
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().withHashKeyValues(m).withRangeKeyCondition("Building",rangeKeyCondition).withConsistentRead(false);
            PaginatedQueryList<Machine> result = mapper.query(Machine.class, queryExpression);
            for(int i=0;i<result.size();i++) {
                if(result.get(i).getLocalID().toLowerCase().contains("b")) {
                    System.err.println("\n\nHEY CHECK THIS OUT: " + result.get(i).getLocalID() + "\n\n");
                    returnThis.add(result.get(i));
                }
            }



        }


        return returnThis;
    }

    private ArrayList<Machine> oldgetDryerFloorList(String bldg) {
        ArrayList<Machine> returnThis = new ArrayList<>();

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //network code stuff goes here ahahaha IM SO TIRED
            Machine m = new Machine(bldg);
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression().withHashKeyValues(m);
            PaginatedQueryList<Machine> result = mapper.query(Machine.class, queryExpression);
            for(int i=0;i<result.size();i++) {
                if(result.get(i).getLocalID().toLowerCase().contains("b")) {
                    System.err.println("\n\nHEY CHECK THIS OUT: " + result.get(i).getLocalID() + "\n\n");
                    returnThis.add(result.get(i));
                }
            }



        }


        return returnThis;
    }

}
