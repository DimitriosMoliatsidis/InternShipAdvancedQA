package Steps;
import Pages.InventoryPage;
import Pages.LoginPage;
import Steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import Steps.LoginSteps;
import org.openqa.selenium.By;

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
    public void userGoesToMenJackets() throws InterruptedException {

        inventoryPage.hoverOnMenMenu();

        inventoryPage.hoverOnTopsMenu();

        inventoryPage.clickOnJackets();
    }
    @Step
    public void userClicksOnJacket(){
        inventoryPage.clickOnProductJacket();
        inventoryPage.isOnProductDescription();

        inventoryPage.putProductInCart();

        inventoryPage.deleteProductFromCart();


    }
    @Step
    public void deleteprod() {
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

}
