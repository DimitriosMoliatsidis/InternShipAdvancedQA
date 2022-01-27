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
    public void userGoesToWomenTops(){

        inventoryPage.hoverOnSpecificMenu("Women");
        inventoryPage.hoverOnTopsMenu("Women");
        inventoryPage.clickOnTopsMenu("Women");

    }

    public void userAppliesPriceFilter() {

        inventoryPage.clickOnPriceFilter();
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


    public void checkAllPrices() {

        String price;
        while(true) {

            List<WebElementFacade> elements = inventoryPage.getElementsFromPage();

            for (int i = 0; i < elements.size(); i++) {
                price = elements.get(i).findElement(By.cssSelector("[class='price']")).getText();
                assertThat(price).isBetween("€30", "€40");
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

}
