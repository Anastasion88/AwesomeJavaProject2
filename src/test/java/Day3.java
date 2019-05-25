import org.testng.annotations.Test;

import java.util.Arrays;

public class Day3 {

    @Test
    public void test001() {

        for (int i = 1; i <= 40; i++) { //loop that will return even numbers from 1-10
            if (i % 3 == 0) printValue(i);
        }
    }

    public void printValue(int valueToPrint) {
        System.out.println(valueToPrint);


    }

    @Test
    public void test002() { //homework 1 - loop with even hello world

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) System.out.println(" Simple for loop: i = " + i);
        }
    }

    @Test
    public void test003() { //swapTwoNumbersInArray
        int[] array = {10, 20, 30, 40}; //array starting from 0,1,2,3
        swap(array, 0, 3); //swap left and right array 0-first number
        swap(array, 1, 2); //just added extra line for experiments

        System.out.println(Arrays.toString(array));
    }

    private void swap(int[] array, int indexL, int indexR) {   //modifier private; void - returning nothing;
        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR] = temp;         //process of swap
    }

    @Test
    public void testCountLetters() {
        String input = "hello worldooOO";
        int result = 0;
        for (char eachChar : input.toCharArray()) {
            if (eachChar == 'l') result++;
        }
        System.out.println(result);
    }


    @Test
    public static void main(String[] args) { //didn't understand it
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        // put original string in an
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] =
                    palindrome.charAt(i);
        }

        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] =
                    tempCharArray[len - 1 - j];
        }

        String reversePalindrome =
                new String(charArray);
        System.out.println(reversePalindrome);
    }


    @Test
    public void testClasses() {
        MyClass myClassObject = new MyClass();



    }

    @Test
    public void testInterfaceCat() {
        Cat myCat = new Cat(); //we have default constructor

        myCat.eat(); //I call the abstract method from interface
        myCat.jump();
    }

    @Test
    public void testInherClass() {
        AutomationTesters automationTesters = new AutomationTesters(); //method calling the constructor for Autom Testers

        Employee employee = new Employee(); //method calling the constructor for Employee


        System.out.println(automationTesters.name); //name was inherited from Automation testers class
        System.out.println(employee.name);  //name was inherited from Employee class

        employee.work();


        automationTesters.work();

        automationTesters.work( " + param" ); //do not type the word: param


    }


}
