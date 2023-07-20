import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepOnePage extends BasePage{
    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finish;

    @FindBy(className = "complite-header")
    WebElement infoMessage;

    public CheckOutStepOnePage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void inputPersonalInfo(String name, String last, String zip)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(last);
        postalCode.sendKeys(zip);
        continueButton.click();
    }
    public void clickFinish()
    {
        finish.click();
    }
}
