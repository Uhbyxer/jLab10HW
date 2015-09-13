/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.taras_grynchuk.oop;

import java.io.Serializable;

/**
 *
 * @author Taras
 */
public abstract class Goods implements Serializable {
    //атрибути товару
    protected int uid; //унікальний ідентифікатор
    protected String name; //Назва товару
    protected float price; //ціна
    
    //методи встановлення/читання атрибутів
    public String getName() { 
        return name; 
    }
    public void setName(String name) {
        this.name = name;
    } 
    
    //ціна
    public float getPrice() { 
        return price; 
    }
    public void setPrice(float price) {
        this.price = price;
    }  
    
    //отримання артмкулу
    abstract int getArticle();
}
