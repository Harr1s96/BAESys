package com.qa.garage;

public class Truck extends Vehicle {

    public Truck(String make, int numberOfWheels, String engineStroke) {

        this.setMake(make);
        this.setNumberOfWheels(numberOfWheels);
        this.setEngineStroke(engineStroke);

    }

    @Override
    public void accelerate() {

        System.out.println("BOOOM!");
    }

    @Override
    public int calcBill() {
        
        int z = 0;

        if (this.getNumberOfWheels() == 6 && this.getEngineStroke().equals("four")) {

            z += 1200;
        }
        
        return z;
    }

    

}
