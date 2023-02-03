package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMClass;
import pompackage.Pomlogin;
import testdata.Excelsheet;

public class LoginTest extends BaseHRMClass{
Pomlogin log;
	
	public LoginTest() {
		
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		screenshots("Login");
		
	  log=new Pomlogin();
		
	}
	@Test
	public void Title() {
		String actual=log.verify();
		Assert.assertEquals(actual, "OrangeHRM");
	}
	
	@DataProvider
	public Object[][]Details(){
		Object[][] result=Excelsheet.readdata("Sheet1");
		return result;
	}
	
	@Test(dataProvider="Details")
	public void Login(String name,String password) {
		log.typeusername(name);
		log.typepassword(password);
		log.clickbtn();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	
}
