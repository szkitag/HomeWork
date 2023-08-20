import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineHtmlEditorLocators extends BaseTest{
    public OnlineHtmlEditorLocators() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "section iframe") WebElement iframe;
    @FindBy(css = "html body") WebElement editor;
}
