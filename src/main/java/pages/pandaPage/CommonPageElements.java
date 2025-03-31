package pages.pandaPage;

import base.page.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import lombok.Getter;

@Getter
@PageObject
public class CommonPageElements extends BasePage {
  @Find(".link-wishlist")
  Locator addToWishListButton; /*By addToWishListButton = RelativeLocator.with(By.cssSelector(".link-wishlist"))
            .below(By.cssSelector("[title='LG LCD']"));*/
  @Find(".top-link-cart")
  Locator myCartButton;
  @Find(".skip-account")
  Locator accountButton;
  @Find("[data-target-element='#header-account']")
  Locator accountSelector;
  @Find("#header-account > div > ul > li.first > a")
  Locator myAccountLink;
  @Find("[title='Log Out']")
  Locator logOut;
  @Find("//a[text()='Account Dashboard']")
  Locator accountDashboardSelector;
  @Find("//a[text()='Account Information']")
  Locator accountInformationSelector;
  @Find("//*[@id=\"proceed-button\"]")
  Locator securityProceedButton;

  public CommonPageElements(Page page) {
    super(page);
  }

  public String getPageTitle() {
    return getPage().title();
  }

}
