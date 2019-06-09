import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {  // [][] - array of array
                {"Anastassiya", new Integer(31)},
                {"Vadim", new Integer(7)},
                {"Rodion", new Integer(2)},
                {"Igor", new Integer(35)},
        };
    }

    //This test method declares that its data should be supplied by the Data Provider
//named "test1"
    @Test(dataProvider = "test1")
    public void verifyData1(String n1, Integer n2) { //for Igor we need create String n1,for 35- Int n2 (it's Objects)
        System.out.println(n1 + " " + n2); //" " - just a space
    }


}
