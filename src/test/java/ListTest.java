import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    @Test
    public void test001(){
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(666);

        list.remove(3);

        boolean isEquals3 = list.size() == 3; //count from 1, not a zero

        Assert.assertTrue(isEquals3);


    }
}
