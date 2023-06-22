package tests_selenide_only;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormAuthenticationPageTests {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void goToFromAuthenticationPage() {
        open("/");
        $(By.linkText("Form Authentication")).click();
    }

    @Test
    public void canOpenLoginPage() {
        $("h2").shouldHave(text("Login Page"));
    }

    @Test
    public void shouldLoginToSecuredAreaWithValidCredentials(){
        String validUsername = "tomsmith";
        String validPassword = "SuperSecretPassword!";

        $("#username").setValue(validUsername);
        $("#password").setValue(validPassword);
        $("button").click();

        $("#flash").shouldHave(text("You logged into a secure area!"));
    }

    @Test
    public void shouldNotLoginToSecuredAreaWithInValidCredentials(){
        String inValidUsername = "invalidusername";
        String inValidPassword = "invalidpassword123";

        $("#username").setValue(inValidUsername);
        $("#password").setValue(inValidPassword);
        $("button").click();

        $("#flash").shouldHave(text("Your username is invalid!"));
    }
}
