package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DefaultUrl("http://168.119.186.3")
public class LoginPage extends PageObject {
    @Step
    public void goToLogin() {
        $(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]")).click();
    }

    @Step
    public void doLoginCorrectCredentials(){
        $(By.cssSelector("[id='email']")).sendKeys("roni_cost@example.com");
        $(By.cssSelector("[id='pass']")).sendKeys("roni_cost3@example.com");
        $(By.cssSelector("[class='action login primary']")).click();
    }
    @Step
    public void doLoginInvalidCredentials(){
        $(By.cssSelector("[id='email']")).sendKeys("wrongmail@example.com");
        $(By.cssSelector("[id='pass']")).sendKeys("roni_cost3@example.com");
        $(By.cssSelector("[class='action login primary']")).click();
    }

    @Step
    public void userGreetingShouldBeVisible() {
       WebElement userGreeting=$(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span"));
       assertThat(userGreeting.getText()).contains("Veronica Costello");
    }
}
