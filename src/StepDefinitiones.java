import com.google.gson.JsonArray;
import dev.failsafe.internal.util.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

public final class StepDefinitiones extends BaseTest{

    private SauceDemoLocators sauceDemoLocators = new SauceDemoLocators();
    private OnlineHtmlEditorLocators onlineHtmlEditorLocators = new OnlineHtmlEditorLocators();
    private DemoGuruLocators demoGuruLocators = new DemoGuruLocators();

    private String originalWindow;
    private String responseBody;
    private JsonArray responseJson;

    private JSONObject Credentials()throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(new FileReader("test/resources/credentials.json"));
        return obj;
    }

    public void GoToPage(String url){
        driver.navigate().to(url);
        originalWindow = driver.getWindowHandle();
    }

    public void IAmOnTheLoginPage(String url){
        GoToPage(url);
        sauceDemoLocators.loginPage.isDisplayed();
    }

    public void ClickOnLoginButton(){
        sauceDemoLocators.loginButton.click();
    }

    public void ValidateTheErrorMessage(){
        sauceDemoLocators.loginErrorMessage.isDisplayed();
    }

    public void LoginWithJsonCredentials() throws IOException, ParseException {
        String username = (String) Credentials().get("username");
        String password = (String) Credentials().get("password");

        sauceDemoLocators.username.sendKeys(username);
        sauceDemoLocators.password.sendKeys(password);
        ClickOnLoginButton();
        sauceDemoLocators.inventoryContainer.isDisplayed();
    }

    public void Login(String username, String password)  {

        sauceDemoLocators.username.sendKeys(username);
        sauceDemoLocators.password.sendKeys(password);
        ClickOnLoginButton();
        sauceDemoLocators.inventoryContainer.isDisplayed();
    }

    public void ScrollToBottomOfThePage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", sauceDemoLocators.footer);
    }

    public void ValidateFooterContains(String string1, String string2){
        String footerText = sauceDemoLocators.footer.getText();
        Assert.isTrue(footerText.contains(string1), String.format("%s is not in the footer",string1));
        Assert.isTrue(footerText.contains(string2), String.format("%s is not in the footer",string2));
    }

    public void FillYourInformations(String firstName, String lasName, String postalCode){
        sauceDemoLocators.firstName.sendKeys(firstName);
        sauceDemoLocators.lastName.sendKeys(lasName);
        sauceDemoLocators.postalCode.sendKeys(postalCode);
    }

    public void OpenChart(){
        sauceDemoLocators.shoppingCart.click();
        sauceDemoLocators.cartContentsContainer.isDisplayed();
    }

    public void TheCeckoutCompletePageDisplayed(){
        sauceDemoLocators.checkoutCompleteContainer.isDisplayed();
    }
    public void ClickOnFinishOnCheckoutPage(){
        sauceDemoLocators.checkoutFinishButton.click();
    }


    public void ValidateThankYouForYourOrderMessage(){
        sauceDemoLocators.checkoutCompleteContainer.getText().equals("Thank you for your order!");
    }

    public void TheCheckoutYouInformationPageDisplayed(){
        sauceDemoLocators.checkoutInfoContainer.isDisplayed();
    }

    public void ClickOnCheckOut(){
        sauceDemoLocators.checkoutButton.click();
    }

    public void TheOverviewPageDisplaye(){
        sauceDemoLocators.checkoutSummaryContainer.isDisplayed();
    }

    public void ClickOnContinueOnCheckoutPage(){
        sauceDemoLocators.checkoutContinueButton.click();
    }

    public void AddItemsToCart(){
        sauceDemoLocators.sauceLabsBackpackAddToCart.click();
        sauceDemoLocators.removeSauceLabsBackpackButton.isDisplayed();
        sauceDemoLocators.sauceLabsFleeceJacketAddToCart.click();
        sauceDemoLocators.removeSauceLabsFleeceJacketButton.isDisplayed();
    }

    public void ValidateChartCounter(String expectedCounterValue){
        Assert.isTrue(expectedCounterValue.equals(sauceDemoLocators.shoppingCart.getText()),
                "The chart counter value is wrong");
    }

    //Case3------------------------------------------------------

    public void TypeTextIntoEditor(String textToFill){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(onlineHtmlEditorLocators.iframe));
        onlineHtmlEditorLocators.editor.sendKeys(textToFill);
    }

    public void ValidateRichText(String boldText){
        Assert.isTrue(onlineHtmlEditorLocators.editor.getText().contains(boldText), "Rich text is wrong");
    }

    public void BoldTest() {
        var writtenText = onlineHtmlEditorLocators.editor.getText().split(" ");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.HOME);
        actions.keyDown(Keys.SHIFT);
        for (int i = 0; i < writtenText[0].length(); i++) {
            actions.sendKeys(Keys.ARROW_RIGHT);
        }
        actions.keyUp(Keys.SHIFT);
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("b");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.HOME);
        for (int i = 0; i < writtenText[0].length() + 1; i++) {
            actions2.sendKeys(Keys.ARROW_RIGHT);
        }
        actions2.keyDown(Keys.SHIFT);
        for (int i = 0; i < writtenText[1].length(); i++){
            actions2.sendKeys(Keys.ARROW_RIGHT);
        }
        actions2.keyUp(Keys.SHIFT);
        actions2.keyDown(Keys.CONTROL);
        actions2.sendKeys("u");
        actions2.build().perform();
    }

    public void TextEditorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(onlineHtmlEditorLocators.editor));
    }

    //Case4------------------------------------------------------

    public void ValidateAndClickImageInIframe(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(demoGuruLocators.bottomIframe));
        demoGuruLocators.image.click();
    }

    public void WindowHandle(WebDriver driver){
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void ValidateNewPageInNewWindow(String title) {
        WindowHandle(driver);
        var newWindowTitle = driver.getTitle();
        Assert.isTrue(newWindowTitle.contains(title), "Wrong window title");
    }

    public void CloseNewWindowAndNavigateBack() {
        String originalWindow = driver.getWindowHandle();
        driver.switchTo().window(originalWindow);
        driver.close();
    }

    public void ClickOnSeleniumLink() {
        driver.switchTo().window(originalWindow);
        driver.switchTo().parentFrame();

        var tdLinks = driver.findElements(By.cssSelector("tbody td a"));
        tdLinks.stream().filter(e -> e.getText().contains("Selenium")).findFirst().orElseThrow().click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(demoGuruLocators.iframe1));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(demoGuruLocators.iframe2));
        wait.until(ExpectedConditions.elementToBeClickable(demoGuruLocators.dismissButton));
        demoGuruLocators.dismissButton.click();
    }

    public void AcceptPrivacyPopup() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(demoGuruLocators.gdprIframe));
        wait.until(ExpectedConditions.elementToBeClickable(demoGuruLocators.saveButton));
        demoGuruLocators.saveButton.click();
    }

    public void AcceptConsentInfoPopup() throws InterruptedException {
        Thread.sleep(1000);
        var buttons = driver.findElements(By.cssSelector("body button"));
        var aggreButton = buttons.stream().filter(e -> e.getText().contains("AGREE")).findFirst().orElseThrow();
        aggreButton.click();
    }

    public void ValidateJoinNowButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", demoGuruLocators.joinButton);
        wait.until(ExpectedConditions.visibilityOf(demoGuruLocators.joinButton));
    }

    //Case5------------------------------------------------------

    public void CallApi(String uri) {
        RestAssured.baseURI = uri;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        responseBody = response.getBody().asString();
    }

    public void ParseResponseToJson(){
        JsonParser parser = new JsonParser();
        responseJson = parser.parse(responseBody).getAsJsonArray();
    }

    public void LogNamesAndEmails(){
        for (int i = 0; i < responseJson.size(); i++){
            System.out.println(responseJson.get(i).getAsJsonObject().get("name"));
            System.out.println(responseJson.get(i).getAsJsonObject().get("email") + "\n");
        }
    }

    public void VerifyFirstEmailContainsAt(){
        Assert.isTrue(responseJson.get(1).getAsJsonObject().get("email").getAsString().contains("@"),
                "First email not contains '@'");
    }
}
