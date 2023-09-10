package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReportIssuesTests extends BaseTest{
    private MantisSite mantisSite;
    @Test
    public void createDeleteIssue() throws InterruptedException{
        mantisSite = new MantisSite(driver);
        SoftAssertions softAssert = new SoftAssertions();
        mantisSite.login("admin", "admin20");
        softAssert.assertThat(mantisSite.getMainPage().getUserName()).isEqualTo("admin");
        mantisSite.getMainPage().goToReportIssuePage();
        Thread.sleep(2000);
        mantisSite.getReportIssuePage().requiredFields("Summary on September 10th", "Description on September 10th");
        mantisSite.getReportIssuePage().submit();
        String idi = driver.findElement(By.xpath("//table[@id='buglist']/tbody/tr[1]/td[@class='column-id']/a")).getText();
        Thread.sleep(2000);
        mantisSite.getViewIssuesPage().delete();
//        Assertions.assertNotEquals(idi, driver.findElement(By.xpath("//table[@id='buglist']/tbody/tr[1]/td[@class='column-id']/a")).getText());
        softAssert.assertThat(idi).isNotEqualTo(driver.findElement(By.xpath("//table[@id='buglist']/tbody/tr[1]/td[@class='column-id']/a")).getText());
        softAssert.assertAll();
        Thread.sleep(2000);
//


    }
}
