package base.test;

import com.microsoft.playwright.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
@Getter
public class BaseTestSetup {
  private final String URL = "https://live.techpanda.org/";
  private static Playwright playwright;
  private static Browser browser;
  private BrowserContext context;
  private Page page;


  @BeforeAll
  static void launchBrowser() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
  }

  @AfterAll
  static void closeBrowser() {
    playwright.close();
  }

  @BeforeEach
  void createContextAndPage() {
    context = browser.newContext();
    page = context.newPage();
    page.navigate(URL);
  }

  @AfterEach
  void closeContext() {
    context.close();
  }
}
