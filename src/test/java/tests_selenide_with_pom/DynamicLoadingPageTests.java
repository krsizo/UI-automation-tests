package tests_selenide_with_pom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DynamicLoadingPage;

import static org.assertj.core.api.Assertions.*;

public class DynamicLoadingPageTests {

    private static DynamicLoadingPage dynamicLoadingPage;

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 7000;

        dynamicLoadingPage = new DynamicLoadingPage();
    }

    @BeforeEach
    public void goToDynamicLoadingPage() {
        dynamicLoadingPage.goTo();
    }

    @Test
    public void canOpenDynamicLoadingPage() {
        assertThat(dynamicLoadingPage.getPageTitleText()).isEqualTo("Dynamically Loaded Page Elements");
    }

    @Test
    public void shouldSeeHelloWorldAfterLoadingExampleOne() {
        dynamicLoadingPage.openExampleOneLink();
        dynamicLoadingPage.pressStart();

        assertThat(dynamicLoadingPage.getGreetingText()).isEqualTo("Hello World!");
    }

    @Test
    public void ShouldSeeHelloWorldAfterLoadingExampleTwo(){
        dynamicLoadingPage.openExampleTwoLink();
        dynamicLoadingPage.pressStart();

        assertThat(dynamicLoadingPage.getGreetingText()).isEqualTo("Hello World!");
    }
}
