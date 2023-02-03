package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMClass;

public class Pomlogin extends BaseHRMClass {

	//we will create object repository
	@FindBy(css="div.oxd-form-row:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)" )
	WebElement Username;
	@FindBy(css="div.oxd-form-row:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	WebElement Password;
	@FindBy(css=".oxd-button")
	WebElement Loginbutton;
	
	//initiate page elements
	public Pomlogin() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeusername(String name) {
		//driver.findElement(null).send keys  - instead this use below
		Username.sendKeys(name);
	}
	
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickbtn() {
		Loginbutton.click();
	}
	public String verify() {
		return driver.getTitle();
	}
}
