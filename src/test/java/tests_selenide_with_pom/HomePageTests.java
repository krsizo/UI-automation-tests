package tests_selenide_with_pom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTests {

    private static HomePage homePage;

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        homePage = new HomePage();
    }

    @BeforeEach
    public void goToHomePage() {
        homePage.goTo();
    }

    @Test
    public void canOpenHomePage() {
        assertThat(homePage.getPageTitleText()).isEqualTo("Welcome to the-internet");
    }
}
