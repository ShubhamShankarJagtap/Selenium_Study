package testNG;

import org.testng.annotations.Test;

public class Description {
    @Test(description = "This is test case for bike name.")
    public void bikeYamaha(){

        System.out.println("inside bike..");
    }
}
