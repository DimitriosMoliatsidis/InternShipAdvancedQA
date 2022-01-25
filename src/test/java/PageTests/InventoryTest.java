package PageTests;

import Steps.InventorySteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class InventoryTest {

    @Steps
    InventorySteps inventorySteps;


    @Managed(driver="chrome")
    WebDriver driver;

    @Test
    public void userlogOut(){
        inventorySteps.isLoggedIntoInventory();
        inventorySteps.userLogOutThroughMenu();

    }

    @Test
    public void hello(){
        inventorySteps.isLoggedIntoInventory();


    }

}
