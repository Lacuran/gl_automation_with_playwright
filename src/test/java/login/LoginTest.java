package login;

import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;
import utility.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTestSetup {


  User user1 = User.createUserFrom("UserData1.json", "user1");

  @Test
  public void verifyIfUserIsLoggedSuccessfully() {
    final String expectedWelcomeMsg = "Hello, Kornel Maybe Test!";

    loginUser(user1);

    assertEquals(expectedWelcomeMsg, getBasePageFactory().getMyAccountPage().getWelcomeMsg().textContent());
  }



  @Test
  public void logOutUser() {
    final String expectedPageTitle = "Magento Commerce";

    loginUser(user1);
    getBasePageFactory().getMyAccountPage().getAccountSelector().click();
    getBasePageFactory().getMyAccountPage().getLogOut().click();
    assertEquals(expectedPageTitle, getBasePageFactory().getMyAccountPage().getPageTitle(), "Title don't match, please check again");

  }

  private void loginUser(User user) {
    getBasePageFactory().getMainPage().getAccountSelector().click();
    getBasePageFactory().getMainPage().getMyAccountLink().click();
    getBasePageFactory().getCustomerLoginPage().fillingLoginData(user);
    getBasePageFactory().getCustomerLoginPage().clickLoginButton();
    getBasePageFactory().getCustomerLoginPage().clickSecurityButton();
  }
}
