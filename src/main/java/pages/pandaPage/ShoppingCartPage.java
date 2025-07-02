package pages.pandaPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import lombok.Getter;

@Getter
@PageObject
public class ShoppingCartPage extends CommonPageElements {

  @Find(".button.btn-update")
  Locator updateButton;
  @Find(".qty")
  Locator quantity;
  @Find(".item-msg.error")
  Locator itemErrorMessage;
  @Find(".error-msg")
  Locator errorMessage;

  public ShoppingCartPage(Page page) {
    super(page);
  }

}
