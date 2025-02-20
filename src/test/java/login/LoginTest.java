package login;

import base.test.BaseTestSetup;
import io.github.uchagani.stagehand.PageFactory;
import org.junit.jupiter.api.Test;
import pages.pandaPage.MainPage;
import pages.pandaPage.MyAccountPage;
import utility.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTestSetup {

  MainPage mainPage;
  MyAccountPage myAccountPage;

  private final User user1 = User.createUserFrom("Userdata1.json");

  @Test
  public void verifyIfUserIsLoggedSuccessfully() {
    final String expectedWelcomeMsg = "Hello, Kornel Maybe Test!";

    mainPage.clickMyAccountLink().fillingLoginData(user1).clickLoginButton();

    assertEquals(expectedWelcomeMsg, myAccountPage.getWelcomeMsg());
  }
}
