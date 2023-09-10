package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> issues;

    @FindBy(xpath = "//table[@id='buglist']/tbody/tr[1]/td[@class='column-id']/a")
    private WebElement lastIssue;
    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@value='Delete Issues']")
    private WebElement deleteIssueButton;

    public ViewIssuesPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }
    public int countIssues() {
        return issues.size();
    }
    public void delete() {
        lastIssue.click();
        deleteButton.click();
        deleteIssueButton.click();
    }
}
