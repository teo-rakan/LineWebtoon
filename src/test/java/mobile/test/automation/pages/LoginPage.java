package mobile.test.automation.pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.naver.linewebtoon:id/input_id")
    private AndroidElement emailInput;

    @AndroidFindBy(id = "com.naver.linewebtoon:id/input_password")
    private AndroidElement passwordInput;

    @AndroidFindBy(id = "com.naver.linewebtoon:id/btn_log_in")
    private AndroidElement logInButton;

    @AndroidFindBy(id = "com.naver.linewebtoon:id/btn_login_facebook")
    private AndroidElement facebookButton;

    public HomePage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        logInButton.click();
        return new HomePage();
    }

    //todo Facebook WebView
    public HomePage facebook() {
        facebookButton.click();
        return new HomePage();
    }

    @Override
    public void waitUntilLoaded() {
        driverManager.wait(By.id("btn_login_facebook"));
    }
}
