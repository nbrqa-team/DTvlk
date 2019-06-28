package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.DiverBase;

public class MyListener extends DiverBase implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		Log.startTestCase(result.getName()+" Passed");
	}

	public void onTestFailure(ITestResult result) {
		Log.startTestCase(result.getName()+" Failed");
		
		String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String currentTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		  
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,  new File("files/screenshots/"+date+"/"+result.getName()+"_"+currentTime+".png"));
		} catch (IOException e) {
			Log.info("Failed to save screenshot for method"+result.getName());
		}
	}

	public void onTestSkipped(ITestResult result) {
		Log.startTestCase(result.getName()+" Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Log.startTestCase(result.getName()+" Failed but within acceptable percentage");
		
		String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String currentTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		  
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,  new File("files/screenshots/"+date+"/"+result.getName()+"_"+currentTime+".png"));
		} catch (IOException e) {
			Log.info("Failed to save screenshot for method"+result.getName());
		}
	}

	public void onStart(ITestContext context) {
		Log.startTestCase("Started Test Batch "+context.getName()+" Execution");
	}

	public void onFinish(ITestContext context) {
		Log.startTestCase("Finished Test Batch "+context.getName()+" Execution");
	}

	public void onTestStart(ITestResult result) {
		Log.startTestCase("Started Test "+result.getName()+" Execution");
	}

}
