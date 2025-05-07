package pages.pandaPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import lombok.Getter;

@Getter
@PageObject
public class MobileDeviceListingPage extends CommonPageElements{

  @Find("//*[@id=\"product-price-1\"]/span")
  Locator priceTag;


  public MobileDeviceListingPage(Page page) {
    super(page);
  }

  public String getMobileDevicePrice(String mobileDevice) {
    return mobileDeviceLocator(mobileDevice).last().innerText();
  }

  private Locator mobileDeviceLocator(String mobileDevice) {
    return getPage().locator("[title='" + mobileDevice + "']");
  }
}
