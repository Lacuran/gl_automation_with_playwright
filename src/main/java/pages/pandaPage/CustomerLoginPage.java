package pages.pandaPage;

import base.page.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import utility.User;

import java.util.stream.IntStream;

@PageObject
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

  public void fillingLoginData(User user) {
    loginEmail.fill(user.getEmail());
    loginPassword.fill(user.getEmail());
  }

  public void clickLoginButton() {
    loginButton.click();
  }
}
