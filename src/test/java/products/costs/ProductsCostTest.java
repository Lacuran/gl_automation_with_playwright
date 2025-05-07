package products.costs;

import base.test.BaseTestSetup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductsCostTest extends BaseTestSetup {


  @ParameterizedTest
  @ValueSource(strings = {"Sony Xperia", "IPhone", "Samsung Galaxy"})
  public void verifyCostOfProductInListPageAndDetailsPageTest(String phoneName) {

    getBasePageFactory().getMainPage().getMobileLink().click();
    var deviceCostOnMobileListingPage = getBasePageFactory().
        getMobileDeviceListingPage().
        getMobileDevicePrice(phoneName);
//    var price = getBasePageFactory().getMobileDeviceListingPage().getSonyDevicePrice().innerText();

//    System.out.println(price);
    System.out.println(deviceCostOnMobileListingPage);

  }


  /*@DataProvider(name = "smartphone")
  public Object[][] dpMethod() {
    return new Object[][]{
        {"Sony Xperia"},
        {"IPhone"},
        {"Samsung Galaxy"}
    };
  }

  @Test(dataProvider = "smartphone", description = "2")
  public void verifyCostOfProductInListPageAndDetailsPageTest(String phoneName) {
    PandaHomePage homePage = new PandaHomePage(driver);

    log.info("2. Click on the 'MOBILE' menu");
    ProductListingPage productListingPage = homePage.clickMobileLink();

    log.info("3. In the list of all mobile, read the cost of Sony XPeria mobile. Note this value.");
    String phoneCostOnMobilePage = productListingPage.getPhoneCostString(phoneName);

    log.info("4. Click on the Sony XPeria mobile");
    ProductDetailPage detailPage = productListingPage.clickPhoneCssSelector(phoneName);

    log.info("5. Read the cost of mobile in detail page");
    String phoneCostOnMobileDetailsPage = detailPage.getProductCost();

    log.info("6. Compare value in Step 3 and Step 5");
    assertEquals(phoneCostOnMobilePage, phoneCostOnMobileDetailsPage, "Compare value in Step 3 and Step 5");
  }*/
}
