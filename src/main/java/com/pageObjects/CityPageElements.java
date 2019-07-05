package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.base.DriverBase;

public class CityPageElements extends DriverBase{
	
	public CityPageElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//h2[text()='Top Things to Do Around Singapore']/parent::div/div")
	public List<WebElement> topThings;
	
    public By name =By.xpath("a/div/div/div");

	public By price=By.xpath("a/div/div/following-sibling::div/div/div/div[2]");

}
