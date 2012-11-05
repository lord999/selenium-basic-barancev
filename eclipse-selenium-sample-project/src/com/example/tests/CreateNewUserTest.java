package com.example.tests;

import org.junit.*;
import static org.junit.Assert.*;

import com.example.model.SortedListOf;
import com.example.model.User;
import com.example.pages.UsersPage;

public class CreateNewUserTest extends TestBase {

  @Test
  public void createNewUser() {
    UsersPage userPage = goToMainPage()
        .loginWithValidCredentials("admin", "admin")
        .gotoUserManagementConsole();

    SortedListOf<User> oldUserList = userPage.getUsers();

    User user = new User()
        .withName("aaa").withEmail("aaa@test.com").withPassword("test");
    if (oldUserList.contains(user)) {
      userPage.deleteUser(user);
      oldUserList = userPage.getUsers();
    }

    userPage.createUser(user);

    SortedListOf<User> newUserList = userPage.getUsers();

    assertEquals(newUserList, oldUserList.withAdded(user));
    
    userPage.logout();
  }

}
