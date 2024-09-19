package com.cuneiform.Mavenprojectforpoonam;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class AddProduct 
{
WebDriver driver;
WebDriverWait wait;		
	
	@Test(priority=1)
	public void chrome() throws InterruptedException
	{
		System.setProperty("WebDriver.chromedriver","C:\\Users\\Aaditya\\Selenium3\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://dev.poonamcoatings.com");
		driver.manage().window().maximize();		

		//login
		WebElement Username=driver.findElement(By.xpath("//input[@id='email']"));
		Username.sendKeys("admin@poonamcoatings.com");		
		
		WebElement Password=driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys("Super@1234");
		
		WebElement Login=driver.findElement(By.xpath("//button[@type='submit']"));
		Login.click();	
		Thread.sleep(8000);			
	}
		
	@Test(priority=2)
	public void AddProductclick() throws InterruptedException
	{
		WebElement Addproductclick=driver.findElement(By.xpath("//span[normalize-space()='Products']"));
		Addproductclick.click();	
		
		WebElement Addproductclickbutton=driver.findElement(By.xpath("//button[normalize-space()='Add Product']"));
		Addproductclickbutton.click();
		
		//Product Details
		WebElement ProductName=driver.findElement(By.xpath("//input[@id='productName']"));
		ProductName.sendKeys("Test Inventory 9");
		ProductName.click();		
		
		WebElement producttype=driver.findElement(By.xpath("//div[@class='direct fixedHeight'][1]"));
        producttype.click();      
        WebElement Producttypeselect=driver.findElement(By.xpath("//div[normalize-space()='Paint']"));
        Producttypeselect.click();  
        Thread.sleep(3000);
   
        //Product Standard
        WebElement productstandard=driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[2]"));
        productstandard.click();      
        WebElement productstandardselect=driver.findElement(By.xpath("//div[normalize-space()='Non Standard Product']"));
        productstandardselect.click();
        Thread.sleep(2000);     
      
        WebElement ProductCode=driver.findElement(By.xpath("//input[@id='productCode']"));
		ProductCode.sendKeys("79797917");  
		
		WebElement HSNCode=driver.findElement(By.xpath("//input[@id='hsnCode']"));
		HSNCode.sendKeys("32099090");
		
		try
		{
		Thread.sleep(6000);	
		WebElement HSNCode1=driver.findElement(By.xpath("//span[normalize-space()='32099090']"));
      	HSNCode1.click();       
		}
       	catch(Exception e)
		{
			e.printStackTrace();
		}
              
		WebElement Description=driver.findElement(By.xpath("//textarea[@id='description']"));
		Description.sendKeys("This is the test Inventory2");
		
		try
		{
		WebElement Brand=driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[3]"));
		Brand.click();
		Thread.sleep(2000);
		
		WebElement Brand1=driver.findElement(By.xpath("//span[normalize-space()='Sherwinnss']"));
		Brand1.click();	
		Thread.sleep(3000);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		WebElement Category=driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[4]"));
		Category.click();
		WebElement Category1=driver.findElement(By.xpath("//span[normalize-space()='Tinters']"));
		Category1.click();		
		
		WebElement SubCategory1=driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[5]"));
		SubCategory1.click();
		Thread.sleep(2000);
		WebElement SubCategoryselect1=driver.findElement(By.xpath("//span[normalize-space()='ATest1']"));
		SubCategoryselect1.click();
		Thread.sleep(2000);		
		
		WebElement Packsize=driver.findElement(By.xpath("//input[@id='packSize']"));
		Packsize.sendKeys("10");	
		Thread.sleep(2000);   
        
        //Pack Quantity
        WebElement quantity=driver.findElement(By.xpath("//input[@id='packQuantity']"));
        quantity.sendKeys("8.5"); 
        		
		try
		{
		WebElement Color=driver.findElement(By.xpath("//input[@id='color']"));
        Color.sendKeys("Green");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
		Thread.sleep(6000);	
        WebElement Color1=driver.findElement(By.xpath("//div[@class='drop-down-item2 selectedDropBox']"));
        Color1.click();
        //Thread.sleep(5000);
        Thread.onSpinWait();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

		try
		{
		WebElement PaintType=driver.findElement(By.xpath("//input[@id='paintType']"));
		PaintType.sendKeys("Oil_Paint");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
		Thread.sleep(6000);	
        WebElement PaintType1=driver.findElement(By.xpath("//span[normalize-space()='Oil Based']"));
        PaintType1.click();
        //Thread.sleep(5000);
        Thread.onSpinWait();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
		try
		{
		WebElement FinishType=driver.findElement(By.xpath("//input[@id='finish']"));		
		FinishType.sendKeys("Matt");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		try
		{
		Thread.sleep(6000);	
        WebElement FinishType1=driver.findElement(By.xpath("//span[normalize-space()='Matt']"));
        FinishType1.click();
        Thread.onSpinWait();
		}		
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		WebElement UnitPrice=driver.findElement(By.xpath("//input[@id='unitPrice']"));
		UnitPrice.sendKeys("20");		
		WebElement Savebutton=driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		Savebutton.click();		
	}	
}

