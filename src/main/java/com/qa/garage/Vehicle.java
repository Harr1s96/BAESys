package com.qa.garage;

public abstract class Vehicle {

    private int numberOfWheels;
    private String engineStroke;
    private String make;

    public abstract void accelerate();

    public abstract int calcBill();
    
    /**
     * @param numberOfWheels the numberOfWheels to set
     */
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    /**
     * @param engineStroke the engineStroke to set
     */
    public void setEngineStroke(String engineStroke) {
        this.engineStroke = engineStroke;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }


    /**
     * @return the numberOfWheels
     */
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    /**
     * @return the engineStroke
     */
    public String getEngineStroke() {
        return engineStroke;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

}