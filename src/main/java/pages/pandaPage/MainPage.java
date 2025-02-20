package pages.pandaPage;

import base.page.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import io.github.uchagani.stagehand.annotations.Under;

@PageObject
public class MainPage extends BasePage {
  @Find("//*[text()='Mobile']")
  Locator mobileLink;

  @Find("//*[text()='TV']")
  Locator tvXpath;

  @Find("[data-target-element='#header-account']")
  Locator accountCssSelector;

  @Find("#header-account > div > ul > li.first > a")
  Locator myAccountLink;

  @Find("[title='Advanced Search']")
  Locator advanceSearchLink;

  public MainPage(Page page) {
    super(page);
  }

  public void clickMyAccountLink() {
    accountCssSelector.click();
    myAccountLink.click();
  }
}
