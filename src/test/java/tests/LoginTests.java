package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {
    @Test(groups = {"smoke"})
    public void loginPositiveTest() {
        User user = User.builder()
                .email("genahsvili81@gmail.com")
                .password("Ben5mira8")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl());
    }
}
