package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormAuthenticationPage {
    private final By formAuthenticationLink = By.linkText("Form Authentication");
    private final By formAuthenticationUsernameField = By.cssSelector("#username");
    private final By formAuthenticationPasswordField = By.cssSelector("#password");
    private final By formAuthenticationSubmitButton = By.cssSelector("button");
    private final By formAuthenticationNotification = By.cssSelector("#flash");

    public void goTo() {
        open("/");
        $(formAuthenticationLink).click();
    }

    public String getPageTitleText() {
        return $("h2").getText();
    }

    public void loginWithCredentials(String validUsername, String validPassword) {
        $(formAuthenticationUsernameField).setValue(validUsername);
        $(formAuthenticationPasswordField).setValue(validPassword);

        $(formAuthenticationSubmitButton).click();
    }

    public SelenideElement getNotification() {
        return $(formAuthenticationNotification);
    }
}
