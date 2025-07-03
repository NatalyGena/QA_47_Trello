package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlassianPage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ChangeProfileTests extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public void login(Method method) {
        User user = User.builder()
                .email("genahsvili81@gmail.com")
                .password("Ben5mira8")
                .build();
        logger.info("Start method --->>>"+method.getName()
                +"with user data: " + user);
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());

    }

    @Test
    public void changeProfilePhoto() {
        boardsPage.openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver()
                .getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianPage atlassianPage = new AtlassianPage(getDriver());
        atlassianPage.changeMyProfilePhoto("src/main/resources/WhatsApp 2025-06-06 в 18.05.36_579bab8c.jpg");
        Assert.assertTrue(atlassianPage.validateMessage("We've uploaded your new avatar." +
                " It may take a few minutes to display everywhere."));

    }
}
