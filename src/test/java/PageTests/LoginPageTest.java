package PageTests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.LoginSteps;

import java.time.Duration;

@RunWith(SerenityRunner.class)
public class LoginPageTest {

    @Steps
    LoginSteps loginSteps;

    @Managed(driver="chrome")
    WebDriver driver;


    @Test
    public void loginAttemptCorrectCredentials() {

        loginSteps.isOnLoginPage();
        loginSteps.loginWithCorrectCredentials();
        loginSteps.shouldBeLoggedin();
    }

    @Test
    public void loginAttemptInvalidCredentials(){

        loginSteps.isOnLoginPage();
        loginSteps.loginWithInvalidCredentials();
    }



}
