package api_utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extent_report_manager implements ITestListener {
	String ReportName;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public void onStart(ITestContext testContext)
	{
		String timestamp = new SimpleDateFormat("DD.MM.YYYY.mm.ss").format(new Date());
		ReportName="FE_Report_"+timestamp+".html";
		
		sparkReporter= new ExtentSparkReporter(".\\reports\\"+ReportName);
		
		sparkReporter.config().setDocumentTitle("FE_API_Test");
		sparkReporter.config().setReportName("DataBuck_API_Test");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Databuck");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("system.name"));
		extent.setSystemInfo("Environment", "Automation_Test");
		extent.setSystemInfo("user", "Test_User");
		
	}

	public void OntestPass(ITestResult result)
	{
		
		test= extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test passed");
		
	}
	public void OntestFail(ITestResult result)
	{
		
		test= extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, "Test failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}
	
	public void OntestSkip(ITestResult result)
	{
		
		test= extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.SKIP, "Test skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
	}
	
	public void Onfinish(ITestContext testContext)
	{
		extent.flush();
	}
	
}
