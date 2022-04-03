package pl.coderslab.task1.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage
{
    private static WebDriver driver;

    @FindBy(xpath = "//*[@id=\"address-link\"]/span/i")
    private WebElement addressButton;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement successMessage;

    @FindBy (xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]")
    private WebElement deleteButton;

    @FindBy(css = "#notifications > div > article")
    private WebElement deletionMessage;

    public MyAccountPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openNewAddressForm()
    {
        addressButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void deleteAddress() {
        deleteButton.click();
    }
    public String getDeletionMessage(){
        return deletionMessage.getText();
    }
}
