package testNG;

import org.testng.annotations.*;

public class Demo {

//    @BeforeSuite
//    public void beforeSuite(){
//
//        System.out.println("inside beforeSuite");
//    }
//
//    @BeforeTest
//    public void beforeTest(){
//
//        System.out.println("inside beforeTest");
//    }
//
//    @BeforeClass
//    public void beforeClass(){
//
//        System.out.println("inside beforeClass");
//    }
//
//    @BeforeMethod
//    public void beforeMethod(){
//
//        System.out.println("inside beforeMethod");
//    }
//
//    @Test
//    public void test(){
//
//        System.out.println("inside test");
//    }
//
//    @AfterSuite()
//    public void afterSuite(){
//
//        System.out.println("inside afterSuite");
//    }
//
//    @AfterTest
//    public void afterTest(){
//
//        System.out.println("inside afterTest");
//    }
//
//    @AfterClass
//    public void afterClass(){
//
//        System.out.println("inside afterClass");
//    }
//
//    @AfterMethod
//    public void AfterMethod(){
//
//        System.out.println("inside AfterMethod");
//    }

    @Test
    @Parameters({"browser"})
    public void bike(String browser){

        System.out.println("inside bike..");
        System.out.println(browser);
    }

    @Test
    public void animal(){

        System.out.println("inside animal....");
    }
}
