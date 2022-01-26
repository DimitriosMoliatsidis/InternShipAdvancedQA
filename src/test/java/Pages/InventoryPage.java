package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.util.concurrent.Futures.withTimeout;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InventoryPage extends PageObject {

    public Actions action =new Actions(this.getDriver());




    @Step
    public void openProfileMenu() {
        WebElement dropDown=$(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button"));
        dropDown.click();
        assertThat(dropDown.isDisplayed()).isTrue();

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

    public void hoverOnMenMenu()  {
        WebElement element= $(By.xpath("//*[@id='ui-id-5']")).getElement();
        action.moveToElement(element);
        action.perform();

    }

    public void hoverOnTopsMenu() {
        WebElement element=$(By.cssSelector("[id='ui-id-17']")).getElement();
        action.moveToElement(element);
        action.perform();
    }

    public void clickOnJackets() {
        WebElement element=$(By.cssSelector("[id='ui-id-19']")).getElement();
        action.moveToElement(element);
        action.perform();
        element.click();
    }

    public void clickOnProductJacket() {
        WebElement element=$(By.cssSelector("[alt='Typhon Performance Fleece-lined Jacket']")).getElement();
        element.click();
    }

    public void isOnProductDescription() {
        WebElement price = $(By.cssSelector("[class='product-info-price']")).getElement();
        assertThat(price.isDisplayed()).isTrue();

        WebElement addToCartBtn = $(By.cssSelector("[id='product-addtocart-button']")).getElement();
        assertThat(addToCartBtn.isDisplayed()).isTrue();

    }

    public void putProductInCart() {
        WebElement size = $(By.cssSelector("[index='3']")).getElement();
        size.click();

        WebElement color = $(By.cssSelector("[id='option-label-color-93-item-5480']")).getElement();
        color.click();

        WebElement addToCartBtn = $(By.cssSelector("[id='product-addtocart-button']")).getElement();
        addToCartBtn.click();

        assertThat(addToCartBtn.isDisplayed()).isTrue();

        WebElement element =$(By.cssSelector("[class='counter-number']"));
       withTimeoutOf(Duration.ofSeconds(5)).waitForText(element,"1");

        assertThat(element.getText()).isEqualTo("1");

    }
    public List<WebElementFacade> returnCart(){
        WebElement cartBtn = $(By.cssSelector("[class='action showcart']")).getElement();
        cartBtn.click();

        return $$(By.cssSelector("[id='mini-cart'] [class='product-item-details']"));


    }
    public void deleteProductFromCart(){

       List<WebElementFacade> productsInCart=$$(By.cssSelector("[id='mini-cart'] [class='product-item-details']"));
           productsInCart.get(0).findBy(By.cssSelector("[class='action delete']")).click();
           $(By.cssSelector("[class='action-primary action-accept']")).click();
           withTimeoutOf(Duration.ofSeconds(4));

    }
}
