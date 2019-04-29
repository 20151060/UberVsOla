/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rohanarora
 */
public class rideInfo {
    private String rideType;
    private String price;
    private long priceMin;
    private long priceMax;
    public rideInfo(String rideType, long priceMin, long priceMax){
    this.rideType = rideType;
    this.priceMin = priceMin/100;
    this.priceMax = priceMax/100;
    }
    
    public rideInfo(String rideType, String price){
    this.rideType = rideType;
    this.price = price;
    }
    
    public void setrideType(String rideType){
    this.rideType = rideType;
    }
    public String getrideType(){
    return this.rideType;
    }
    public void setprice(String price){
    this.price = price;
    }
    public String getprice(){
    return this.price;
    }
    
    public void setpriceMin(long priceMin){
    this.priceMin = priceMin;
    }
    public long getpriceMin(){
    return this.priceMin;
    }
    
    public void setpriceMax(long priceMax){
    this.priceMax = priceMax;
    }
    public long getpriceMax(){
    return this.priceMax;
    }
}

