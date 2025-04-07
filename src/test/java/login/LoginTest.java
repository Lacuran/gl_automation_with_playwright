package login;

import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;
import pages.pandaPage.AccountInformation;
import utility.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTestSetup {

  User user1 = User.createUserFrom("UserData1.json", "user1");
  User user2 = User.createUserFrom("UserData1.json", "editUserInformationTestData2");

  @Test
  public void verifyIfUserIsLoggedSuccessfully() {
    final var expectedWelcomeMsg = "Hello, Kornel Maybe Test!";

    loginUser(user1);

    assertEquals(expectedWelcomeMsg, getBasePageFactory().getAccountDashboard().getWelcomeMsg().textContent());
  }



  @Test
  public void logOutUser() {
    final var expectedPageTitle = "Magento Commerce";

    loginUser(user1);
    getBasePageFactory().getAccountDashboard().getAccountSelector().click();
    getBasePageFactory().getAccountDashboard().getLogOut().click();
    assertEquals(expectedPageTitle, getBasePageFactory().getAccountDashboard().getPageTitle(), "Title don't match, please check again");

  }

  @Test
  public void verifyEditOfUserInformation() {

    final var expectedFirstName = "Aloha";
    final var expectedMiddleName = "Middle";
    final var expectedLastName = "Kek";
    final var expectedWelcomeMsg = String.format("Hello, %s %s %s!", expectedFirstName, expectedMiddleName, expectedLastName);
    loginUser(user2);

    accountInformation().getAccountInformationSelector().click();
    accountInformation().getFirstName().clear();
    accountInformation().getFirstName().fill(expectedFirstName);
    accountInformation().getMiddleName().clear();
    accountInformation().getMiddleName().fill(expectedMiddleName);
    accountInformation().getLastName().clear();
    accountInformation().getLastName().fill(expectedLastName);
    accountInformation().getCurrentPassword().fill(user2.getPassword());
    accountInformation().getSaveButton().click();
    accountInformation().clickSecurityButton();

    assertEquals(expectedWelcomeMsg, getBasePageFactory().getAccountDashboard().getWelcomeMsg().textContent(), "Check welcome message");

  }

  private AccountInformation accountInformation() {
    return getBasePageFactory().getAccountInformation();
  }


  private void loginUser(User user) {
    getBasePageFactory().getMainPage().getAccountSelector().click();
    getBasePageFactory().getMainPage().getMyAccountLink().click();
    getBasePageFactory().getCustomerLoginPage().fillingLoginData(user);
    getBasePageFactory().getCustomerLoginPage().clickLoginButton();
    getBasePageFactory().getCustomerLoginPage().clickSecurityButton();
  }
}
