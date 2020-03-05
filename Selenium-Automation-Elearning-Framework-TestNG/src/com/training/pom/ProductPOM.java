package com.training.pom;

//import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ProductPOM {

	private WebDriver driver; 
		
		public ProductPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
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
