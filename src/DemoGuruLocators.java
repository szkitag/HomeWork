import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DemoGuruLocators extends BaseTest{
    public DemoGuruLocators(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "save") WebElement saveButton;
    @FindBy(id = "gdpr-consent-notice") WebElement gdprIframe;
    @FindBy(id = "dismiss-button") WebElement dismissButton;
    @FindBy(id = "google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0") WebElement iframe1;
    @FindBy(id = "a077aa5e") WebElement bottomIframe;
    @FindBy(tagName = "img") WebElement image;
    @FindBy(id = "ad_iframe") WebElement iframe2;
    @FindBy(css = ".buttonContainer") WebElement joinButton;
}
