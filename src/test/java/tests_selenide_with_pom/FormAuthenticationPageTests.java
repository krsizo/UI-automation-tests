package tests_selenide_with_pom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormAuthenticationPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FormAuthenticationPageTests {
    private static FormAuthenticationPage formAuthenticationPage;

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        formAuthenticationPage = new FormAuthenticationPage();
    }

    @BeforeEach
    public void goToFormAuthenticationPage(){
        formAuthenticationPage.goTo();
    }

    @Test
    public void canOpenFormAuthenticationPage(){
        assertThat(formAuthenticationPage.getPageTitleText()).isEqualTo("Login Page");
    }

    @Test
    public void shouldLoginToSecuredAreaWithValidCredentials(){
        String validUsername = "tomsmith";
        String validPassword = "SuperSecretPassword!";

        formAuthenticationPage.loginWithCredentials(validUsername, validPassword);

        assertThat(formAuthenticationPage.getNotification().getText()).contains("You logged into a secure area!");
    }

    @Test
    public void shouldNotLoginToSecuredAreaWithValidCredentials(){
        String inValidUsername = "invalidusername";
        String inValidPassword = "invalidpassword123";

        formAuthenticationPage.loginWithCredentials(inValidUsername, inValidPassword);

        assertThat(formAuthenticationPage.getNotification().getText()).contains("Your username is invalid!");
    }
}
