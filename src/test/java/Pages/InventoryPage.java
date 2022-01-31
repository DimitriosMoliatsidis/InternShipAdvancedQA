package Pages;

import lombok.SneakyThrows;
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

    public void hoverOnSpecificMenu(String menuName)  {
        WebElement element=null;
        switch (menuName) {
            case "Women":{
                element= $(By.cssSelector("[id='ui-id-4']")).getElement();
                break;
            }
            case "Men":{
                element= $(By.cssSelector("[id='ui-id-5']")).getElement();
                break;
            }
            case "Gear":{
                element= $(By.cssSelector("[id='ui-id-6']")).getElement();
                break;
            }
        }
        action.moveToElement(element);
        action.perform();

    }

    public void hoverOnTopsMenu(String menuName) {
        WebElement element=null;
        switch (menuName) {
            case "Women":{
                element=$(By.cssSelector("[id='ui-id-9']")).getElement();
                break;
            }
            case "Men":{
                element=$(By.cssSelector("[id='ui-id-17']")).getElement();
                break;
            }
        }
        action.moveToElement(element);
        action.perform();
    }

    public void clickOnTopsMenu(String menuName) {
        WebElement element=null;
        switch (menuName) {
            case "Women":{
                element=$(By.cssSelector("[id='ui-id-9']")).getElement();
                break;
            }
            case "Men":{
                element=$(By.cssSelector("[id='ui-id-17']")).getElement();
                break;
            }
        }
        element.click();
    }

    public void clickOnBagsMenu() {
        $(By.cssSelector("[id='ui-id-25']")).click();
    }

    public void clickOnPriceFilter(int lowPrice,String menuName) {

        WebElement element =$(By.xpath("//*[@id='narrow-by-list']/div[4]/div[1]")).getElement();
        element.click();
        if (menuName=="Men") {
            switch (lowPrice) {
                case (10):
                    element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[1]/a")).getElement();
                    break;
                case 20:
                    element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[2]/a")).getElement();
                    break;
                case 30:
                    element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[3]/a")).getElement();
                    break;
                case 40:
                    element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[4]/a")).getElement();
                    break;
                case 50:
                    element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[5]/a")).getElement();
                    break;
                case 60:
                    element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[6]/a")).getElement();
                    break;
                case 70:
                    element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[7]/a")).getElement();
                    break;
                case 90:
                    element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[8]/a")).getElement();
                    break;
            }
        }
        else if(menuName=="Women" ){
            switch(lowPrice){
            case 20:
                element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[1]/a")).getElement();
                break;
            case 30:
                element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[2]/a")).getElement();
                break;
            case 40:
                element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[3]/a")).getElement();
                break;
            case 50:
                element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[4]/a")).getElement();
                break;
            case 60:
                element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[5]/a")).getElement();
                break;
            case 70:
                element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[6]/a")).getElement();
                break;
            case 90:
                element = $(By.xpath("//*[@id='narrow-by-list']/div[4]/div[2]/ol/li[7]/a")).getElement();
                break;
        }

        }
        element.click();
    }


    public void clickOnGearPriceFilter(int lowPrice) {

        WebElement element=null;

        $(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div/div[2]/div[1]")).click();
        switch(lowPrice){
            case 20:
                element = $(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/ol/li[1]/a")).getElement();
                break;
            case 30:
                element = $(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/ol/li[2]/a")).getElement();
                break;
            case 40:
                element = $(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/ol/li[3]/a")).getElement();
                break;
            case 50:
                element = $(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/ol/li[4]/a")).getElement();
                break;
            case 70:
                element = $(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/ol/li[5]/a")).getElement();
                break;
        }
        element.click();

    }

    public void clickOnCategoryFilter(String category) {
        WebElement element =$(By.xpath("//*[@id='narrow-by-list']/div[1]/div[1]")).getElement();
        element.click();
        switch(category) {
            case "Jacket":
                element= $(By.xpath("//*[@id='narrow-by-list']/div[1]/div[2]/ol/li[1]/a")).getElement();
                break;
            case "Hoodie":
            case "Sweatshirt":
                element= $(By.xpath("//*[@id='narrow-by-list']/div[1]/div[2]/ol/li[2]/a")).getElement();
                break;
            case "Tee":
                element= $(By.xpath("//*[@id='narrow-by-list']/div[1]/div[2]/ol/li[3]/a")).getElement();
                break;
            case "Tank":
                element= $(By.xpath("//*[@id='narrow-by-list']/div[1]/div[2]/ol/li[4]/a")).getElement();
                break;
        }
        element.click();
    }

    public void clickOnJackets(String menuName) {
        WebElement element=null;
        switch (menuName) {
            case "Women":{
                element=$(By.cssSelector("[id='ui-id-11']")).getElement();
                break;
            }
            case "Men":{
                element=$(By.cssSelector("[id='ui-id-19']")).getElement();
                break;
            }
        }
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

    public List<WebElementFacade> getElementsFromPage() {
        return $$(By.cssSelector("[class='item product product-item']"));
    }

    public boolean checkIfNextPageAvailable(){

        return !$$(By.cssSelector("[class='action  next']")).isEmpty();
    }

    public void clickNextPage(){
        $$(By.cssSelector("[class='action  next']")).get(1).click();
    }


    public void isOnBagPage() {
        assertThat(this.getDriver().getCurrentUrl()).contains("bags");
    }


    public void removePriceFilter() {
        $(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div[2]/div[1]/ol/li/a")).click();
    }
}
