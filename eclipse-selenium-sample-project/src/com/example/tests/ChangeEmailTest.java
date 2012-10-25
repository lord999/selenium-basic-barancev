package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.esteru.selenium.factory.WebDriverFactory;

public class ChangeEmailTest {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Test
	public void testEmailChange() {
		goToMainPage();
		loginAs("admin", "admin");
		gotoUserProfile();
		changeEmailTo("admin@admin.ru");
		assertTrue(isOnUserManagementPage());
		logout();
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


	private void logout() {
		// logout
		driver.findElement(By.linkText("Log out")).click();
		driver.switchTo().alert().accept();
	}

	private void loginAs(String username, String password) {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
	}

	private void goToMainPage() {
		driver.get(baseUrl + "/php4dvd/");
	}

	@After
	public void tearDown() throws Exception {
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
