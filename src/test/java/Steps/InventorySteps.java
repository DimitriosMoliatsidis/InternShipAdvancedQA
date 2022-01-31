package Steps;
import Pages.InventoryPage;
import Pages.LoginPage;
import Steps.LoginSteps;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import Steps.LoginSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class InventorySteps {
    InventoryPage inventoryPage;
    @Steps
    LoginSteps loginSteps;



    @Step
    public void isLoggedIntoInventory(){

        loginSteps.isOnLoginPage();
        loginSteps.loginWithCorrectCredentials();
        loginSteps.shouldBeLoggedin();

    }

    @Step
    public void userLogOutThroughMenu() {

        inventoryPage.openProfileMenu();
        inventoryPage.clickOnLogoutButton();
        inventoryPage.isOnLogoutPage();

    }
    @Step
    public void userGoesToJackets(String menuName)  {

        inventoryPage.hoverOnSpecificMenu(menuName);
        inventoryPage.hoverOnTopsMenu(menuName);
        inventoryPage.clickOnJackets(menuName);

    }

    @Step
    public void userGoesToTops(String menuName){

        inventoryPage.hoverOnSpecificMenu(menuName);
        inventoryPage.hoverOnTopsMenu(menuName);
        inventoryPage.clickOnTopsMenu(menuName);

    }

    @Step
    public void userAppliesPriceFilter(int lowPrice,String menuName) {

        inventoryPage.clickOnPriceFilter(lowPrice,menuName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Step
    public void userClicksOnJacket(){

        inventoryPage.clickOnProductJacket();
        inventoryPage.isOnProductDescription();
        inventoryPage.putProductInCart();
        inventoryPage.deleteProductFromCart();

    }

    @Step
    public void deleteProducts() {

        int size = inventoryPage.returnCart().size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(i+1);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inventoryPage.deleteProductFromCart();

        }
    }

    @Step
    public void checkAllPrices(int lowPrice) {

        String price;
        while(true) {

            List<WebElementFacade> elements = inventoryPage.getElementsFromPage();

            for (int i = 0; i < elements.size(); i++) {
                price = elements.get(i).findElement(By.cssSelector("[class='price']")).getText();
                assertThat(price).isBetween("€"+lowPrice, "€"+(lowPrice+10));
                System.out.println(i + 1 + " " + price);
            }
            if(inventoryPage.checkIfNextPageAvailable()){
                inventoryPage.clickNextPage();
            }
            else{
                break;
            }
        }
    }

    @Step
    public void userAppliesCategoryFilter(String category) {
    inventoryPage.clickOnCategoryFilter(category);

        while(true) {
            String temp;
            List<WebElementFacade> elements = inventoryPage.getElementsFromPage();

            for (int i = 0; i < elements.size(); i++) {
                temp = elements.get(i).findElement(By.cssSelector("[class='product name product-item-name']")).getText();
                assertThat(temp).contains(category);
                System.out.println(i + 1 + "ok");
            }
            if(inventoryPage.checkIfNextPageAvailable()){
                inventoryPage.clickNextPage();
            }
            else{
                break;
            }
        }
    }

    @Step
    public void userGoesToGear(String menuName) {
        inventoryPage.hoverOnSpecificMenu(menuName);
        inventoryPage.clickOnBagsMenu();
        inventoryPage.isOnBagPage();
    }

    @Step
    public void userRemovesFilterAndChecks() {
        inventoryPage.removePriceFilter();
        String price;
        boolean flag=false;
        while(true) {

            List<WebElementFacade> elements = inventoryPage.getElementsFromPage();
            System.out.println("Now Checking if the filter was removed");
            for (int i = 0; i < elements.size(); i++) {
                price = elements.get(i).findElement(By.cssSelector("[class='price']")).getText();
                if(price.equals("€45.00"))
                flag=true;

            }
            if(inventoryPage.checkIfNextPageAvailable()){
                inventoryPage.clickNextPage();
            }
            else{
                break;
            }
        }
        if (flag)
            System.out.println("Filter was successfully removed");
        assertThat(flag).isTrue();
    }

    @Step
    public void userAppliesGearPriceFilter(int lowPrice) {
            inventoryPage.clickOnGearPriceFilter(lowPrice);
    }
}
