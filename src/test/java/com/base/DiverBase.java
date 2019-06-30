package com.base;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;


public class DiverBase {
	
  public static WebDriver driver;
  String URL = "https://www.traveloka.com/en/";
  String Node = "http://192.168.11.128:5555/wd/hub";
 
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  
	  	 System.setProperty("webdriver.chrome.driver", "D:\\VM\\chromedriver_win32\\chromedriver.exe");
		 ChromeOptions chromeOptions=new ChromeOptions();
		 chromeOptions.addArguments("disable-features=NetworkService");
		 chromeOptions.addArguments("disable-infobars");
		 //driver =new RemoteWebDriver(new URL(Node), chromeOptions);
		 
		 driver=new ChromeDriver(chromeOptions);
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 driver.navigate().to(URL);
		 driver.findElement(By.xpath("//button[@data-id='tvat-confirmDiscoverProduct']")).click();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
