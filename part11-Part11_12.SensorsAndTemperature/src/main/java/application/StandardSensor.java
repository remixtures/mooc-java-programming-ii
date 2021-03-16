package application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
public class StandardSensor implements Sensor {
    
    private int temperature;
    
    public StandardSensor(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
        
    }

    @Override
    public void setOff() {
    }

    @Override
    public int read() {
        return this.temperature;
    }
}
