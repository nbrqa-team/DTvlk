package com.tvlk;

import org.testng.annotations.Test;

import com.pages.CityPage;
import com.pages.HomePage;
import com.pages.XperiencePage;
import com.testbase.TestBase;
import com.utility.CommonService;

public class VerifyCitypageContent extends TestBase{
  
	HomePage page=null;
	XperiencePage xpage=null;
	CityPage cpage=null;

	  @Test
	  public void cityPageContent() {
		  
		  page=new HomePage();
		  xpage=page.NavigateToXprienceFromHeader();
		  
		  cpage=xpage.enterCity("Singapore");
		  
		  cpage.verifyTopThings();
		  
	  }
}
