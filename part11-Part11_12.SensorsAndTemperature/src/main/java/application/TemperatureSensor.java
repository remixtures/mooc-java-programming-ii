/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author miguel
 */
public class TemperatureSensor implements Sensor {
    
    private int temperature;
    private boolean isWorking;
    
    public TemperatureSensor() {
        isWorking = false;
    }

    @Override
    public boolean isOn() {
        return isWorking;
    }

    @Override
    public void setOn() {
        isWorking = true;
    }

    @Override
    public void setOff() {
        isWorking = false;
    }

    @Override
    public int read() {
        if (isWorking) {
            temperature = new Random().nextInt(61) - 30;
        } else {
            throw new IllegalStateException();
        }
        
        return temperature;
    }  
}
