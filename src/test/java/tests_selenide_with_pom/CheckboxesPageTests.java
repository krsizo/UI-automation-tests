package tests_selenide_with_pom;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CheckboxesPage;
import pages.HoversPage;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxesPageTests {

    private static CheckboxesPage checkboxesPage;

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 7000;

        checkboxesPage = new CheckboxesPage();
    }

    @BeforeEach
    public void goTo() {
        checkboxesPage.goTo();
    }

    @Test
    public void canOpenHoversPage() {
        assertThat(checkboxesPage.getPageTitleText()).isEqualTo("Checkboxes");
    }

    @Test
    public void canSelectAllCheckboxes() {
        checkboxesPage.selectAllCheckboxes();

        List<SelenideElement> checkboxes = checkboxesPage.getAllCheckboxes();
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(checked);
        }
    }

    @Test
    public void canUnselectAllCheckboxes() {
        checkboxesPage.unselectAllCheckboxes();

        List<SelenideElement> checkboxes = checkboxesPage.getAllCheckboxes();
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldNotBe(checked);
        }
    }
}
