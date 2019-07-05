package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.DriverBase;
import com.pageObjects.CityPageElements;
import com.utility.CommonService;

public class CityPage extends DriverBase{
	
	CityPageElements elements=null;
	CommonService service=null;
	
	public CityPage()
	{
		elements=new CityPageElements();
		service=CommonService.getInstance();
	}
	
	public void verifyTopThings() {
		
		for(int i=1; i<elements.topThings.size() ;i++)
		{
			String name=elements.topThings.get(i-1).findElement(elements.name).getText();
			String price=elements.topThings.get(i-1).findElement(elements.price).getText();
			
			System.out.println(name+" : "+price);
		}
		
	}
}
