package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.base.DriverBase;

public class HomePageElements extends DriverBase{
	
	public HomePageElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//div//span[text()='Things to Do']/parent::div")
	public WebElement ThingsToDo;
	
	@FindBy(how=How.XPATH, using="//div//span[text()='Things to Do']/parent::div/following-sibling::div//div[text()='Xperience']")
	public WebElement Xperiencedp;
		
}
