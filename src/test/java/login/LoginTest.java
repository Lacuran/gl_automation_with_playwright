package login;

import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;
import pages.pandaPage.MainPage;
import pages.pandaPage.MyAccountPage;

public class LoginTest extends BaseTestSetup {

  @Test
  public void verifyIfUserIsLoggedSuccessfully() {
    MainPage mainPage = new MainPage(getPage());
    MyAccountPage myAccountPage = mainPage.clickMyAccountLink().
  }
}
