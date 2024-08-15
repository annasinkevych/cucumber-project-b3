package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.SmartBearLogin;
import io.loop.pages.SmartBearOrderPage;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;

public class SmartBearStepDefs {

    SmartBearLogin smartBearLogin = new SmartBearLogin();
    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage();
    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("smart.bear"));
        smartBearLogin.logIn();
        BrowserUtils.waitForClickable(smartBearLogin.listOfOrders, 3 );
        smartBearLogin.navigateTo("Order");
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String option) {
        smartBearOrderPage.clickOnProductsDropDown(option);
    }

    @When("user enters quantity {string}")
    public void user_enters_quantity(String type) {
        WebElement element =smartBearOrderPage.findInputBox("Quantity");
        element.sendKeys(type);
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String name) {
       WebElement element = smartBearOrderPage.findInputBox("Name");
       element.sendKeys(name);
    }
    @When("user enters street {string}")
    public void user_enters_street(String street) {
        smartBearOrderPage.findInputBox(street);
    }
    @When("user enters city {string}")
    public void user_enters_city(String city) {
        smartBearOrderPage.findInputBox(city);
    }
    @When("user enters state {string}")
    public void user_enters_state(String state) {
        smartBearOrderPage.findInputBox(state);
    }
    @When("user enters zip {string}")
    public void user_enters_zip(String zip) {
        smartBearOrderPage.findInputBox(zip);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {

    }
    @When("user enters credit car number {string}")
    public void user_enters_credit_car_number(String cardNumber) {
        smartBearOrderPage.findInputBox(cardNumber);
    }
    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String expirationDate) {
        smartBearOrderPage.findInputBox(expirationDate);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {

    }
    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String string) {

    }

}
