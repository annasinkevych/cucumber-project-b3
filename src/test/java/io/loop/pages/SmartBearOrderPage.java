package io.loop.pages;

import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SmartBearOrderPage extends SmartBearLogin{

    @FindBy(xpath = "//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement productsDropDown;

   public WebElement findInputBox(String name){
       WebElement element = Driver.getDriver().findElement(By.xpath("//input[@name= 'ctl00$MainContent$fmwOrder$txt"+name+"']"));
       return element;
   }

   public void clickOnProductsDropDown(String value){
      Select dropDown = new Select(productsDropDown);
      dropDown.selectByValue(value);
   }


}
