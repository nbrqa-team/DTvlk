package com.tvlk;

import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.XperiencePage;
import com.testbase.TestBase;


public class NavigateToXperience extends TestBase{
	
  HomePage page=null;
  XperiencePage xpage=null;
	
  @Test
  public void NavigateToXperienceMethod(){
	 
	  page=new HomePage();
	  xpage=page.NavigateToXprienceFromHeader();
  }
}
