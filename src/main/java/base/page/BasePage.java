package base.page;

import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class BasePage {
  private Page page;

  public BasePage(Page page) {
    this.page = page;
  }
}
