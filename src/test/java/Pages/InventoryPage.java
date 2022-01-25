package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InventoryPage extends PageObject {



    @Step
    public void openProfileMenu() {
        WebElement dropDown=$(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button"));
        dropDown.click();

    }
    @Step
    public void clickOnLogoutButton() {
        $(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
    }

    @Step
    public void isOnLogoutPage(){
        try {
            Thread.sleep(500);
            assertThat(this.getDriver().getCurrentUrl()).contains("logoutSuccess");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Something Happened And Couldnt Sleep");
        }

    }
}
