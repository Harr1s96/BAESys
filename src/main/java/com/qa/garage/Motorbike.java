package com.qa.garage;

public class Motorbike extends Vehicle {

    public Motorbike(String make, int numberOfWheels, String engineStroke) {

        this.setMake(make);
        this.setNumberOfWheels(numberOfWheels);
        this.setEngineStroke(engineStroke);
    }

    @Override
    public void accelerate() {

        System.out.println("G-O");
    }

    @Override
    public int calcBill() {
        
        int z = 0;

        if (this.getNumberOfWheels() == 2 && this.getEngineStroke().equals("two")) {

            z += 600;
        }
        
        return z;
    }

    
}