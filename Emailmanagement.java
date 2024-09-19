package com.cuneiform.Mavenprojectforpoonam;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Emailmanagement
{
    WebDriver driver;

    @Test(priority = 1)
    public void chrome() throws InterruptedException 
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.poonamcoatings.com");

        // login
        WebElement Username = driver.findElement(By.id("email"));
        Username.sendKeys("admin@poonamcoatings.com");
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Super@1234");
        WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
        Login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'User logged in successfully.')]"))).getText();
        String expectedMessage = "User logged in successfully.";
        Assert.assertEquals(actualmsg, expectedMessage, "Login message did not match.");
    }

    @Test(priority = 2)
    public void Addemail() throws InterruptedException 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on Setting
        WebElement Settingclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
        Settingclick.click();

        // Click on Email Management
        WebElement EmailManagementclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Email Management')]")));
        EmailManagementclick.click();

        // Declare arrays for Titles, Subjects, and Descriptions
        String[] ETitles1 = {"Title331464", "Title233151", "Titl3e13422", "Title333722", "Title532432"};
        String[] ESubject = {"Subject3121", "Subjec3t122", "Subject1233", "Subj3ect124", "Subje3ct125"};
        String[] EDesc = {"Descriptio3n128", "Descri3ption432", "Desc3ription374", "Desc3ription144", "Des3cription455"};

        // Loop through each email
        for (int i = 0; i < ETitles1.length; i++) 
        {
            // Re-locate Add new email button for each iteration
            WebElement EmailManagementadd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-primary header-btn']")));
            EmailManagementadd.click();

            // Re-locate and input Title
            WebElement Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
            Title.clear();  // Clear field before sending new input
            Title.sendKeys(ETitles1[i]);

            // Re-locate and input Subject
            WebElement Subject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject")));
            Subject.clear();  // Clear field before sending new input
            Subject.sendKeys(ESubject[i]);

            // Re-locate and input Description
            WebElement Description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ql-editor ql-blank']")));
            Description.sendKeys(EDesc[i]);

            // Re-locate and click Submit
            WebElement Submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            Submit.click();
            
            // Wait for and verify success message
            String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Email template added successfully.')]"))).getText();
            String expectedMessage = "Email template added successfully.";
            Assert.assertEquals(actualMessage, expectedMessage, "Email submission message did not match.");

            //Add a small wait to handle page reload, if necessary
            Thread.sleep(1000);           
        }
        
        System.out.println("Email management successfully run");
    }
    
}
//Perfect Run 17.09.24