package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.example.pages.LoginPage;
import com.example.pages.MyPageFactory;

import ru.esteru.selenium.factory.WebDriverFactory;

public class TestBase {

  protected WebDriver driver;
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
    WebDriverFactory.setDefaultHub(System.getProperty("webdriver.hub"));

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setBrowserName(System.getProperty("webdriver.browser", "firefox"));

    Platform platform = Platform.valueOf(System.getProperty("webdriver.platform", "WINDOWS"));
    caps.setPlatform(platform);

    driver = WebDriverFactory.getDriver(caps);
    baseUrl = "http://192.168.1.100/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public LoginPage goToMainPage() {
    driver.get(baseUrl + "/php4dvd/");
    return MyPageFactory.getPage(driver, LoginPage.class);
  }

}
