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

public class Departentadd
{
    WebDriver driver;
    WebDriverWait wait;

    @Test(priority = 1)
    public void chrome() throws InterruptedException 
    {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Navigate to the website and maximize the window
        driver.get("https://dev.poonamcoatings.com");
        driver.manage().window().maximize();

        // Login to the application
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        username.sendKeys("admin@poonamcoatings.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Super@1234");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        // Waiting for the login process to complete
        Thread.sleep(8000);
    }

    @Test(priority = 2)
    public void addDepartment() throws InterruptedException 
    {
        // Click on Settings
        WebElement settingsClick1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
        settingsClick1.click();
        Thread.sleep(3000);

        // Click on Department Management
        WebElement departmentClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Department Management')]")));   
        departmentClick.click();
        Thread.sleep(3000);
        
        // Define department names and descriptions
        String[] departNames = { "Contdentdd", "Marketdingdd", "Accoundtdd", "Sadlesdd", "Retaidlerdd" };
        String[] descriptions = { "This is a content writer post", "This is a post for marketing", "This is an accounting post", "This is a sales department", "This is a retailer department" };

        for (int i = 0; i < departNames.length; i++) 
        {
            try
            {
                // Check if the department already exists
                if (!driver.findElements(By.xpath("//td[text()='" + departNames[i] + "']")).isEmpty()) 
                {
                    System.out.println("Duplicate department found: " + departNames[i]);
                    continue; // Skip duplicate department
                }

                // Click on "Add" button to add a new department
                WebElement addDepartmentClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']")));
                addDepartmentClick.click();  
                
                Reporter.log("Add button clicked successfully");

                // Enter department name and description
                WebElement departmentNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
                departmentNameField.sendKeys(departNames[i]);

                WebElement descriptionElement = driver.findElement(By.id("description"));
                descriptionElement.sendKeys(descriptions[i]);

                // Submit the form
                WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
                submit.click();
                
       
                Thread.sleep(2000);
            } 
            
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

    // Uncomment if you want to close the browser after tests
//    @AfterTest
//    public void tearDown() 
//    {
//        if (driver != null) 
//        {
//            driver.quit();
//        }
//    }
}


//Perfect run 20.09.27