package tests_selenide_with_pom;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;
import static org.assertj.core.api.Assertions.assertThat;

public class DropdownPageTests {

    private static DropdownPage dropdownPage;

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        dropdownPage = new DropdownPage();
    }

    @BeforeEach
    public void goToDropdownPage() {
        dropdownPage.goTo();
    }

    @Test
    public void canOpenDropdownPage() {
        assertThat(dropdownPage.getPageTitleText()).isEqualTo("Dropdown List");
    }

    @Test
    public void canSelectOptionOne(){
        dropdownPage.selectOptionsWithValues(1);

        assertThat(dropdownPage.getSelectedDropdownItem().getText()).isEqualTo("Option 1");
    }

    @Test
    public void canSelectOptionTwo(){
        dropdownPage.selectOptionsWithValues(2);

        assertThat(dropdownPage.getSelectedDropdownItem().getText()).isEqualTo("Option 2");
    }
}
