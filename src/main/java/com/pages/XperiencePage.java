package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.DriverBase;
import com.pageObjects.XperiencePageElements;
import com.utility.CommonService;

public class XperiencePage extends DriverBase{
	
	XperiencePageElements elements=null;
	CommonService service=null;
	
	public XperiencePage()
	{
		elements=new XperiencePageElements();
		service=CommonService.getInstance();
	}
	
	public CityPage enterCity(String name)
	{
		
		System.out.println(driver.getCurrentUrl());
		service.getElementAfterLoad(elements.searchBox).click();
		
		driver.findElement(By.xpath("//div[@data-id='experienceAutoComplete']//div//div/span[text()='"+name+"']")).click();
		
		service.pause(3000);
		
		service.waitForPageToLoad();
		return new CityPage();
	}
}
