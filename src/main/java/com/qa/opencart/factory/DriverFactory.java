package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	/*
	 * This is used to initialized driver on the basis of browser name 
	 * @param browserName 
	 * 
	 */
	
	public WebDriver initDriver(Properties prop) {
		//cross browser logic
		
		String browserName = prop.getProperty("browser");	
	    System.out.println("From DriverFactory Class ->Browser name is " + browserName);
		
		 switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;
			
		case "mozialla":
			driver = new FirefoxDriver();
			break;
	
		default:
			System.out.println("Please provider the correct Browser" + browserName);
			//throw  new BrowserException(AppError.BROWSER_NOT_FOUND);
			break;
		}
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.get(prop.getProperty("url"));
		 
		 return driver;
		 
		 
	}
		
	/*
	 * This method is used to initialize  the properties from the .properties file
	 * @return this return properties (prop)
	 * 
	 */
	
	public Properties initProp() {
		//cross properties logic
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);

			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch( IOException e) {
				e.printStackTrace();
			}
		 	return prop;
		}

	}

