package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HoversPage {

    private final By hoversPageLink = By.linkText("Hovers");
    private final By picture = By.cssSelector(".figure");
    private final By userName = By.xpath("//*[@class='figcaption']/h5");
    private final By profileLink = By.xpath("//*[@class='figcaption']/a");

    public void goTo() {
        open("/");
        $(hoversPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }

    public String getNameWhenHover(int index) {
        $$(picture).get(index).hover();
        String[] nameSplit = $(userName).shouldBe(visible).getText().split(":");
        return nameSplit[1];
    }

    public String getProfileLinkWhenHover(int index) {
        $$(picture).get(index).hover();
        return $(profileLink).shouldBe(visible).attr("href");
    }
}
