package base.page;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pages.pandaPage.CustomerLoginPage;
import pages.pandaPage.MainPage;
import pages.pandaPage.MyAccountPage;

import static io.github.uchagani.stagehand.PageFactory.create;

@Getter
public class BasePageFactory extends BasePage{

  private final MainPage mainPage;
  private final CustomerLoginPage customerLoginPage;
  private final MyAccountPage myAccountPage;

  public BasePageFactory(Page page) {
    super(page);
    mainPage = create(MainPage.class, getPage());
    customerLoginPage = create(CustomerLoginPage.class, getPage());
    myAccountPage = create(MyAccountPage.class, getPage());
  }



}
