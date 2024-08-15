package io.loop.step_definitions;

import io.cucumber.java.en.*;
import io.cucumber.messages.types.Product;
import io.loop.pages.ProductPage;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Map;

public class ProductStepDefs {

    //create a LOG for this task
    private static final Logger LOG = LogManager.getLogger();
    ProductPage productPage = new ProductPage();

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("product.url"));
        LOG.info("User is on the HomePage");
    }
    @Then("User should be able to see expected prices in the following products")
    public void user_should_be_able_to_see_expected_prices_in_the_following_products(List<Map<String, String>> productDetails) {

        //here we are iterating the list of map from our product.feature file
        for (Map<String, String> productDetail : productDetails) {
//            System.out.println("===========Product details:==========");
//            System.out.println("Category: " + productDetail.get("Category"));
//            System.out.println("Product: " +productDetail.get("Product"));
//            System.out.println("Expected Price: " +productDetail.get("expectedPrice"));
            productPage.clickCategory(productDetail.get("Category"));
            //get actual price
            String actualPrice = productPage.getProductPrice(productDetail.get("Product"));
            String expectedPrice = productDetail.get("expectedPrice");
            Assert.assertEquals(expectedPrice,actualPrice);
            LOG.info("Validation of the price" + productDetail.get("Category") + ", for Product " + productDetail.get("Product"));
        }
    }

    @Then("User should be able to see expected prices in following products with listOflist")
    public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_oflist(List<List<String>> productDetails) {
        for(List<String> productDetail : productDetails) {
            productPage.clickCategory(productDetail.get(0));
            String actualPrice = productPage.getProductPrice(productDetail.get(1));
            String expectedPrice = productDetail.get(2);
            Assert.assertEquals(expectedPrice,actualPrice);
            LOG.info("Validation of the price" + productDetail.get(0)+ ", for Product " + productDetail.get(1) + " with actual price: " + actualPrice + " VS expected price: " + expectedPrice);
        }
    }

}
