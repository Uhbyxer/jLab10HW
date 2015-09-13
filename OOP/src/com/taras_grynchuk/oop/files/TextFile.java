/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.taras_grynchuk.oop.files;

import com.taras_grynchuk.oop.Car;
import com.taras_grynchuk.oop.ListOfCars;
import java.io.*;
import java.util.*;
/**
 *
 * @author Taras
 */
public class TextFile {
    public static void exportToTextFile(ListOfCars list, String fileName) throws IOException {
        PrintWriter out = new PrintWriter(
            new File(fileName).getAbsoluteFile());
            
        for(Car car: list) {
            char tab = (char) 9;
            String s = "" + 
                   car.getModel() + tab +
                   car.getColor() + tab +
                   car.getPrice() + tab +
                   car.getPower();
            
            out.println(s);
        }    
        out.close();        
    }
    
    public static void importFromTextFile(ListOfCars list, String fileName) throws IOException, NumberFormatException, Exception {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
                    //new File(fileName).getAbsoluteFile()));
        String s;
        while((s = in.readLine()) != null) {
            String[] a = s.split("\t");
            Car car = new Car(a[0], a[1], Float.parseFloat(a[2]), Integer.parseInt(a[3]));
            list.add(car);
        }
        in.close();
    }    
}