package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
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
	
	
	public By modalElement=By.xpath("//div[@data-attr='modalBox']");
	
	@FindBy(how=How.XPATH, using="//div//span[text()='Things to Do']/parent::div/parent::div")
	public WebElement ThingsToDo;
	
	@FindBy(how=How.XPATH, using="//div//span[text()='Things to Do']/parent::div/following-sibling::div/div/div/a")
	public List<WebElement> ThingsMenu;
	
	@FindBy(how=How.XPATH, using="//div//span[text()='Things to Do']/parent::div/following-sibling::div//div[text()='Xperience']/parent::a")
	public WebElement Xperiencedp;
	
}
