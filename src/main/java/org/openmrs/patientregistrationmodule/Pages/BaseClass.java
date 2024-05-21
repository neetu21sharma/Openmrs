package org.openmrs.patientregistrationmodule.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	//public driver reference which can be accessed across the project
	public static WebDriver driver;
	Properties prop;
	
	@BeforeTest // run this once for all classes
	
	public void readPropertyFile() throws IOException{
	
	try
	{
		File file = new File("./src/test/resources/config/openmrs.properties");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
		
	} catch (Exception e){
		System.out.println("unable to load the properties file");
		e.printStackTrace();
	}
	
	}
	public void InstantiateDriver(String browserType) throws IOException {
		// WebDriverManager.chromedriver().setup();
		//String browser = prop.getProperty("browser");

		if (browserType.trim().equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserType.trim().equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browserType.trim().equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new InternetExplorerDriver();
		}
	}

	public WebDriver maximize() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	
	public void getUrl() {
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	
	public void tearDown() {
		driver.quit();

	}

}

