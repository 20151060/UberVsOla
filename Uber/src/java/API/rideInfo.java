/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author rohanarora
 */
public class rideInfo {
    private String rideType;
    private String price;
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
    
}
