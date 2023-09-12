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
        mantisSite.getReportIssuePage().createIssueWithOnlyRequiredFields("Summary on September 10th", "Description on September 10th");
        mantisSite.getReportIssuePage().submit();
        String id = mantisSite.getViewIssuesPage().getIssueNumberText();
        Thread.sleep(2000);
        mantisSite.getViewIssuesPage().deleteLastIssue();
        softAssert.assertThat(id).isNotEqualTo(mantisSite.getViewIssuesPage().getIssueNumberText());
        softAssert.assertAll();
        Thread.sleep(2000);


    }
}
