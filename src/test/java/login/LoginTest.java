package login;

import base.page.BasePageFactory;
import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;
import pages.pandaPage.MainPage;
import pages.pandaPage.MyAccountPage;
import utility.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTestSetup {

  MainPage mainPage = BasePageFactory.create(MainPage.class, getPage());
  MyAccountPage myAccountPage = BasePageFactory.create(MyAccountPage.class, getPage());

  private final User user1 = User.createUserFrom("Userdata1.json");

  @Test
  public void verifyIfUserIsLoggedSuccessfully() {
    final String expectedWelcomeMsg = "Hello, Kornel Maybe Test!";

    mainPage.clickMyAccountLink().fillingLoginData(user1).clickLoginButton();

    assertEquals(expectedWelcomeMsg, myAccountPage.getWelcomeMsg());
  }
}
