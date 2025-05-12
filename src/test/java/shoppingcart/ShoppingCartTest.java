package shoppingcart;

import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest extends BaseTestSetup {

  @Test
  public void verifyThatYouCannotAddMoreProductInCartThanTheProductAvailableInTheStore() {

}




  /*
  @Test(description = "3")
    public void verifyThatYouCannotAddMoreProductInCartThanTheProductAvailableInTheStore() {
        //variables
        PandaHomePage homePage = new PandaHomePage(driver);
        String expectedErrorMsg = "Some of the products cannot be ordered in requested quantity.";
        String expectedEmptyCartMsg = "SHOPPING CART IS EMPT";

        homePage.clickMobileLink()
                .addToCart()
                .changeQtyAndClickUpdate("1000")
                .assertErrorMSG(expectedErrorMsg, "Verify error message")
                .emptyShoppingCart()
                .verifyTheCartIsEmpty(expectedEmptyCartMsg, "Verify msg for empty cart");

    }
    */
}
