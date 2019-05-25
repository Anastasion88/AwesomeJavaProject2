public class AutomationTesters extends Employee { //extends give all child classes to access
    // to the methods for this class
    String name = "Anastassiya Mayer";

    public void automating() {
        System.out.println("Automating");

    }

    public void work(){
        System.out.println("Automating and working and work");
    }

    public void work(String param){ //we showing overloading, this command will overload the upper command
        System.out.println("automation and working" + param);
    }
}
