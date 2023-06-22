package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropPage {

    private final By dragAndDropPageLink = By.linkText("Drag and Drop");

    private final By boxAName = By.cssSelector("#column-a > header");

    public void goTo() {
        open("/");
        $(dragAndDropPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }

    public void dragAndDropBoxAToBoxB() {
        $("#column-a").dragAndDropTo("#column-b");
    }

    public boolean boxesReplaced() {
        return $(boxAName).getText().equals("B");
    }
}
