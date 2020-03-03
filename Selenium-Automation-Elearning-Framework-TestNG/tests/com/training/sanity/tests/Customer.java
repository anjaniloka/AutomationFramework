package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
//import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Customer {
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

   @Test (priority=2)
    public void vaLoginTest() throws InterruptedException {
	loginPOM.sendUserName("admin");
	loginPOM.sendPassword("admin@123");
	screenShot.captureScreenShot("LoginPage");
	loginPOM.clickLoginBtn();
	screenShot.captureScreenShot("DashboardPage");
	Thread.sleep(2000);
	loginPOM.clickcustomerOpt();
	
	driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-user fw']")).click();
	Thread.sleep(2000);
	screenShot.captureScreenShot("Customers");
	
	driver.findElement(By.xpath("//*[@id='menu-customer']/ul/li[1]/a")).click();
	Thread.sleep(2000);
	screenShot.captureScreenShot("Customerslist");
	
	//enter customer name
	//loginPOM.sendcustomerName("manzoor");
	loginPOM.sendcustomerName("Asmita mehadi");
	
	//click filter button
	loginPOM.clickfilterBtn();
	Thread.sleep(1000);
	screenShot.captureScreenShot("selectedcustomer");
	
	//Enter customer email id
	//loginPOM.sendcustomerEmail("manzoor@gmail.com");
	loginPOM.sendcustomerEmail("manzoormehadi21@gmail.com");
	//click filter button
	loginPOM.clickfilterBtn();
	Thread.sleep(1000);
	screenShot.captureScreenShot("customeremail");
	
	
	}
   
}


	
	









