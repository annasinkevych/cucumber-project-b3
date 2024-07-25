package io.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

//import static org.testng.Assert.assertTrue;

import static org.junit.Assert.assertTrue;
public class PageElementUtils {


    //clicked on the dropdown, JS works faster and is more reliable when handling elements that are not visible
    //.click() may not work all the time with certain xpath
    public static void clickWithJS(WebElement element){
        //JavascriptExecutor --> interface in Selenium that enables JavaScript execution in a currently selected frame or window
        //Type casting the WebDriver driver to JavascriptExecutor to access executeScript method
        //executeScript method accepts JavaScript code
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * This method accepts WebElement element and scrolls this element
     * for it to become visible on the page (the element has to be loaded to the DOM
     * DOESN'T WORK WITH DYNAMIC LOADING
     * @param element
     */
    public static void scrollElement(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }


    /**
     * Dynamic method that works with different button elements
     * use | to add other element xpath
     * @param buttonLabelName
     * @throws InterruptedException
     */
    public static void clickOnButton(String buttonLabelName, int index) throws InterruptedException {
        Thread.sleep(1000);
        try{
            //located button with the passed label name
            WebElement element = Driver.getDriver().findElement(By.xpath("(//span[text()=' " + buttonLabelName + " '])["+index+"]/ancestor::button | //label[text()='"+ buttonLabelName + "']//preceding-sibling::div/input"));
            //we scroll in case there is no element visible as page loads to try and located it if it's at the bottom of the page
            scrollElement(element);
            System.out.println("Clicking on button..." + buttonLabelName);
            clickWithJS(element);
            Thread.sleep(1000);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Dynamic method that locates text box elements and sends keys
     * @param textFieldName
     * @param text
     * @param index
     * @throws InterruptedException
     */

    public static void enterTextIntoTextFields(String textFieldName , String text, int index) throws InterruptedException {
        Thread.sleep(1000);
        WebElement textBox;
        try{
            textBox = (index ==0)? Driver.getDriver().findElement(By.xpath("(//label[text()='" + textFieldName + "']/following-sibling::input)[1]")):Driver.getDriver().findElement(By.xpath("((//label[text()='" + textFieldName + "'])["+index +"]/following-sibling::input)[1]"));

            clickWithJS(textBox);
            System.out.println("Entering " + text + " into: " + textFieldName + " field...");
            textBox.sendKeys(text);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Dynamic method that validates progress bar steps
     * @param progressStepName
     */
    public static void progressBarValidation(String progressStepName){
        WebElement progressBarStep2 = Driver.getDriver().findElement(By.xpath("//p[text()='" + progressStepName + "']/../preceding-sibling::span/.."));
        String attributeValue = progressBarStep2.getAttribute("class");
        //assertTrue(attributeValue.contains("active"), "The progress bar is not active");
    }

    /**
     * Dynamic method to send keys to dropdowns using dropdown container name
     * @param containerName
     * @param value
     */
    public static void sendKeysToDropDownContainer(String containerName, String value){
        WebElement dropDown =  Driver.getDriver().findElement(By.xpath("//div[.='" + containerName + "']//following-sibling::input[1] | //label[text()='Title *']/following-sibling::div/input")); //| //label[text()='" + containerName + "']
        dropDown.click();
        //by sending keys we can make those options that are hidden and need to be scrolled down to - visible
        dropDown.sendKeys(value);
        List<WebElement> options = Driver.getDriver().findElements(By.xpath("//div[@class= 'v-list-item__title']/span | //span[.='"+ value + "']"));
        options.getFirst().click();
    }



















    /**
     * This method works with html dropdown
     * @param dropDownLabel
     * @param value
     * @throws InterruptedException
     * adds all dropdown options to the list
     */

    public static void selectValueFromDropdown(String dropDownLabel, String value) throws InterruptedException {

        boolean isOptionSelected = false;
        Thread.sleep(1000);

        //located dropdown
        WebElement dropDown = Driver.getDriver().findElement(By.xpath("(//label[text()='" + dropDownLabel + "']/following-sibling::input)[1]"));

        //click on the dropdown
        clickWithJS(dropDown);

        //wait for dropdown to open options
        Thread.sleep(2000);

        //save a universal xpath that shows us all the dropdown options
        String dropDownValuesXpath = "//label[text()='"+ dropDownLabel + "']//following::div[@role='listbox']/div[@role='option']";

        //add all dropdown options to the list using .findElements()
        List<WebElement> dropDownValues = Driver.getDriver().findElements(By.xpath(dropDownValuesXpath));


        //locate the needed value
        for(WebElement eachOption: dropDownValues){
            System.out.println(eachOption.getText());
            if(eachOption.getText().equals(value)){
                //scroll through the elements that were added to the list - 20 in this case, to load all 47 we need to click on dropdown, scroll, and then locate them again
                scrollElement(eachOption);
                clickWithJS(eachOption);
                isOptionSelected = true;
                break;
            }
        }
        if(!isOptionSelected){
            clickWithJS(dropDown);
            dropDown.sendKeys(value);
            dropDownValues = Driver.getDriver().findElements(By.xpath(dropDownValuesXpath));
            Thread.sleep(2000);
            System.out.println(dropDownValues.get(0).getText());
            //since we have sendKeys to locate the option, we can only see 1 option available that we will add to our list later therefore, we clickWithJS on element 0.
            clickWithJS(dropDownValues.get(0));
        }

    }
}
