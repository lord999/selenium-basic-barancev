package com.example.tests;

import org.junit.*;

import static org.junit.Assert.*;

import com.example.pages.LoginPage;

public class LoginTest extends TestBase {

	@Test
	public void testLoginLogout() throws Exception {
		LoginPage loginPage = goToMainPage()
		  .loginWithValidCredentials("admin", "admin")
		  .logout();
		assertTrue(loginPage.isOnThisPage());
	}

}
