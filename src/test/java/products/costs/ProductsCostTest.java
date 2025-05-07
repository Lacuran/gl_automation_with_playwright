package products.costs;

import base.test.BaseTestSetup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsCostTest extends BaseTestSetup {


  @ParameterizedTest
  @CsvSource({"Sony Xperia, 0",
      "IPhone, 1",
      "Samsung Galaxy, 3"})
  public void verifyCostOfProductInListPageAndDetailsPageTest(String phoneName, String priceIndex) {

    getBasePageFactory().getMainPage().getMobileLink().click();
    var devicePriceTagOnMobileListingPage = getBasePageFactory()
        .getMobileDeviceListingPage()
        .getPriceTag()
        .nth(Integer.parseInt(priceIndex)).innerText();

    getBasePageFactory().getMobileDeviceListingPage().mobileDeviceLocator(phoneName).last().click();

    var devicePriceTagOnDetailsPage = getBasePageFactory()
        .getMobileDeviceListingPage()
        .getPriceTag()
        .last().innerText();

    assertEquals(devicePriceTagOnMobileListingPage, devicePriceTagOnDetailsPage, "Price don't match");

  }
}
