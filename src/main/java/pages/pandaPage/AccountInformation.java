package pages.pandaPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.annotations.Find;
import io.github.uchagani.stagehand.annotations.PageObject;
import lombok.Getter;

@PageObject
@Getter
public class AccountInformation extends CommonPageElements{

  @Find("#firstname")
  Locator firstName;
  @Find("#middlename")
  Locator middleName;
  @Find("#lastname")
  Locator lastName;
  @Find("#email")
  Locator accountInformationEmailField;
  @Find("#current_password")
  Locator currentPassword;
  @Find("[title='Save']")
  Locator saveButton;

  public AccountInformation(Page page) {
    super(page);
  }

  public void clearDataInfo() {
    getFirstName().clear();
    getMiddleName().clear();
    getLastName().clear();
    getAccountInformationEmailField().clear();
    getCurrentPassword().clear();
  }

}
