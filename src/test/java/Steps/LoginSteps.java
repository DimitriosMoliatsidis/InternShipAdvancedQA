package Steps;

import Pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private LoginPage loginPage;


    @Step
    public void isOnLoginPage() {
        loginPage.open();
        loginPage.goToLogin();
    }

    @Step
    public void loginWithCorrectCredentials() {
        loginPage.doLoginCorrectCredentials();
    }
    @Step
    public void loginWithInvalidCredentials() {

        loginPage.doLoginInvalidCredentials();
    }

    @Step
    public void shouldBeLoggedin()  {
        try {
            Thread.sleep(1000);
            loginPage.userGreetingShouldBeVisible();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
