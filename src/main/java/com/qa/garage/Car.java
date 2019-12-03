package com.qa.garage;

public class Car extends Vehicle {

    public Car(String make, int numberOfWheels, String engineStroke) {

        this.setMake(make);
        this.setNumberOfWheels(numberOfWheels);
        this.setEngineStroke(engineStroke);
    }

    @Override
    public void accelerate() {
        
        System.out.println("Vroom!");
    }

    @Override
    public int calcBill() {

        int z = 0;

        if (this.getNumberOfWheels() == 4 && this.getEngineStroke().equals("four")) {

            z += 800;
        }
        
        return z;
    }
    
}