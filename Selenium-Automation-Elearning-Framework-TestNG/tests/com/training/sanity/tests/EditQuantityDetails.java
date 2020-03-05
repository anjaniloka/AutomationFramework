package com.training.sanity.tests;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
public class EditQuantityDetails {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ProductPOM productPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		productPOM = new ProductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		screenShot.captureScreenShot("LoginPage");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("DashboardPage");
	
	driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-tags fw']")).click();
	Thread.sleep(2000);
	screenShot.captureScreenShot("Catalog");
   	List<WebElement> obj = driver.findElements(By.xpath("//*[@id='menu-catalog']/ul/li"));
	String flag;
	for(int i=0;i<obj.size();i++)
	{
	WebElement element = obj.get(i);
	flag=obj.get(i).getText();
	if(flag.equals("Products"))
	{
	element.click();
	Thread.sleep(5000);
	screenShot.captureScreenShot("ProductQuantityList");
	break;
	}
	}
	
	driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
	Thread.sleep(2000);
	screenShot.captureScreenShot("EditIcon");
	
	List<WebElement> obj1 = driver.findElements(By.xpath("//*[@id='form-product']/ul/li"));
	String flag1;
	for(int i=0;i<obj1.size();i++)
	{
	WebElement element = obj1.get(i);
	flag1=obj1.get(i).getText();
	if(flag1.equals("Data"))
	{
	element.click();
	Thread.sleep(5000);
	screenShot.captureScreenShot("DataTab");
	break;
	}
	}
	
	driver.findElement(By.xpath("//*[@id='input-quantity']")).clear();
	Thread.sleep(5000);
	screenShot.captureScreenShot("quantityvalue");
	
	productPOM.sendquantity("45");
	screenShot.captureScreenShot("Newquantity");
	
	//Default values in Links, Attribute, Option, Recurring, Discount, Special, Image, Reward Points and Design tabs
	List<WebElement> object = driver.findElements(By.xpath("//*[@id='form-product']/ul/li"));
	String flag2;
	for(int i=2;i<object.size();i++)
	{
	WebElement element = object.get(i);
	flag2=object.get(i).getText();
	if(flag2.equals("Links"))
	{
	element.click();
	Thread.sleep(1000);
	}
	else
		
	if(flag2.equals("Attribute"))
	{
	element.click();
	Thread.sleep(1000);
}
	else
		
		if(flag2.equals("Option"))
		{
			element.click();
			Thread.sleep(1000);
		}
		else
	if(flag2.equals("Links"))
	{
	element.click();
	Thread.sleep(1000);
	}
	else
		
	if(flag2.equals("Recurring")) 
	{
	element.click();
	Thread.sleep(1000);
}
	else
		
		if(flag2.equals("Discount"))
		{
			element.click();
			Thread.sleep(1000);
		}
	
else
		
		if(flag2.equals("Special"))
		{
			element.click();
			Thread.sleep(1000);
		}
		else
	if(flag2.equals("Image"))
	{
	element.click();
	Thread.sleep(1000);
	}
	else
		
	if(flag2.equals("Reward Points")) 
	{
	element.click();
	Thread.sleep(1000);
}
	else
		
		if(flag2.equals("Design"))
		{
			element.click();
			Thread.sleep(1000);
		}
		}
	productPOM.clicksaveBtn(); 
	screenShot.captureScreenShot("savesuccessful");
	
	}
	}
	
	
	
	
