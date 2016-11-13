package com.example.wendy.lion_dry;

/**
 * Created by pathe on 11/12/2016.
 */

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;


@DynamoDBTable(tableName = "liondry_machine")
public class Machine {
    private int _id;
    private String building;
    private String floor;
    private String localID;
    private String status;
    private String user;

    public Machine(){

    }

    public Machine(int _id){
        setID(_id);
    }

    //constructor to create machine in building 'str'
    public Machine(String str){
        /*
        String b ="";
        if(str.toLowerCase().contains("building")) {
            b = str.substring(str.indexOf("=") +1);
        }
        this.setBuilding(b);
        */
        this.setBuilding(str);;

    }


    @DynamoDBHashKey (attributeName = "_id")
    public int getID() {
        return _id;
    }

    public void setID(int _id) {
        this._id = _id;
    }

    @DynamoDBAttribute(attributeName = "Building")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @DynamoDBAttribute(attributeName = "Floor")
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @DynamoDBAttribute(attributeName = "local_ID")
    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    @DynamoDBAttribute(attributeName = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @DynamoDBAttribute(attributeName = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isBusy() {
        if(getStatus().equalsIgnoreCase("busy")) return true;
        else return false;

    }

}