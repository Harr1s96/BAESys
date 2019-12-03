package com.qa.garage;


public class App 
{
    public static void main( String[] args )
    {
        Garage myGarage = new Garage();
        Car hyundai = new Car("Hyundai", 4, "four");

        myGarage.addVehicle(new Car("Honda", 4, "four"));
        myGarage.addVehicle(new Car("Toyota", 4, "four"));
        myGarage.addVehicle(new Motorbike("Ducati", 2, "two"));
        myGarage.addVehicle(new Truck("Scania", 6, "four"));
        myGarage.addVehicle(hyundai);

        System.out.println("This is a " + myGarage.getVehicle(0).getMake());
        System.out.println("The bill for this car is: " + myGarage.getVehicle(0).calcBill() + "\n");
        System.out.println("The total bill for the garage is: " + myGarage.totalBill() + "\n");
        
        myGarage.removeByType(Car.class);
        System.out.println("my garage size: " + myGarage.getSize());
        System.out.println("This is a " + myGarage.getVehicle(0).getMake());
    }
}
