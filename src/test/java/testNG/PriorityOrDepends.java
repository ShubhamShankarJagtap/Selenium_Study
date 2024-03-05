package testNG;

import org.testng.annotations.Test;

public class PriorityOrDepends {

    @Test(priority = 0,dependsOnMethods = "test2")
    public void test1(){

        System.out.println("Inside 1");
    }

    @Test()
    public void test2(){

        System.out.println("inside 2.");
    }

}
