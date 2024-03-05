package testNG;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority = 1)
    public void test1(){

        System.out.println("Inside 1");
    }

    @Test(priority = 0)
    public void test2(){

        System.out.println("inside 2.");
    }

}
