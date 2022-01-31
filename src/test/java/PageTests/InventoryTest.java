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
    private String menuName;


    @Test
    public void userlogOut(){
        inventorySteps.isLoggedIntoInventory();
        inventorySteps.userLogOutThroughMenu();

    }

    @Test
    public void userGoesToMenJacketsAndPutsInCart(){
        menuName="Men";
        inventorySteps.isLoggedIntoInventory();
        inventorySteps.userGoesToJackets(menuName);
        inventorySteps.userClicksOnJacket();
    }
    @Test
    public void userGoesToWomenTopsChecksPriceLimits(){
        menuName="Women";
        inventorySteps.isLoggedIntoInventory();
        inventorySteps.userGoesToTops(menuName);
        inventorySteps.userAppliesPriceFilter(30,menuName);
        inventorySteps.checkAllPrices(30);
    }
    @Test
    public void userGoesToMenTopAndUsesFilters(){
        menuName="Men";
        inventorySteps.isLoggedIntoInventory();
        inventorySteps.userGoesToTops(menuName);
        inventorySteps.userAppliesPriceFilter(20,menuName);
        inventorySteps.userAppliesCategoryFilter("Tank");


    }
    @Test
    public void userGoesToGearAndChecksFilterOptions(){
        inventorySteps.isLoggedIntoInventory();
        inventorySteps.userGoesToGear("Gear");
        inventorySteps.userAppliesGearPriceFilter(30);
        inventorySteps.checkAllPrices(30);

        inventorySteps.userRemovesFilterAndChecks();
    }

    @Test
    public void delete(){
        inventorySteps.isLoggedIntoInventory();
        inventorySteps.deleteProducts();
    }

}
