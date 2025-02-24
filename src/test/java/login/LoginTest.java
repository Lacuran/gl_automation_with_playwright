package login;

import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;
import utility.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTestSetup {


  User user1 = User.createUserFrom("UserData1.json");

  @Test
  public void verifyIfUserIsLoggedSuccessfully() {
    final String expectedWelcomeMsg = "Hello, Kornel Maybe Test!";

    getBasePageFactory().getMainPage().clickMyAccountLink();
    getBasePageFactory().getCustomerLoginPage().fillingLoginData(user1);
    getBasePageFactory().getCustomerLoginPage().clickLoginButton();
    getBasePageFactory().getCustomerLoginPage().clickSecurityButton();

    assertEquals(expectedWelcomeMsg, getBasePageFactory().getMyAccountPage().getWelcomeMsg());
  }
}
