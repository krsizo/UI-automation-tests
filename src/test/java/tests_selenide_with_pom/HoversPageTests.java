package tests_selenide_with_pom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HoversPage;
import static org.assertj.core.api.Assertions.assertThat;

public class HoversPageTests {

    private static HoversPage hoversPage;

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 7000;

        hoversPage = new HoversPage();
    }

    @BeforeEach
    public void goTo() {
        hoversPage.goTo();
    }

    @Test
    public void canOpenHoversPage() {
        assertThat(hoversPage.getPageTitleText()).isEqualTo("Hovers");
    }

    @Test
    public void shouldHaveNameWhenHoveringOverFirstPicture() {
        assertThat(hoversPage.getNameWhenHover(0)).isNotEmpty();
    }

    @Test
    public void shouldHaveNameWhenHoveringOverSecondPicture() {
        assertThat(hoversPage.getNameWhenHover(1)).isNotEmpty();
    }

    @Test
    public void shouldHaveNameWhenHoveringOverThirdPicture() {
        assertThat(hoversPage.getNameWhenHover(2)).isNotEmpty();
    }

    @Test
    public void shouldHaveProfileLinkWhenHoveringOverFirstPicture() {
        assertThat(hoversPage.getProfileLinkWhenHover(0)).isNotEmpty();
    }

    @Test
    public void shouldHaveProfileLinkWhenHoveringOverSecondPicture() {
        assertThat(hoversPage.getProfileLinkWhenHover(1)).isNotEmpty();
    }

    @Test
    public void shouldHaveProfileLinkWhenHoveringOverThirdPicture() {
        assertThat(hoversPage.getProfileLinkWhenHover(2)).isNotEmpty();
    }
}
