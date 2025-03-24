package pages.pandaPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import lombok.Getter;
import org.awaitility.Awaitility;
import utility.User;

import java.time.Duration;

@Getter
@PageObject
public class CustomerLoginPage extends CommonPageElements {

  @Find("[title='Create an Account']")
  Locator createAccButton;
  @Find("#email")
  Locator loginEmail;
  @Find("#pass")
  Locator loginPassword;
  @Find("#send2")
  Locator loginButton;
  @Find("//*[@id=\"proceed-button\"]")
  Locator securityProceedButton;


  public CustomerLoginPage(Page page) {
    super(page);
  }

  public void fillingLoginData(User user) {
    loginEmail.fill(user.getEmail());
    loginPassword.fill(user.getPassword());
  }

  public void clickLoginButton() {
    Awaitility.await().pollDelay(Duration.ofSeconds(1)).until(() -> true);
    loginButton.click();

  }

  public void clickSecurityButton() {
    Awaitility.await().pollDelay(Duration.ofSeconds(1)).until(() -> true);
    securityProceedButton.click();
  }
}
