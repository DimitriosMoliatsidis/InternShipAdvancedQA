package Steps;
import Pages.InventoryPage;
import Pages.LoginPage;
import Steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import Steps.LoginSteps;

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
}
