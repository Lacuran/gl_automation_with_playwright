package pages.pandaPage;

import base.page.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import utility.User;

import java.util.stream.IntStream;

public class CustomerLoginPage extends BasePage {

  @Find("[title='Create an Account']")
  Locator createAccButton;
  @Find("email")
  Locator loginEmail;
  @Find("pass")
  Locator loginPassword;
  @Find("send2")
  Locator loginButton;

  public CustomerLoginPage(Page page) {
    super(page);
  }

  public CustomerLoginPage fillingLoginData(User user) {
    String[] loginData = {user.getEmail(), user.getPassword()};
    IntStream.range(0, loginData.length)
        .forEach(i -> driver.findElement(loginID[i]).sendKeys(loginData[i]));
    return this;
  }
}
