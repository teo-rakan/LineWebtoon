package mobile.test.automation.core;


import org.testng.annotations.AfterMethod;

public class AppiumTest {

    @AfterMethod
    public void tearDown() {
        DriverManager.getInstance().quit();
    }
}
