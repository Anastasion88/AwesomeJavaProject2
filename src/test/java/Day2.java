import org.testng.annotations.Test;

public class Day2{

    @Test
    public void testMethod1(){
        System.out.print("I wanna be superstar!");
        System.out.println(" And I wanna be a superhero!");
        System.out.println("But now I'm only a women!");
    }

    @Test
    public void testMethod2() {
        String s1 = new String("Who let the dogs out?");
// Just using "" creates a string, so no need to write it the previous way.
        String s2 = " Who who who who!";
// Java defined the operator + on strings to concatenate:

        System.out.println(s2 + s1);
    }

    @Test
    public void testMethod3() {
        char c = 'f';
        System.out.println(c);
    }

    @Test
    public void test004() {
        int num = 505;
        String s = "I have " + num + " cookies"; //Be sure not to use "" with primitives.

        System.out.println(s);
    }

    @Test
    public void test005() {
        boolean b = 5 > 7;
        if (b) {
            System.out.println("b is true!");
        }
        else  {
            System.out.println("B is false!");
        }
    }


    @Test
    public void test006() {
        int a = 4;
        int b = 5;
        boolean result;
        result = a < b; // true
        result = a > b; // false
        result = a <= 4; // a smaller or equal to 4 - true
        result = b >= 6; // b bigger or equal to 6 - false
        result = a == b; // a equal to b - false
        result = a != b; // a is not equal to b - true
        result = a > b || a < b; // Logical or - true
        result = 3 < a && a > 6; // Logical and - true
        result = !result; // Logical not - false

        System.out.println(result);
    }


    @Test
    public void test007() {
      boolean a = true;
      boolean b = false;
        if (a != b) {
            // a and b are equal, let's do something cool
         System.out.println(a); }
        else {
            System.out.println("It will be false");
        }

    }

    @Test
    public void test008() {
        int [] arrayOfIntegers = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            int arrayMember = arrayOfIntegers [i];
            System.out.println(arrayMember);

        }

    }

    @Test
    public void test009() {
        boolean b = 1 > 2;
        b = true;

        boolean toBe = false;
        b = toBe || !toBe;

        System.out.println(b);
    }

    @Test
    public void test010() throws Exception {
        int[] array;

        array = new int[10];

        array[0] = 4;
        array[1] = 3;
        array[2] = 6;

        String messageStart = "a[i]-";
        String messageEND = " i-";

        int i = 1;
        System.out.println(messageStart + array[i] + messageEND + i);

        int[] arr = {1, 2, 3, 4, 5};

        i = 3;

        if (i == 3) {

            System.out.println(messageStart + array[i] + messageEND + i);
        }





    }

    @Test
    public void test011() throws Exception {
            int [] array;

        array = new int [10];

        array [0] = 4;
        array [1] = 3;
        array [2] = 6;

        String messageStart = "a[i]-";
        String messageEND = " i-";

        int i = 1;
        System.out.println(messageStart + array [i] + messageEND + i);

        int [] arr = {1, 2, 3, 4, 5};

        i = 3;

        if (i == 3) {

            System.out.println(messageStart + array [i] + messageEND + i);
        }




    }
    }