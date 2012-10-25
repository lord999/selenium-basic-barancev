package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AnyPage {

  @FindBy(id = "loginform")
  public WebElement loginForm;

  @FindBy(name = "username")
  public WebElement userNameField;

  @FindBy(name = "password")
  public WebElement passwordField;

  @FindBy(name = "submit")
  public WebElement loginButtton;

  public boolean isOnThisPage() {
    return loginForm.isDisplayed();
  }

}
