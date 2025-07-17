package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.lang.reflect.Method;

import static utils.RandomUtils.generateString;

public class DeleteBoardTests extends AppManager {
    BoardsPage boardsPage;


    @BeforeMethod(alwaysRun = true)
    public void login(Method method){
        User user = User.builder()
                .email("genahsvili81@gmail.com")
                .password("Ben5mira8")
                .build();
        logger.info("Start method --->>>"+method.getName()
                +"with user data: " + user);
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
        Board board =Board.builder().boardTitle(generateString(5)).build();
        boardsPage.createNewBoard(board);


    }
    @Test(groups = {"smoke","regres"})
    public void deleteBoardPositiveTest() {
        new MyBoardPage(getDriver()).deleteBoard();
        Assert.assertTrue(boardsPage.validatePopUpMessage("Board deleted."));
    }
}
