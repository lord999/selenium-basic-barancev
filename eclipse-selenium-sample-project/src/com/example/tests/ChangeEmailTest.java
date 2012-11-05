package com.example.tests;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;

import com.example.pages.InternalPage;

public class ChangeEmailTest extends TestBase {

	@Test
	public void testEmailChange() {
		InternalPage aPage = goToMainPage().loginWithValidCredentials("admin", "admin");
		gotoUserProfile();
		changeEmailTo("admin@admin.ru");
		assertTrue(isOnUserManagementPage());
		aPage.logout();
	}
	
	private boolean isOnUserManagementPage() {
		return driver.findElement(By.className("content"))
				.findElement(By.tagName("h2")).getText().equals("User management");
	}


	private void changeEmailTo(String string) {
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("admin@admin.ru");
	    driver.findElement(By.name("submit")).click();
	}


	private void gotoUserProfile() {
	    driver.findElement(By.linkText("My profile")).click();
	}


}
