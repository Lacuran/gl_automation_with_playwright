package pages.pandaPage;

import base.page.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;

public class CommonPageElements extends BasePage {
  @Find(".link-wishlist")
  Locator addToWishListButton; /*By addToWishListButton = RelativeLocator.with(By.cssSelector(".link-wishlist"))
            .below(By.cssSelector("[title='LG LCD']"));*/
  @Find(".top-link-cart")
  Locator myCartButton;
  @Find(".skip-account")
  Locator accountButton;

  public CommonPageElements(Page page) {
    super(page);
  }

  public String getPageTitle() {
    return getPage().title();
  }
}
