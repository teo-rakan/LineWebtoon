package mobile.test.automation.core;

import org.junit.After;

public class AppiumTest {

    @After
    public void tearDown() {
        DriverManager.getInstance().quit();
    }
}
