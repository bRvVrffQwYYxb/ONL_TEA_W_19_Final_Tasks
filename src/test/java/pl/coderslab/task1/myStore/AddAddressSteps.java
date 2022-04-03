package pl.coderslab.task1.myStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class AddAddressSteps
{
    private WebDriver driver;
    private NewAddressPage newAddressPage;
    private MyAccountPage accountPage;

    @Given("^An open browser with (.*) site")
    public void pageOpenedInBrowser(String pageUrl)
    {
        System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
        this.driver = new EdgeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        this.driver.get(pageUrl);
    }

    @When("^User signs in$")
    public void shouldLoginWithProperCredentials()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("lxlyqqwozkgwsvbnxw@nthrw.com", "abcd1234");
    }

    @And("^User clicks Add fist address or Create new address button$")
    public void shouldOpenNewAddressForm()
    {
        accountPage = new MyAccountPage(driver);
        accountPage.openNewAddressForm();
    }

    @And("^User fills New address form with (.*) (.*) (.*) (.*) (.*)$")
    public void userFillsNewAddressForm(String alias, String address, String postcode, String city, String phone)
    {
        newAddressPage = new NewAddressPage(driver);
        newAddressPage.createNewAddress(alias, address, postcode, city, phone);
    }

    @And("^User clicks SAVE button$")
    public void userClicksSaveButton()
    {
        newAddressPage.saveAddress();
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void addressAddedMessage(String message)
    {
        Assertions.assertEquals(message, accountPage.getSuccessMessage());
    }

    @And ("^User deletes this address$")
    public void userDeletesAddress()
    {
        accountPage.deleteAddress();
    }

    @Then("^He sees \"([^\"]*)\"$")
    public void addressDeletedMessage(String message)
    {
        Assertions.assertEquals(message, accountPage.getDeletionMessage());
    }

}
