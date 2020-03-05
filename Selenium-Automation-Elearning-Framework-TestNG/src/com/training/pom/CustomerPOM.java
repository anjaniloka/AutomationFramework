package com.training.pom;

//import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

public class CustomerPOM {

	private WebDriver driver; 
		
		public CustomerPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		// Select Customer option from menubar
		
		 @FindBy(xpath ="//*[@id='menu-customer']")  
		private WebElement customerOpt; 
		
		public void clickcustomerOpt() {
			this.customerOpt.click();
		
		}
	//Search for particular customer with Name & email Id
	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement customerName; 
	
	public void sendcustomerName(String customerName) {
		this.customerName.clear();
		this.customerName.sendKeys(customerName);
}
	@FindBy(xpath ="//button[@id='button-filter']")  
	private WebElement filterBtn; 
	public void clickfilterBtn() {
		this.filterBtn.click(); 
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement customerEmail; 
	
	public void sendcustomerEmail(String customerEmail) {
		this.customerEmail.clear();
		this.customerEmail.sendKeys(customerEmail);
	}
	
	//Delete selected customer from the list 
	@FindBy(xpath ="//i[@class='fa fa-trash-o']")
	private WebElement deleteBtn; 
	public void clickdeleteBtn() {
	this.deleteBtn.click();
	
	}
}
