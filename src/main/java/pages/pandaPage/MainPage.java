package pages.pandaPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import lombok.Getter;

@Getter
@PageObject
public class MainPage extends CommonPageElements {
  @Find("//*[text()='Mobile']")
  Locator mobileLink;

  @Find("//*[text()='TV']")
  Locator tvXpath;

  @Find("[title='Advanced Search']")
  Locator advanceSearchLink;

  public MainPage(Page page) {
    super(page);
  }

}
