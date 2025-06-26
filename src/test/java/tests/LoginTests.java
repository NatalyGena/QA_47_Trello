package tests;

import dto.User;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends AppManager {
    @Test
    public void loginPositiveTest(){
        User user =User.builder()
                .email("genahsvili81@gmail.com")
                .password("Ben5mira8")
                .build();
 new HomePage(getDriver()).clickBtnLogin();

    }
}
