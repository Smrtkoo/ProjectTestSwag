import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabTest extends BaseTest{
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckOutStepOnePage checkOutStepOnePage;

    @BeforeMethod
    public void SetUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkOutStepOnePage = new CheckOutStepOnePage(driver);

    }
    @Test
    public void login()
    {
        loginPage.LoginOnPage("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void buyProduct()
    {
        loginPage.LoginOnPage("standard_user", "secret_sauce");
        inventoryPage.addBackPack();
        inventoryPage.clickOnCart();
        Assert.assertEquals(cartPage.getInfoPrice(),"$29.99");
        Assert.assertEquals(cartPage.getProductName(),"Sauce Labs Backpack");

        cartPage.clickCheckOut();
        checkOutStepOnePage.inputPersonalInfo("Bojan","Lončarević","11000");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        checkOutStepOnePage.clickFinish();

        Assert.assertEquals(checkOutStepOnePage.infoMessage,"Thank you for your order!");

    }
    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
