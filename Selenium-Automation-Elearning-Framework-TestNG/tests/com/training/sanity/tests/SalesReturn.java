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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SalesReturn {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		Thread.sleep(1000);
		screenShot.captureScreenShot("DashboardPage");
		driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-shopping-cart fw']")).click();
		Thread.sleep(2000);
		screenShot.captureScreenShot("SalesIcon");
	   	List<WebElement> obj = driver.findElements(By.xpath("//*[@id='menu-sale']/ul/li"));
		String flag;
		for(int i=0;i<obj.size();i++)
		{
		WebElement element = obj.get(i);
		flag=obj.get(i).getText();
		if(flag.equals("Returns"))
		{
		element.click();
		Thread.sleep(5000);
		screenShot.captureScreenShot("ProductReturnList");
		break;
		}
		}
		
		//enter OrderID name
	    loginPOM.sendorderId("7");
		
		//click filter button
		loginPOM.clickfilterBttn();
		Thread.sleep(1000);
		screenShot.captureScreenShot("selectedOrder");
		
		//Select check box
		driver.findElement (By.xpath("//input[@name='selected[]']")).click();
		Thread.sleep(1000);
		screenShot.captureScreenShot("selectcheckbox");
		
		//click on delete button
		loginPOM.clickdeleteBttn();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		screenShot.captureScreenShot("deletecustomer");
			
	}
	}
	
	


	



		

	
	
	
	
	


	