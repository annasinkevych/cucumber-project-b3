package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //this is our POM - Project Object Model design pattern
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='input-15']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement submitButton;

    /**
     *
     * @param username
     * @param password
     */
    public void logInDocuport(String username, String password) {
       //explicit wait
        BrowserUtils.waitForVisibility(usernameInput, DocuportConstants.small);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        if(BrowserUtils.waitForVisibility(submitButton, DocuportConstants.small).isDisplayed());
        {
            submitButton.click();
        }


    }

}
