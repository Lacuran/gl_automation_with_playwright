package base.test;

import base.page.BasePageFactory;
import com.microsoft.playwright.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utility.LaunchOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Getter
public class BaseTestSetup {
  private final String URL = "https://live.techpanda.org/";
  private static Playwright playwright;
  private static Browser browser;
  private BrowserContext context;
  private Page page;
  private BasePageFactory basePageFactory;


  @BeforeAll
  static void launchBrowser() {
    List<String> launchOptions = Arrays.asList(
        "--start-maximized",
        "--disable-web-security",
        "--allow-running-insecure-content",
        "--ignore-certificate-errors",
        "--remote-allow-origins=*",
        "--disable-site-isolation-trials",
        "--disable-features=IsolateOrigins,site-per-process",
        "--disable-popup-blocking"
    );

    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(launchOptions));
  }

  @AfterAll
  static void closeBrowser() {
    playwright.close();
  }

  @BeforeEach
  public void createContextAndPage() {
    context = browser.newContext();
    page = context.newPage();
    page.navigate(URL);
    basePageFactory = new BasePageFactory(page);
  }

  @AfterEach
  public void closeContext() {
    context.close();
  }
}
