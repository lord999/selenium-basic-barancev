package com.example.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.example.model.SortedListOf;
import com.example.model.User;

public class UsersPage extends InternalPage {

  @FindBy(name = "username")
  public WebElement usernameField;

	@FindBy(name = "email")
	public WebElement emailField;

  @FindBy(name = "password")
  public WebElement passwordField;

  @FindBy(name = "password2")
  public WebElement passwordConfirmationField;

	@FindBy(name = "submit")
	public WebElement saveButton;
	
	@FindBy(css = "div#user-list table > tbody > tr")
	public List<WebElement> userRows;

	public UsersPage createUser(User user) {
    usernameField.sendKeys(user.name);
    emailField.sendKeys(user.email);
    passwordField.sendKeys(user.password);
    passwordConfirmationField.sendKeys(user.password);
    saveButton.click();
    cachedUsers = null;
    return MyPageFactory.getPage(driver, UsersPage.class);
  }

  public UsersPage deleteUser(User user) {
    for (WebElement row : userRows) {
      if (user.equals(convertRowToUser(row))) {
        row.findElement(By.xpath("./td[6]/a")).click();
        wait_().until(alertIsPresent()).accept();
        break;
      }
    }
    cachedUsers = null;
    return MyPageFactory.getPage(driver, UsersPage.class);
  }

  private SortedListOf<User> cachedUsers;
  
  public SortedListOf<User> getUsers() {
    if (cachedUsers == null) {
      cachedUsers = new SortedListOf<User>();
      for (WebElement row : userRows) {
        cachedUsers.add(convertRowToUser(row));
      }
    }

    return new SortedListOf<User>(cachedUsers);
  }
  
  public int getUserCount() {
    return userRows.size();
  }

  private User convertRowToUser(WebElement row) {
    List<WebElement> cells = row.findElements(By.tagName("td"));
    return new User()
      .withName(cells.get(1).getText())
      .withEmail(cells.get(2).getText())
      .withRole(cells.get(3).getText());
  }

}
