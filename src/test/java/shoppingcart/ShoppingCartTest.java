package shoppingcart;

import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;
import pages.pandaPage.MainPage;
import pages.pandaPage.MobileDeviceListingPage;
import pages.pandaPage.ShoppingCartPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest extends BaseTestSetup {

  @Test
  public void verifyThatYouCannotAddMoreProductInCartThanTheProductAvailableInTheStore() {

    String expectedItemErrorMessage = "* The maximum quantity allowed for purchase is 500.";
    String expectedErrorMessage = "Some of the products cannot be ordered in requested quantity.";

    MainPage().getMobileLink().click();
    MobileDeviseListingPage().mobileDeviceLocator("Sony Xperia").click();
    MobileDeviseListingPage().getAddToCartButton().click();
    ClickSecurityButton();
    ShoppingCartPage().getQuantity().last().fill("1000");
    ShoppingCartPage().getUpdateButton().click();
    ClickSecurityButton();

    String actualErrorMessage = ShoppingCartPage().getErrorMessage().innerText();
    String actualItemErrorMsg = ShoppingCartPage().getItemErrorMessage().innerText();

    assertEquals(expectedErrorMessage, actualErrorMessage, "check Error Message");
    assertEquals(expectedItemErrorMessage, actualItemErrorMsg, "check Item Error Message");
  }

  private ShoppingCartPage ShoppingCartPage() {
    return getBasePageFactory().getShoppingCartPage();
  }

  private MobileDeviceListingPage MobileDeviseListingPage() {
    return getBasePageFactory().getMobileDeviceListingPage();
  }

  private MainPage MainPage() {
    return getBasePageFactory().getMainPage();
  }

  private void ClickSecurityButton() {
    getBasePageFactory().getMobileDeviceListingPage().clickSecurityButton();
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
