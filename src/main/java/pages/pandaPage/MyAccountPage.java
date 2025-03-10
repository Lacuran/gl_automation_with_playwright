package pages.pandaPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;

@PageObject
public class MyAccountPage extends CommonPageElements {

  @Find(".hello")
  Locator welcomeMsg;
  //TODO: add locators


  public MyAccountPage(Page page) {
    super(page);
  }

  public String getWelcomeMsg() {
    return welcomeMsg.textContent();
  }

  public void logOut(){

  }
}
