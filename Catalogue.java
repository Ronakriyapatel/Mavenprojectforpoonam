package com.cuneiform.Mavenprojectforpoonam;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Catalogue
	{
				
	WebDriver driver;
		
	@Test(priority=1)
	
		public void chrome() throws InterruptedException
		{
		
			WebDriverManager.chromedriver().setup();
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
			Reporter.log("Chrome open successfull");
		}
	
		@Test(priority=2)
		public void settingpan() throws InterruptedException
		{
			
			//Setting 		
			WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));		
			Settings.click();	
			Thread.sleep(2000);	
					
			//ProductCatalogue
			WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[12]/div[6]"));
			ProductCatalogue.click();	
			Thread.sleep(2000);	
			
			Reporter.log("Setting pan clicked");
		}

		@Test(priority=3)
		public void Brand() throws InterruptedException
		{		
		
			
			//AddBrand..................................................................
			
			//Brand Click		
			WebElement BrandClick=driver.findElement(By.xpath("//button[@class='product-cat-btn active']"));
			BrandClick.click();	
			Thread.sleep(2000);				
			
			//AddBrand		
			WebElement AddBrand=driver.findElement(By.xpath("//button[@class='btn-primary']"));
			AddBrand.click();	
			Thread.sleep(2000);	
			
			WebElement BrandName=driver.findElement(By.xpath("//input[@id='name']"));
			BrandName.sendKeys("Sherwinnss");	
			Thread.sleep(2000);	
			
			//Submit button work
			WebElement SubmitBrand=driver.findElement(By.xpath("//button[@type='submit']"));
			SubmitBrand.click();
			
			Reporter.log("Add Brand successfully");
			
			
			//Edit brand.....................................................................		
			//AddBrand		
			WebElement EditBrand=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/button[1]/span[1]"));
			EditBrand.click();	
			Thread.sleep(2000);	
						
			WebElement EditBrandName=driver.findElement(By.xpath("//input[@id='name']"));
			EditBrandName.sendKeys(Keys.CONTROL,"A",Keys.DELETE);
			EditBrandName.sendKeys("Sherwin William");	
			Thread.sleep(2000);	
						
			//Submit button work
			WebElement SubmitEditBrand=driver.findElement(By.xpath("//button[@type='submit']"));
			SubmitEditBrand.click();
			
			Reporter.log("Edit Brand successfully");
			
			//Perfect code run 17.09.24
		
		}
		@Test(priority=4)
		public void Category() throws InterruptedException
		{		
					
			// Add category............................................................................
			//Category Click		
			WebElement CategoryClick=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/button[2]"));
			CategoryClick.click();	
			Thread.sleep(2000);				
			
			//AddProduct Category		
			WebElement AddProductCategory=driver.findElement(By.xpath("//button[@class='btn-primary']"));
			AddProductCategory.click();	
			Thread.sleep(2000);					
			
			//Brand		
			WebElement BrandClick=driver.findElement(By.xpath("//div[@class='direct fixedHeight']"));
			BrandClick.click();	
			Thread.sleep(2000);	
			
			WebElement BrandSelect=driver.findElement(By.xpath("//span[normalize-space()='Sherwin Williams']"));
			BrandSelect.click();	
			Thread.sleep(2000);
			
			//Margin
			WebElement Margin=driver.findElement(By.xpath("//input[@id='margin']"));
			Margin.sendKeys("20");	
			Thread.sleep(2000);
			
			
			//Category Name		
			WebElement CategoryName=driver.findElement(By.xpath("//input[@id='category']"));
			CategoryName.sendKeys("AATest01");	
			Thread.sleep(2000);		
			
			//Submit button work
			WebElement SubmitAddcategory=driver.findElement(By.xpath("//button[@type='submit']"));
			SubmitAddcategory.click();
			
			Reporter.log("Add Category successfully");
			
			
			//Edit category...............................................................................
			
			//Margin
			WebElement EditMargin=driver.findElement(By.xpath("//input[@id='margin']"));
			EditMargin.sendKeys("10");	
			Thread.sleep(2000);
			
			//Category Name		
			WebElement EditCategoryName=driver.findElement(By.xpath("//input[@id='category']"));
			EditCategoryName.sendKeys("AATest02");	
			Thread.sleep(2000);		
			
			//Submit button work
			WebElement SubmitEditCategory=driver.findElement(By.xpath("//button[@type='submit']"));
			SubmitEditCategory.click();
			
			Reporter.log("Edit Category successfully");
			
			//Perfect code run on 17.09.24		
		}
		
		@Test(priority=5)
		public void SubCategory() throws InterruptedException
		{		
			
			//Add SubCategory
				
			//AddclickSubCategory		
			WebElement AddSubCategory=driver.findElement(By.xpath("//button[normalize-space()='Sub Categories']"));
			AddSubCategory.click();	
			Thread.sleep(2000);				
			
			//AddSubCategory		
			WebElement AddClickSubCategory=driver.findElement(By.xpath("//button[normalize-space()='ADD SUB CATEGORY']"));
			AddClickSubCategory.click();	
			Thread.sleep(2000);				
					
			//Category	
			WebElement CategoryClick=driver.findElement(By.xpath("//div[@class='direct fixedHeight']"));
			CategoryClick.click();	
			Thread.sleep(2000);	
			
			WebElement CategorySelect=driver.findElement(By.xpath("//div[@class='drop-down-menu']//div[2]"));		
			CategorySelect.click();	
			Thread.sleep(2000);
			
			//SubCategory Name		
			WebElement SubCategoryName=driver.findElement(By.xpath("//input[@id='category']"));
			SubCategoryName.sendKeys("ATest1");	
			Thread.sleep(2000);
					
			//Submit button work
			WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
			Submit.click();	
			
			Reporter.log("Add Subcategory successfully");
			
			//Edit Sub category
			//Category	
			WebElement EditCategoryClick=driver.findElement(By.xpath("//div[@class='direct fixedHeight']"));
			EditCategoryClick.click();	
			Thread.sleep(2000);			
			
			WebElement EditCategorySelect=driver.findElement(By.xpath("//div[@class='drop-down-menu']//div[2]"));			
			EditCategorySelect.click();	
			Thread.sleep(2000);
			
			//SubCategory Name		
			WebElement EditSubCategoryName=driver.findElement(By.xpath("//input[@id='category']"));
			EditSubCategoryName.sendKeys("ATest");	
			Thread.sleep(2000);
					
			//Submit button work
			WebElement EditSubCategorySubmit=driver.findElement(By.xpath("//button[@type='submit']"));
			EditSubCategorySubmit.click();	
			
			Reporter.log("Edit Subcategory successfully");
			
			//Perfect code 17.09.24		
		}
		
		@Test(priority=6)
		public void AddSubChildCategory() throws InterruptedException
		{		
			
			//SubChildCategory Click		
			WebElement SubChildCategoryClick=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/button[4]"));
			SubChildCategoryClick.click();	
			Thread.sleep(2000);				
			
			//AddSubChildCategory		
			WebElement AddSubChildCategory=driver.findElement(By.xpath("//button[@class='btn-primary']"));
			AddSubChildCategory.click();	
			Thread.sleep(2000);				
			
			//SubCategory	
			WebElement SubCategoryClick=driver.findElement(By.xpath("//div[@class='direct fixedHeight']"));
			SubCategoryClick.click();	
			Thread.sleep(2000);		
			WebElement SubCategorySelect=driver.findElement(By.xpath("//div[@id='delete-card-container']//div[3]//span[1]"));
			SubCategorySelect.click();	
			Thread.sleep(2000);
			
			//SubChildCategory Name		
			WebElement SubChildCategoryName=driver.findElement(By.xpath("//input[@id='category']"));
			SubChildCategoryName.sendKeys("Epoxy Primer2AA1");	
			Thread.sleep(2000);
					
			//Submit button work
			WebElement AddSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
			AddSubmit.click();
			
			Reporter.log("Add Subchild category successfully");			
			
			//EditSubchildcategory		
			//SubCategory	
			WebElement EditSubCategoryClick=driver.findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/button[1]/span[1]"));
			EditSubCategoryClick.click();	
			Thread.sleep(2000);		
			
			WebElement EditSubCategorySelect=driver.findElement(By.xpath("//div[@id='delete-card-container']//div[3]//span[1]"));
			EditSubCategorySelect.click();	
			Thread.sleep(2000);
			
			//SubChildCategory Name		
			WebElement EditSubChildCategoryName=driver.findElement(By.xpath("//input[@id='category']"));
			EditSubChildCategoryName.sendKeys("Epoxy Primer1AB");	
			Thread.sleep(2000);
					
			//Submit button work
			WebElement EditSubmitSubChildCategory=driver.findElement(By.xpath("//button[@type='submit']"));
			EditSubmitSubChildCategory.click();
			Reporter.log("Edit Subchild category successfully");
			
			//Perfect code run 17.09.24		
		}
			
		@Test(priority=7)
		public void PaintType() throws InterruptedException
		{		
			
			//Add Painttype...................................................................................
			//PaintTypeClick		
			WebElement PaintTypeClick=driver.findElement(By.xpath("//button[normalize-space()='Paint Type']"));
			PaintTypeClick.click();	
			Thread.sleep(2000);		
		
			//AddPaintType		
			WebElement AddPaintType=driver.findElement(By.xpath("//button[@class='btn-primary']"));
			AddPaintType.click();	
			Thread.sleep(2000);		
			
			//AddPaintName		
			WebElement PaintTypeName =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
			PaintTypeName.sendKeys("ATest9");
			Thread.sleep(2000);			
			
			//Submit button work
			WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
			Submit.click();
			
			Reporter.log("Add PAinttype successfully");
			
			//Edit PaintType........................................................................................		
			WebElement EditPaintType=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/button[1]/span[1]"));
			EditPaintType.click();	
			Thread.sleep(2000);		
					
			//AddPaintName		
			WebElement EditPaintTypeName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
			EditPaintTypeName.sendKeys("ATest6");
			Thread.sleep(2000);			
					
			//Submit button work
			WebElement EditPaintTypeSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
			EditPaintTypeSubmit.click();
			
			Reporter.log("Edit Painttype successfully");
			
			//Perfect code run 17.09.24				
		}	
		
		@Test(priority=8)
		public void FinishType() throws InterruptedException
		{		
			
			//Add Finish Type.............................................................................................
			//FinishTypeClick		
			WebElement FinishTypeClick=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/button[6]"));
			FinishTypeClick.click();	
			Thread.sleep(2000);		
			
			//AddFinishType		
			WebElement AddFinishType=driver.findElement(By.xpath("//button[normalize-space()='ADD FINISH']"));
			AddFinishType.click();	
			Thread.sleep(2000);		
			
			//FinishTypeName		
			WebElement FinishTypeName=driver.findElement(By.xpath("//input[@id='name']"));
			FinishTypeName.sendKeys("ATest10");
			Thread.sleep(2000);				
			
			//Submit button work
			WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
			Submit.click();	
			
			Reporter.log("Add Finishtype successfully");
				
			//Edit Finish Type.............................................................................................		
			//FinishTypeName			
			WebElement EditFinishTypeClick=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/button[1]/span[1]"));
			EditFinishTypeClick.click();
			
			WebElement EditFinishTypeName=driver.findElement(By.xpath("//input[@id='name']"));
			EditFinishTypeName.sendKeys("ATest7");
			Thread.sleep(2000);				
					
			//Submit button work
			WebElement EditFinishTypeSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
			EditFinishTypeSubmit.click();	
			Reporter.log("Edit Finishtype successfully");
			
			//Perfect run 17.09.24		
		}	
		
		@Test(priority=9)
		public void UOM() throws InterruptedException
		{		
					
			//UOMClick		
			WebElement UOMClick=driver.findElement(By.xpath("//button[normalize-space()='UOM']"));
			UOMClick.click();	
			Thread.sleep(2000);		
			
			//AddUOM		
			WebElement AddUOMType=driver.findElement(By.xpath("//button[normalize-space()='ADD UOM']"));
			AddUOMType.click();	
			Thread.sleep(2000);		
			
			try
			{		
			//UOMName			
			WebElement UOMNameselect=driver.findElement(By.xpath("//div[@class='direct fixedHeight'][1]"));
			UOMNameselect.click();					
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
					
			WebElement UOMNameclick=driver.findElement(By.xpath("//span[normalize-space()='Number']"));
			UOMNameclick.click();
			Thread.sleep(3000);		
					
			//Submit button work
			WebElement UAMSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
			UAMSubmit.click();	
			
			Reporter.log("Add UOM successfully");			
			//Perfect code run 17.09.24
		}
		
		@Test(priority=10)
		public void Color() throws InterruptedException
		{		
			
			//COLORClick		
			WebElement ColorClick=driver.findElement(By.xpath("//button[normalize-space()='Color']"));
			ColorClick.click();	
			Thread.sleep(2000);		
			
			//AddColor		
			WebElement AddColorClick=driver.findElement(By.xpath("(//button[normalize-space()='ADD COLOR'])[1]"));
			AddColorClick.click();	
			Thread.sleep(2000);		
			
			//UOMName		
			WebElement ColorName=driver.findElement(By.xpath("(//input[@id='name'])[1]"));
			ColorName.sendKeys("Green");
			Thread.sleep(2000);	
			
			//color code 		
			WebElement ColorCode=driver.findElement(By.xpath("(//input[@id='colorCode'])[1]"));
			ColorCode.sendKeys("#008000");
			Thread.sleep(2000);	
					
			//Submit button work
			WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
			Submit.click();	
			
			Reporter.log("Add color successfully");				
			//Perfect run 17.09.24			
		}
		
				
	//Perfectly run full code
	
}
