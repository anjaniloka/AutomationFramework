package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.CustomerPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteCustomer {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CustomerPOM customerPOM;
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
		customerPOM = new CustomerPOM(driver);
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
	customerPOM.clickcustomerOpt();
	
	driver.findElement(By.xpath("//a[@class='parent']/i[@class='fa fa-user fw']")).click();
	Thread.sleep(2000);
	screenShot.captureScreenShot("Customers");
	
	driver.findElement(By.xpath("//*[@id='menu-customer']/ul/li[1]/a")).click();
	Thread.sleep(2000);
	screenShot.captureScreenShot("Customerslist");
	
	//enter customer name 
	//loginPOM.sendcustomerName("manzoor"); 
	customerPOM.sendcustomerName("Asmita mehadi");
	//click filter button
	customerPOM.clickfilterBtn();
	Thread.sleep(1000);
	screenShot.captureScreenShot("selectedcustomer");
	//loginPOM.sendcustomerEmail("manzoor@gmail.com"); //Enter customer email id
	customerPOM.sendcustomerEmail("manzoor12@gmail.com");
	//click filter button
	customerPOM.clickfilterBtn();
	Thread.sleep(1000);
	screenShot.captureScreenShot("customeremail");
	
	//Select check box
	driver.findElement (By.xpath("//input[@name='selected[]']")).click();
	Thread.sleep(1000);
	screenShot.captureScreenShot("selectcheckbox");
	
	//click on delete button
	customerPOM.clickdeleteBtn();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
	screenShot.captureScreenShot("deletecustomer");
	
	
	}
   
}



