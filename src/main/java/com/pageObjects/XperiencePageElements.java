package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.base.DriverBase;

public class XperiencePageElements extends DriverBase {
	
	public XperiencePageElements()
	{
		PageFactory.initElements(driver, this);
	}

	public By searchBox=By.xpath("//input[@data-id='experienceAutoComplete']");

}
