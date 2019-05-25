import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class MyClass {


    public MyClass(String param) {

        System.out.println("Constructor with params" + param);
    }

    public MyClass() {
        // I can do some additional stuff here

        System.out.println("Constructor with no params");
    }






}
