package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CheckboxesPage {

    private final By checkboxesPageLink = By.linkText("Checkboxes");
    private final By checkboxes = By.xpath("//input[@type='checkbox']");

    public void goTo() {
        open("/");
        $(checkboxesPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }

    public void selectAllCheckboxes() {
        List<SelenideElement> checkboxes = getAllCheckboxes();
        for (SelenideElement checkbox: checkboxes) {
            checkbox.setSelected(true);
        }
    }

    public void unselectAllCheckboxes() {
        List<SelenideElement> checkboxes = getAllCheckboxes();
        for (SelenideElement checkbox: checkboxes) {
            checkbox.setSelected(false);
        }
    }

    public List<SelenideElement> getAllCheckboxes() {
        return $$(checkboxes);
    }
}
