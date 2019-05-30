import org.testng.annotations.*; // * - all packages will be import from annotations methods folder

public class Annotations { //test class

    // test case 1
    @Test
    public void testCase1() { //test method, code might be readble,
        System.out.println("in test case 1");
    }

    // test case 2
    @Test
    public void testCase2() { //test method 2
        System.out.println("in test case 2");
    }

    @BeforeMethod //can help to prepare the environment for test run
    public void beforeMethod() { //we can open the browser or clean the cache
        System.out.println("in beforeMethod");
    }

    @AfterMethod  //can clean up the environment for the next test run
    public void afterMethod() {  //we can close the browser or clean the cache, or clean up some data base
        System.out.println("in afterMethod");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("in beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("in afterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("in beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("in afterTest");
    }

    @BeforeSuite
    public void beforeSuite() { //highest level of test grouping, he going first!!!
        System.out.println("in beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("in afterSuite");
    }





}
