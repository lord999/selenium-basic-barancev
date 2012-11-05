package com.example.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends AnyPage {

  @FindBy(linkText = "Log out")
  public WebElement menuLogoutLink;

  @FindBy(linkText = "My profile")
  public WebElement menuMyProfileLink;

  @FindBy(linkText = "Home")
  public WebElement homeLink;

  @FindBy(linkText = "User management")
  public WebElement userManagementLink;

  public boolean isOnThisPage() {
    return menuLogoutLink.isDisplayed();
  }

  public LoginPage logout() {
    menuLogoutLink.click();
    wait_().until(alertIsPresent()).accept();
    return MyPageFactory.getPage(driver, LoginPage.class);
  }

  @Override
  void tryToOpen() {
    MyPageFactory.getPage(driver, LoginPage.class).loginWithValidCredentials("admin", "admin");
  }

  public UsersPage gotoUserManagementConsole() {
    userManagementLink.click();
    return MyPageFactory.getPage(driver, UsersPage.class);
  }
}
