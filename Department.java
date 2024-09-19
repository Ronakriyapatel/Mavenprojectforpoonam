package com.cuneiform.Mavenprojectforpoonam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.time.Duration;

public class Department<JavascriptExecutor> 
{
    WebDriver driver;
    WebDriverWait wait;

    @Test(priority = 1)
    public void chrome() throws InterruptedException 
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://dev.poonamcoatings.com");
        driver.manage().window().maximize();

        // Login
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        username.sendKeys("admin@poonamcoatings.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Super@1234");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        // Wait for login to complete (adjust time as needed based on page loading)
        Thread.sleep(8000);
    }

    @Test(priority = 2)
    public void addDepartment() throws InterruptedException 
    {
        // Click on Settings
        WebElement settingsClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
        settingsClick.click();

        // Click on Department Management
        WebElement departmentClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='app-name active' and text()='Department Management']")));
        departmentClick.click();

        // Define department names and descriptions
        String[] departNames = { "Content", "Marketing", "Account", "Sales", "Retailer" };
        String[] descriptions = { "This is a content writer post", "This is a post for marketing", "This is an accounting post", "This is a sales department", "This is a retailer department" };

        for (int i = 0; i < departNames.length; i++) 
        {
            try
            {
                // Check if department already exists
                if (!driver.findElements(By.xpath("//td[text()='" + departNames[i] + "']")).isEmpty()) 
                {
                    System.out.println("Duplicate department found: " + departNames[i]);
                    continue; // Skip the duplicate department
                }

//                // Add department
                wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement addDepartmentClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']")));
                addDepartmentClick.click();  
                
                Reporter.log("Add click successfull run");
               
                WebElement departmentNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
                departmentNameField.sendKeys(departNames[i]);

                WebElement descriptionElement = driver.findElement(By.id("description"));
                descriptionElement.sendKeys(descriptions[i]);

                WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
                submit.click();

                // Wait for the department to be added before checking the next one
                Thread.sleep(2000);

            } 
            
            catch (Exception e)
            {
                e.printStackTrace();
            }}
        }
    

    @AfterTest
    public void tearDown() 
    {
        if (driver != null) 
        {
            driver.quit();
        }
    }
}
