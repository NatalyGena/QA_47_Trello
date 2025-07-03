package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyBoardPage extends BasePage{
    public MyBoardPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver
                , 10), this);
    }
    @FindBy(xpath = "//h1[@class='HKTtBLwDyErB_o']")
    WebElement boardName;
   @FindBy(xpath = "//button[@aria-label='Show menu']")
   WebElement btnMenuDots;
   @FindBy(xpath = "//div[text()='Close board']")
   //@FindBy(xpath = "//span[@aria-label='Close board']/..") //если русский язык
   WebElement btnCloseBoard;


   public  void deleteBoard(){
       clickWait(btnMenuDots,3);
       clickWait(btnCloseBoard,3);
   }
    public boolean validateBoardName( String text, int time) {
        return validateTextInElementWait(boardName,text,time);
    }
}
