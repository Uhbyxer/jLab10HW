/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.taras_grynchuk.oop;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Taras
 */
public class ListOfCars extends LinkedList<Car> implements Serializable {
    //сортування за потужністю "методом вибору"
    public void sort() {
        for(int i = 0; i < size(); i++) {
            // Знайдемо мінімальний елемент на
            // проміжку індексів [i; size);
            // спочатку його індекс рівний i
            int minValueIndex = i;
            
            // Перебираємо елементи, що залишилися на проміжку
            for(int j = i + 1; j < size(); j++) 
                // Якщо елемент в позиції j менший
                // елемента в позиції minValueIndex, то
                // необхідно обновити значення індекса
                if(get(j).getPower() < get(minValueIndex).getPower()) minValueIndex = j;
            
            // Міняємо поточний елемент з мінімальним
            Collections.swap(this, i, minValueIndex);
        }
    }
    
    //список моделей без повторень
    public String[] getArrayOfModels() {
        HashSet<String> models = new HashSet<>();
        for(Car c: this) models.add(c.getModel());
        String[] arr = new String[models.size()];
        models.toArray(arr);
        return arr;
    }
    
    //список колборів без повторень
    public String[] getArrayOfColors(String firstColor) {
        HashSet<String> colors = new HashSet<>();
        for(Car c: this) colors.add(c.getColor());
        
        ArrayList<String> list = new ArrayList<>(colors);
        if(firstColor.length() > 0) {
            //ставимо вказаний колір на перше місце
            int index = list.indexOf(firstColor);
            if(index != -1) Collections.swap(list, index, 0);
        }
        String[] arr = new String[list.size()];
        list.toArray(arr);
        return arr;
    } 
    
    public String[] getArrayOfColors() {
        return this.getArrayOfColors("");
    }
    
    //найдешевша за вказаною моделлю
    public int getMinPriceIndex(String model) {
        return getMinPriceIndex(model, "");
    }
    
    //найдешевша за вказаною моделлю та кольором
    public int getMinPriceIndex(String model, String color) {
        float min = Float.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < size(); i++) {
            Car c = get(i);
            if(!model.toLowerCase().equals(c.getModel().toLowerCase())) continue;
            if(color.length() > 0)
                if(!color.toLowerCase().equals(c.getColor().toLowerCase())) continue;
            float x = c.getPrice();
            if(x < min) { 
                min = x;
                index = i;
            }    
        }        
        return index;
    }    
    
    //найменш потужна
    public int getMinPowerIndex(String model) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < size(); i++) {
            Car c = get(i);
            if(!model.toLowerCase().equals(c.getModel().toLowerCase())) continue;
            int x = c.getPower();
            if(x < min) { 
                min = x;
                index = i;
            }    
        }        
        return index;
    }
    
    //марки з одинаковою ціною та різними кольорами
   public String getSamePrice() {
       StringBuilder s = new StringBuilder();
       
       String[] models = getArrayOfModels();
       
       //йдемо по моделях
       for(String model: models) {
           //створимо множину цін даної марки
           HashSet<Float> prices = new HashSet<>();
           for(Car car: this) 
               if(car.getModel().equals(model)) prices.add(car.getPrice());
           
           String strPrices = "";
           //йдемо по цінах
           for(float price: prices) {
               
               //створимо множину кольорів даної марки та даної ціни
               HashSet<String> colors = new HashSet<>();
               for(Car car: this)
                   if(car.getModel().equals(model)) //перевірка на модель
                       if(car.getPrice() == price) //перевірка на ціну
                           colors.add(car.getColor());
               
               String strColors = "";
               //якщо кольори різні (тобто їх к-сть в множині > 1)
               if(colors.size() > 1) {
                   for(String color: colors) {
                       if(!strColors.equals("")) strColors += ", ";
                       strColors += color;
                   } 
                   if(strPrices.length() > 0) strPrices += "\n";
                   strPrices += "\tЦіна: " + price + " - ( " + strColors + " )";
               }    
           }
           if(strPrices.length() > 0) {
               if(s.length() != 0) s.append("\n");
               s.append("=================================================================");
               s.append("\nМарка: " + model);
               s.append("\n" + strPrices);
           }            

       }
       
       return s.toString();
   }
   
   //Марки, ціна яких не входить в задані межі
   public String getOutOfBoundsPrices(float priceFrom, float priceTo) {
       StringBuilder s = new StringBuilder();
       String[] models = getArrayOfModels();

       //йдемо по моделях
       for(String model: models) {
           //створимо множину цін даної марки
           HashSet<Float> prices = new HashSet<>();
           for(Car car: this) 
               if(car.getModel().equals(model)) 
                   if(car.getPrice() > priceTo || car.getPrice() < priceFrom)
                        prices.add(car.getPrice());
           
           String strPrices = "";
           for(float price: prices) {
                if(strPrices.length() > 0) strPrices += ", ";
                strPrices += price;
           }
           if(strPrices.length() > 0) {
               if(s.length() != 0) s.append("\n");
               s.append(model + " (Ціни: " + strPrices + ")");
           }
       }
       
       return s.toString();
   }
   
   //найпотужніша за вказаним кольором та моделлю
    public int getMaxPowerIndex(String model, String color) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < size(); i++) {
            Car c = get(i);
            if(!model.toLowerCase().equals(c.getModel().toLowerCase())) continue;
            if(!color.toLowerCase().equals(c.getColor().toLowerCase())) continue;
            int x = c.getPower();
            if(x > max) { 
                max = x;
                index = i;
            }    
        }        
        return index;
    }
    
    //найпотужніша та найдешевша за вказаними кольорами у кожній марці
    public String getMaxPowerAndMinPrice(String maxPowerColor, String minPriceColor) {
       StringBuilder s = new StringBuilder();
       String[] models = getArrayOfModels();

       //йдемо по моделях
       for(String model: models) {
           if(s.length() != 0) s.append("\n");
           s.append("=================================================================");
           s.append("\nМарка: " + model);
           
           s.append("\nНайпотужніша: ");
           int index = getMaxPowerIndex(model, maxPowerColor);
           if(index == -1) s.append("< не знайдено >"); 
           else s.append("№ " + index + ". " + get(index));

           s.append("\nНайдешевша: ");
           index = getMinPriceIndex(model, minPriceColor);
           if(index == -1) s.append("< не знайдено >"); 
           else s.append("№ " + index + ". " + get(index));
       }
       return s.toString();
    }
}
