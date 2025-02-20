package base.page;

import com.microsoft.playwright.Page;
import io.github.uchagani.stagehand.PageFactory;

public class BasePageFactory {
  public static <T> T create(Class<T> pageClass, Page page) {
    return PageFactory.create(pageClass, page);
  }

}
