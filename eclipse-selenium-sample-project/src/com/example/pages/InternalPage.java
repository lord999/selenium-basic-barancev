package com.example.pages;

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
}
