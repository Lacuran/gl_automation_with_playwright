package login;

import base.page.BasePageFactory;
import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;
import utility.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTestSetup {


  User user1 = User.createUserFrom("UserData1.json");

  @Test
  public void verifyIfUserIsLoggedSuccessfully() {
    final String expectedWelcomeMsg = "Hello, Kornel Maybe Test!";
    BasePageFactory basePageFactory = new BasePageFactory(getPage());
    basePageFactory.getMainPage().clickMyAccountLink();
    basePageFactory.getCustomerLoginPage().fillingLoginData(user1);
    basePageFactory.getCustomerLoginPage().clickLoginButton();
    basePageFactory.getCustomerLoginPage().clickSecurityButton();

    assertEquals(expectedWelcomeMsg, basePageFactory.getMyAccountPage().getWelcomeMsg());
  }
}
