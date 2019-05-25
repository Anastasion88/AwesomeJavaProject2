package InheritanceHomework;

import org.testng.annotations.Test;

public class TestInheritanceVehicles {


    @Test
    public void TestIheritanceVehicles (){


        Bicycle bicycle = new Bicycle();
        bicycle.name = "Bicycle";
        bicycle.wheels = 2;

        Car car = new Car();
        car.name = "Car";
        car.wheels = 4;

        Motocycle motocycle = new Motocycle();
        motocycle.name = "Motorcycle";
        motocycle.wheels = 2;

        Bus bus = new Bus();
        bus.name = "Bus";
        bus.wheels = 6;

        System.out.println("Vehicles type: ");

        Vehicles [] members = new Vehicles[4];
        members [0] = bicycle;
        members [1] = car;
        members [2] = motocycle;
        members [3] = bus;

        for (Vehicles f : members){
            f.info();
        }

        bicycle.ride();
        bicycle.workout();
        car.drive();
        car.drive2();
        motocycle.motorace();
        motocycle.rideOcean();
        bus.schoolride();
        bus.busTour();
        car.vehiclesInfo();
        bus.mainGoal();

















    }

}
