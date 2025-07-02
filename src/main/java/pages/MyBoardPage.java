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


    public boolean validateBoardName( String text, int time) {
        return validateTextInElementWait(boardName,text,time);
    }
}
