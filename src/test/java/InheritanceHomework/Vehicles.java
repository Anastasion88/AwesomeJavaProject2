package InheritanceHomework;

public class Vehicles {

    String name;
    int wheels;

    public void info(){
        System.out.printf("Type: %s, " +
                "Wheels: %d; " , name, wheels );
    }

    public void vehiclesInfo (){
        System.out.println("Vehicles can be different!");
    }

    public void mainGoal (){
        System.out.println("People need them to get to their destination!");

    }
}
