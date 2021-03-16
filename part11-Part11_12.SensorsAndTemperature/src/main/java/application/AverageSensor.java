/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel
 */
public class AverageSensor implements Sensor {
    
    private ArrayList<Sensor> listOfSensors;
    private ArrayList<Integer> listOfReadings;
    
    public AverageSensor() {
        this.listOfSensors = new ArrayList<>();
        this.listOfReadings = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
       boolean isWorking = true; 
       for (Sensor sensor : listOfSensors) {
            if (!sensor.isOn()) {
                isWorking = false;
            }
       }   
       return isWorking;
    }

    @Override
    public void setOn() {
         for (Sensor sensor : this.listOfSensors) {
            sensor.setOn();
        }    
    }

    @Override
    public void setOff() {
        for (Sensor sensor : this.listOfSensors) {
            sensor.setOff();
        }      
    }

    @Override
    public int read() {
        int sum = 0;
        if (this.isOn() || !this.listOfSensors.isEmpty()) {
            for (Sensor sensor : this.listOfSensors) {
                sum += sensor.read();
            }
            
            int average = sum / this.listOfSensors.size();
            this.listOfReadings.add(average);
            return average;
        } else {
            throw new IllegalStateException();
        }        
    }
    
    public void addSensor(Sensor toAdd) {
        this.listOfSensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        return this.listOfReadings;
    }   
}