package com.cuneiform.Mavenprojectforpoonam;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserManagement
{

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() throws InterruptedException 
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://dev.poonamcoatings.com");
        driver.manage().window().maximize();

        // Login
        WebElement Username = driver.findElement(By.xpath("//input[@id='email']"));
        Username.sendKeys("admin@poonamcoatings.com");

        WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
        Password.sendKeys("Super@1234");

        WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
        Login.click();
        Thread.sleep(8000); // Replace with WebDriverWait if required
        
        Reporter.log("Chrome open successfully");
    }

    @Test
    public void useradd1() throws InterruptedException 
    {
        String[] firstname = {"Aasdseedasftesh", "Aaeesh", "Eveeol"};
        String[] lastname = {"tofhieet", "tyaeesh", "tnaveeat"};
        String[] emailid = {"dafddaseejt@poonamcoatings.com", "yaeeshjdfgeaffo@poonamcoatings.com", "Kfedeefvaldg@poonamcoatings.com"};
        String[] phone = {"8112823752", "8514511242", "8153128782"};
        String[] gender = {"Female", "Male", "Female"};
        String[] dob = {"01-12-1970", "01-01-1962", "01-03-1982"};
        String[] role = {"Admin", "Admin", "Admin"};
        String[] department = {"Administration", "Administration", "Administration"};

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Navigate to User Management page
        WebElement SettingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
        SettingClick.click();
        Thread.sleep(2000);

        WebElement UserManagementClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'User Management')]")));
        UserManagementClick.click();
        Thread.sleep(2000);

        for (int i = 0; i < firstname.length; i++) 
        {
            // Click Add User button
            WebElement UserManagementAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-primary header-btn']")));
            UserManagementAdd.click();
            
            // Fill in user details
            WebElement FirstName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='first_name']")));
            FirstName.clear();
            FirstName.sendKeys(firstname[i]);

            WebElement LastName = driver.findElement(By.xpath("//input[@id='last_name']"));
            LastName.clear();
            LastName.sendKeys(lastname[i]);

            WebElement EmailId = driver.findElement(By.xpath("//input[@id='email']"));
            EmailId.clear();
            EmailId.sendKeys(emailid[i]);

            WebElement PhoneNumber = driver.findElement(By.xpath("//input[@id='phone_no']"));
            PhoneNumber.clear();
            PhoneNumber.sendKeys(phone[i]);

            // Gender selection
            WebElement Gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form-group form']/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]")));
            Gender.click();
            WebElement GenderSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='" + gender[i] + "']")));
            GenderSelect.click();

            // Date of Birth
            WebElement dobInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dob']")));
            dobInput.sendKeys(dob[i]);
            Thread.sleep(3000);

            // Role Selection
            WebElement roleDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[2]")));
            roleDropdown.click();
            WebElement roleSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + role[i] + "']")));
            roleSelect.click();
            Thread.sleep(2000);

            // Department Selection
            WebElement departmentDropdown = driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[3]"));
            departmentDropdown.click();
            WebElement departmentSelect = driver.findElement(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + department[i] + "']"));
            departmentSelect.click();
            Thread.sleep(2000);

            // Add Privileges
            WebElement Privileges = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add Privileges']")));
            Privileges.click();

            WebElement PrivilegesRead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[2]/input[1]")));
            PrivilegesRead.click();
            WebElement PrivilegesWrite = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]"));
            PrivilegesWrite.click();
            WebElement PrivilegesDelete = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]"));
            PrivilegesDelete.click();

            WebElement Submitpriv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='privileges-submit']//button[contains(text(),'Submit')]")));
            Submitpriv.click();

            // Submit user form
            WebElement MainSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
            MainSubmit.click();

            // Log success
            Reporter.log("User added successfully");            
            // Wait for the page to reload or navigate
            Thread.sleep(5000); // Adjust the delay if needed to ensure page reload
        }
    }

    @AfterTest
    public void close()
    {
        driver.quit();
        Reporter.log("Chrome close successfully");
    }
}

//Perfect Run 17.09.24
