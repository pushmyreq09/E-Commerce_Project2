package com.myshop.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myshop.base.BaseClass;
import com.myshop.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 Readconfig readconfig=new Readconfig();
		public String URL=readconfig.getApplicationURL();
		public String username=readconfig.getUserName();
		public String password=readconfig.getPassword();
		public static Logger log;
		public static WebDriver driver;
		
		
		
		@Parameters("browser")
		@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
		public void setup(String br)
		{
			if(br.equals("chrome"))
			{ WebDriverManager.chromedriver().setup();
			   driver = new ChromeDriver();
			}
			else if(br.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				
				 driver = new FirefoxDriver();
			}
			else if(br.equals("Edge"))
			{
				WebDriverManager.edgedriver().setup();
					 driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get(URL);
			
			log = Logger.getLogger(BaseClass.class);
			PropertyConfigurator.configure("Log4j2.properties");
			
			
			
			
			 
		}
		
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}


         @AfterMethod(groups= {"Smoke","Sanity","Regression"})
		public void tearDown() {
			// TODO Auto-generated method stub
			driver.quit();
		}
		
		
		
		
		

}
