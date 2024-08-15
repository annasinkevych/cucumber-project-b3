package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearLogin {

    public SmartBearLogin(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='ctl00$MainContent$username']")
    public WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath="//li/a")
    public List<WebElement> modules;

    @FindBy(xpath = "//h2")
    public WebElement listOfOrders;

    public void logIn(){
        username.sendKeys(ConfigurationReader.getProperties("smart.username"));
        password.sendKeys(ConfigurationReader.getProperties("smart.password"));
        loginButton.click();

    }

    public void navigateTo(String moduleName){

        for(WebElement module : modules){
            if(module.getText().equals(moduleName)){
                module.click();
                break;
            }
        }
    }




}
