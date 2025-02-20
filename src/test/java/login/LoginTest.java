package login;

import base.page.BasePageFactory;
import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;
import pages.pandaPage.CustomerLoginPage;
import pages.pandaPage.MainPage;
import pages.pandaPage.MyAccountPage;
import utility.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTestSetup {



  User user1 = User.createUserFrom("UserData1.json");

  @Test
  public void verifyIfUserIsLoggedSuccessfully() {
    final String expectedWelcomeMsg = "Hello, Kornel Maybe Test!";
    MainPage mainPage = BasePageFactory.create(MainPage.class, getPage());
    MyAccountPage myAccountPage = BasePageFactory.create(MyAccountPage.class, getPage());
    CustomerLoginPage customerLoginPage = BasePageFactory.create(CustomerLoginPage.class, getPage());
    mainPage.clickMyAccountLink();
    customerLoginPage.fillingLoginData(user1);
    customerLoginPage.clickLoginButton();
    customerLoginPage.clickSecurityButton();

    assertEquals(expectedWelcomeMsg, myAccountPage.getWelcomeMsg());
  }
}
