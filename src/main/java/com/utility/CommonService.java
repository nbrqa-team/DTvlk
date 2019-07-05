package com.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.DriverBase;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class CommonService extends DriverBase {
	
	WebDriverWait wait;
	Actions action;
	FluentWait<WebDriver> fWait;
	private static CommonService service=null;
	
	private CommonService()
	{
		wait=new WebDriverWait(driver,5);
		action=new Actions(driver);
		fWait= new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).
				pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}
	
	public static CommonService getInstance()
	{
		if(service==null)
			service=new CommonService();
		
		return service;
	}
	
	public void waitForPageToLoad()
	{
		Predicate<WebDriver> predicate = new Predicate<WebDriver>() {
			
			public boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String state=js.executeScript("return document.readyState").toString();
				if(state.equals("complete"))
						return true;
				else
					return false;
			}
		};
		
		fWait.until(predicate);
	}
	
	public WebElement getElementAfterLoad(final By locator)
	{
		disableImplicitWait();
		
		Predicate<WebDriver> predicate = new Predicate<WebDriver>() {
			
			public boolean apply(WebDriver driver) {
				
				return ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(locator))).apply(driver);
			}
		};
		
		fWait.until(predicate);
		
		return driver.findElement(locator);		
	}
	
	public void waitForModalToDisappear(By locator)
	{
		disableImplicitWait();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		enableImplicitWait();
	}
	
	public void waitForClickableElement(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementTobeVisible(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickAction(WebElement element)
	{
		action.moveToElement(element).click().build().perform();
	}
	
	public void javaScriptClick(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	public void pause(int milliSeconds)
	{
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void disableImplicitWait() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	private void enableImplicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
