/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author rohanarora
 */

public class beerExpert {
    public String getBrands(String color){
    if(color.equals("light")){
    return "kingfisher";
    }
    if(color.equals("amber")){
    return "vodka";
    }
    if(color.equals("brown")){
    return "scotch";
    }
    if(color.equals("dark")){
    return "wine";
    }
    return "";
    }
}
