package pl.coderslab.task1.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage
{
    private static WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasField;

    @FindBy(name = "address1")
    private WebElement addressField;

    @FindBy(name = "postcode")
    private WebElement postcodeField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(name = "id_country")
    private WebElement countrySelectList;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(name = "submitAddress")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewAddress (String alias, String address, String postcode, String city, String phone)
    {
        aliasField.sendKeys(alias);
        addressField.sendKeys(address);
        postcodeField.sendKeys(postcode);
        cityField.sendKeys(city);

        Select countrySelect = new Select(countrySelectList);
        countrySelect.selectByVisibleText("United Kingdom");

        phoneField.sendKeys(phone);
    }
    public void saveAddress()
    {
        saveButton.submit();
    }
}
