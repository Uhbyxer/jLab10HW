/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.taras_grynchuk.oop.files;

import com.taras_grynchuk.oop.Car;
import com.taras_grynchuk.oop.ListOfCars;
import java.io.*;

/**
 *
 * @author Taras
 */
public class SerializableFiles {
    //відкрити файл з списком машин
    public static ListOfCars openFromSerFile() throws IOException, ClassNotFoundException {
        FileInputStream fIn = null; 
        ObjectInputStream oIn = null;
        fIn = new FileInputStream("ListOfCars.ser");
        oIn = new ObjectInputStream(fIn);
        ListOfCars list = new ListOfCars();
        list = (ListOfCars) oIn.readObject();
        if(oIn != null) {
              oIn.close();
              fIn.close();
        }     
        
        Car.setCount(list.size());
        return list;
    }
    
    //зберегти список машин у файл
    public static void saveToSerFile(ListOfCars list) throws IOException, ClassNotFoundException {
        FileOutputStream fOut = new FileOutputStream("ListOfCars.ser");
        ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        oOut.writeObject(list);
        oOut.flush();
        oOut.close();
        fOut.close();
    }
}
