package mantis.pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#summary")
    private WebElement summaryField;

    @FindBy(css = "#description")
    private WebElement descriptionField;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofMillis(500));
        PageFactory.initElements(driver, this);
    }

    public void typeSummary(String message) {
        summaryField.sendKeys(message);
    }
    public void typeDescription(String message){
        descriptionField.sendKeys(message);
    }

    public void requiredFields(String messageSummary, String messageDescription) {
        summaryField.sendKeys(messageSummary);
        descriptionField.sendKeys(messageDescription);
    }
    public void submit() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#bug_action")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='buglist']/tbody/tr[1]/td[@class='column-id']/a")));

    }


}
