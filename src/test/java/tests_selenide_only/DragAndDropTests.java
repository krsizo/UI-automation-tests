package tests_selenide_only;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTests {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 7000;
    }

    @BeforeEach
    public void goToDragAndDropPage() {
        open("/");
        $(By.linkText("Drag and Drop")).click();
    }

    @Test
    public void canOpenDragAndDropPage() {
        $("h3").shouldHave(text("Drag and Drop"));
    }

    @Test
    public void shouldReplaceEachOtherWhenDragAndDrop() {
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a > header").shouldHave(text("B"));
    }
}
