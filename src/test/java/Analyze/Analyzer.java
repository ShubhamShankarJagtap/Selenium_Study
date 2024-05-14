package Analyze;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
     There are multiple reasons why the test fails.

     1] Due to the network issue.
     2] Due to application downtime.
     3] Due to loading issue & etc.

     But if script is failing due to Xpath or some valid reason then you have to perform rework in scripts

     We can rerun the failed test case using

     1]testNg-failed.xml

     2] Using IRetryAnalyzer interface

     IRetryAnalyzer is an interface which have only one method retry

 */
public class Analyzer implements IRetryAnalyzer {

    final int attempts = 3;
    int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()){
            if (count <= attempts){
                count++;
                return true;
            }
        }
        return false;
    }
}
