package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends InternalPage {

	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(name = "submit")
	public WebElement saveButton;
}
