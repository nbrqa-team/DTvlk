package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import com.base.DriverBase;
import com.pageObjects.HomePageElements;
import com.utility.CommonService;

public class HomePage extends DriverBase{
	
	HomePageElements elements=null;
	CommonService service=null;
	
	public HomePage()
	{
		elements=new HomePageElements();
		service=CommonService.getInstance();
	}
	
	public XperiencePage NavigateToXprienceFromHeader()
	{
		service.waitForModalToDisappear(elements.modalElement);
		elements.ThingsToDo.click();
		
		elements.Xperiencedp.click();
		service.pause(3000);
		
		service.waitForPageToLoad();
		System.out.println(driver.getCurrentUrl());
		return new XperiencePage();
		
		
	}

}
