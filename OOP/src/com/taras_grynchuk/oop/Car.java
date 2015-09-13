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

public class Car extends Goods implements Const, Serializable {
    private static int count = 0; //загальна к-сть автомобілів
    
    //атрибути автомобіля
    private String color; //колір
    private int power; //потужність
         
    //------------------------------------------------
    //методи встановлення/читання атрибутів
    //загальна к-сть автомобілів
    public static int getCount() {
        return count;
    }
    public static void setCount(int newCount) {
        count = newCount;
    }
    
    //артикул (не можна змінювати)
    @Override
    public int getArticle() {
        return FIRST_CAR_ARTICLE + uid;
    }
    
    //марка
    public String getModel() {
        return getName();
    }
    public void setModel(String model) {
        setName(model);
    }
    
    //колір
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    //потужність
    public int getPower() { 
        return power; 
    }
    public void setPower(int power) {
        this.power = power;
    }
    
    
    //конструктори
    public Car(String model, String color, float price, int power) {
        this.uid = count++;
        super.name = model;
        this.color = color;
        this.price = price;
        this.power = power;
    }
    
    //пуста позицiя
    public Car() {
        this(EMPTY_MODEL, EMPTY_COLOR, 0f, 0);
    }
    
    //представлення об'єкта строкою
    @Override
    public String toString() {
        return "Арт: " + getArticle() + " " + name + "/ " + color + "/ " + power + " к.с./ " + price + " грн.";
    }

}
