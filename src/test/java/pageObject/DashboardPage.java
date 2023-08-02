package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    public String headerTextHolder = "//h6[text()='%s']";
    public String linkDashboardLeftNavigation = "//span[text()='%s']";
    public String infoSectionTitle = "//p[text()='%s']";
    public String buttonHelp = "//button[@title=\"Help\"]";

    private WebDriver driver;
//    public DashboardPage(WebDriver driver){
//        this.driver=driver;
//    }
    public SelenideElement getHeader(String headText) {
        return $x(headerTextHolder.replace("%s", headText));
    }
    public SelenideElement getLeftNavigationLink(String linkText){
        return $x(linkDashboardLeftNavigation.replace("%s", linkText));
    }

    public SelenideElement getInfoSectionTitle(String title){
        return $x(infoSectionTitle.replace("%s", title));
    }

    public SelenideElement getHelpButton(){
        return $x(buttonHelp);
    }
}


