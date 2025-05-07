package pages.pandaPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import io.github.uchagani.stagehand.annotations.Under;
import lombok.Getter;

@Getter
@PageObject
public class MobileDeviceListingPage extends CommonPageElements{

  @Find("[title='Sony Xperia']")
  Locator sonyDevice;

  @Find("[class='price']")
  Locator sonyDevicePrice;


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
