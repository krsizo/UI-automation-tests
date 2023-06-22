package tests_selenide_with_pom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DragAndDropPage;
import static org.assertj.core.api.Assertions.assertThat;

public class DragAndDropPageTests {

    private static DragAndDropPage dragAndDropPage;

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 7000;

        dragAndDropPage = new DragAndDropPage();
    }

    @BeforeEach
    public void goToDragAndDropPage() {
        dragAndDropPage.goTo();
    }

    @Test
    public void canOpenDragAndDropPage() {
        assertThat(dragAndDropPage.getPageTitleText()).isEqualTo("Drag and Drop");
    }

    @Test
    public void shouldReplaceEachOtherWhenDragAndDrop() {
        dragAndDropPage.dragAndDropBoxAToBoxB();
        assertThat(dragAndDropPage.boxesReplaced()).isTrue();
    }
}
