package com.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.DriverBase;
import com.pageObjects.HomePageElements;

public class HomePage extends DriverBase{
	
	HomePageElements elements=null;
	WebDriverWait wait;
	Actions action;
	
	public HomePage()
	{
		elements=new HomePageElements();
		wait=new WebDriverWait(driver,10);
		action=new Actions(driver);
	}
	
	public XperiencePage NavigateToXprienceFromHeader()
	{
		
		elements.ThingsToDo.click();

		elements.Xperiencedp.click();
		
		return new XperiencePage();
	}

}
