package base.page;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pages.pandaPage.AccountInformation;
import pages.pandaPage.CustomerLoginPage;
import pages.pandaPage.MainPage;
import pages.pandaPage.AccountDashboard;

import static io.github.uchagani.stagehand.PageFactory.create;

@Getter
public class BasePageFactory extends BasePage{

  private final MainPage mainPage;
  private final CustomerLoginPage customerLoginPage;
  private final AccountDashboard accountDashboard;
  private final AccountInformation accountInformation;

  public BasePageFactory(Page page) {
    super(page);
    mainPage = create(MainPage.class, getPage());
    customerLoginPage = create(CustomerLoginPage.class, getPage());
    accountDashboard = create(AccountDashboard.class, getPage());
    accountInformation = create(AccountInformation.class, getPage());
  }



}
