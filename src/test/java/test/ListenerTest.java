package test;

import base.Base;
import org.testng.*;

public class ListenerTest extends Base implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test fail");
        testFail();
    }
}
