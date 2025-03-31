package login;

import base.test.BaseTestSetup;
import org.junit.jupiter.api.Test;
import utility.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTestSetup {

  User user1 = User.createUserFrom("UserData1.json", "user1");
  User user2 = User.createUserFrom("UserData1.json", "editUserInformationTestData2");

  @Test
  public void verifyIfUserIsLoggedSuccessfully() {
    final String expectedWelcomeMsg = "Hello, Kornel Maybe Test!";

    loginUser(user1);

    assertEquals(expectedWelcomeMsg, getBasePageFactory().getAccountDashboard().getWelcomeMsg().textContent());
  }



  @Test
  public void logOutUser() {
    final String expectedPageTitle = "Magento Commerce";

    loginUser(user1);
    getBasePageFactory().getAccountDashboard().getAccountSelector().click();
    getBasePageFactory().getAccountDashboard().getLogOut().click();
    assertEquals(expectedPageTitle, getBasePageFactory().getAccountDashboard().getPageTitle(), "Title don't match, please check again");

  }

  @Test
  public void verifyEditOfUserInformation() {

    loginUser(user2);

    getBasePageFactory().getAccountInformation().getAccountInformationSelector().click();
    getBasePageFactory().getAccountInformation().clearDataInfo();


    

    /*
    String[] editInfoData = {user2.getFirstName(), user2.getMiddleName(), user2.getLastName(), user2.getPassword()};
    String expectedSuccessMsg = "The account information has been saved.";
    String expectedWelcomeMSG = String.format("Hello, %s %s %s!", editInfoData[0], editInfoData[1], editInfoData[2]);

    MyAccountPage myAccountPage = homePage.clickMyAccountLink()
        .fillingLoginData(user1)
        .clickLoginButton()
        .clickAccountInformationLink()
        .editUserInformation(editInfoData)
        .clickSaveButton();

    log.info("Verify edit of user information");
    assertEquals(myAccountPage.getSuccessEditInfoMSG(), expectedSuccessMsg, "Check success MSG");
    assertEquals(myAccountPage.getWelcomeMSG(), expectedWelcomeMSG, "Check welcome MSG");*/
  }


  private void loginUser(User user) {
    getBasePageFactory().getMainPage().getAccountSelector().click();
    getBasePageFactory().getMainPage().getMyAccountLink().click();
    getBasePageFactory().getCustomerLoginPage().fillingLoginData(user);
    getBasePageFactory().getCustomerLoginPage().clickLoginButton();
    getBasePageFactory().getCustomerLoginPage().clickSecurityButton();
  }
}
