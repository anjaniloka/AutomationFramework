package com.training.pom;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//Login to retail application with admin credentials
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath ="//button[@type='submit']")  
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
		
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
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

	//Search for return product by using OrderID
	// Return Products
	
			@FindBy(xpath ="//*[@id='input-order-id']")  
				private WebElement orderId; 
				
				public void clickorderId() {
					this.orderId.click();
				}
					public void sendorderId(String orderId) {
						this.orderId.clear();
						this.orderId.sendKeys(orderId);
				}
				
				@FindBy(xpath ="//button[@id='button-filter']")  
				private WebElement filterBttn; 
				public void clickfilterBttn() {
					this.filterBttn.click(); 
				}
	
				//Delete selected Order from the list 
				@FindBy(xpath ="//i[@class='fa fa-trash-o']")
				private WebElement deleteBttn; 
				public void clickdeleteBttn() {
				this.deleteBttn.click();
				
				}
				
               //enter the quantity of the product
				
				@FindBy(id="input-quantity")
				private WebElement quantity; 
				
				public void sendquantity(String quantity) {
					this.quantity.clear();
					this.quantity.sendKeys(quantity);
				}
				
				//save button
				@FindBy(xpath ="//i[@class='fa fa-save']")
				private WebElement saveBtn; 
				public void clicksaveBtn() {
				this.saveBtn.click();
				}
				//search product name
				@FindBy(id="input-name")
				private WebElement prodName; 
				
				public void sendprodName(String prodName) {
					this.prodName.clear();
					this.prodName.sendKeys(prodName);
				}
	            			
	
				
				
}

	


