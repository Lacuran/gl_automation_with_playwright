package pages.pandaPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import lombok.Getter;

@Getter
@PageObject
public class MyAccountPage extends CommonPageElements {

  @Find(".hello")
  Locator welcomeMsg;

  @Find("//strong[text()='Account Information']")
  Locator accountInformation;


  public MyAccountPage(Page page) {
    super(page);
  }


}
