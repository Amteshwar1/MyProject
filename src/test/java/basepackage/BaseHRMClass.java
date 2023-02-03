package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRMClass {

public static	Properties prop=new Properties();
public static	WebDriver driver;
	//step 1:importing the files using the method below
	public BaseHRMClass() {
		
		
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\Config. properties");
	prop.load(file);
		}
	
		catch(FileNotFoundException e) {
		e.printStackTrace();
	}
catch (IOException a) {
	a.printStackTrace();
}
	}
	//step 2
		public static void initiation() {
		//driver path webdriver.gecko - we wont use this method rather use general for all 
			//maximize pageload, implicit, getting url
	String browsername=prop.getProperty("browser");
		if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\eclipse-workspace\\seleniummavenn\\geckodriver.exe");
			
			driver=new FirefoxDriver();}
		
			else if (browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "chrome.exe");
				driver=new ChromeDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
		
		}
		
		public static void screenshots(String Filename) {
		File file=	((TakeScreenshot)driver).getScreenShotAs(OutputType.FILE);
		try {
		FileUtils.copyDirectory(file, new File("C:\\Users\\user\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		}
		
		
		
		
		
		
		
}
		
