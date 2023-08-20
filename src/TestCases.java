import com.google.gson.JsonArray;
import org.apache.http.impl.client.CloseableHttpClient;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import java.io.*;

public class TestCases extends BaseTest{

    public static CloseableHttpClient client;
    @Test
    public void Case1() throws IOException, ParseException {
        String SAUCE_DEMO_URL = "https://www.saucedemo.com/inventory.html";
        String CHART_COUNTER = "2";
        String FIRST_NAME = "Winch";
        String LAST_NAME = "Ester";
        String POSTAL_CODE = "1234";

        StepDefinitiones stepDef = new StepDefinitiones();

        stepDef.IAmOnTheLoginPage(SAUCE_DEMO_URL);
        stepDef.LoginWithJsonCredentials();
        stepDef.AddItemsToCart();
        stepDef.ValidateChartCounter(CHART_COUNTER);
        stepDef.OpenChart();
        stepDef.ClickOnCheckOut();
        stepDef.TheCheckoutYouInformationPageDisplayed();
        stepDef.FillYourInformations(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        stepDef.ClickOnContinueOnCheckoutPage();
        stepDef.TheOverviewPageDisplaye();
        stepDef.ClickOnFinishOnCheckoutPage();
        stepDef.TheCeckoutCompletePageDisplayed();
        stepDef.ValidateThankYouForYourOrderMessage();
    }

    @Test
    public void Case2() {
        String SAUCE_DEMO_URL = "https://www.saucedemo.com/inventory.html";
        String USERNAME = "standard_user";
        String PASSWORD = "secret_sauce";
        String TWO_O_TWENTY_THREE = "2023";
        String TERMS_OF_SERVICE = "Terms of Service";

        StepDefinitiones stepDef = new StepDefinitiones();

        stepDef.GoToPage(SAUCE_DEMO_URL);
        stepDef.ClickOnLoginButton();
        stepDef.ValidateTheErrorMessage();
        stepDef.Login(USERNAME, PASSWORD);
        stepDef.ScrollToBottomOfThePage();
        stepDef.ValidateFooterContains(TWO_O_TWENTY_THREE,TERMS_OF_SERVICE);
    }

    @Test
    public void Case3() {
        String ONLINE_HTML_EDITOR = "https://onlinehtmleditor.dev";
        String AUTOMATION_TEST_EXAMPLE = "Automation Test Example";
        String BOLD_TEXT = "Automation";

        StepDefinitiones stepDef = new StepDefinitiones();

        stepDef.GoToPage(ONLINE_HTML_EDITOR);
        stepDef.TextEditorDisplayed();
        stepDef.TypeTextIntoEditor(AUTOMATION_TEST_EXAMPLE);
        stepDef.BoldTest();
        stepDef.ValidateRichText(BOLD_TEXT);
    }

    @Test
    public void Case4() throws InterruptedException {
        String DEMO_GURU_URL = "http://demo.guru99.com/test/guru99home";
        String PAGE_TITLE = "Selenium Live Project: FREE Real Time Project for Practice";

        StepDefinitiones stepDef = new StepDefinitiones();

        stepDef.GoToPage(DEMO_GURU_URL);
        stepDef.AcceptPrivacyPopup();
        stepDef.ValidateAndClickImageInIframe();
        stepDef.ValidateNewPageInNewWindow(PAGE_TITLE);
        stepDef.CloseNewWindowAndNavigateBack();
        stepDef.ClickOnSeleniumLink();
        stepDef.AcceptConsentInfoPopup();
        stepDef.ValidateJoinNowButton();
    }

    @Test
    public void Case5() throws IOException, ParseException {
        String API_URL = "https://jsonplaceholder.typicode.com";
        String ENDPOINT = "/users";
        JsonArray responseJson;

        StepDefinitiones stepDef = new StepDefinitiones();

        stepDef.CallApi(API_URL+ENDPOINT);
        stepDef.ParseResponseToJson();
        stepDef.LogNamesAndEmails();
        stepDef.VerifyFirstEmailContainsAt();
    }
}