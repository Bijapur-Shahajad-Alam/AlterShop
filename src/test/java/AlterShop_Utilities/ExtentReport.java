package AlterShop_Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import AlterShop_Testcases.BaseClass;


public class ExtentReport implements ITestListener {

	public ExtentSparkReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
public void onStart(ITestContext context) {
		
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timestamp+".html";
		
		reporter=new ExtentSparkReporter("./Reports/"+repName);
		reporter.config().setDocumentTitle("Functional Testing Report");
		reporter.config().setReportName("AlterShop Automation Testing Report");
		reporter.config().setTheme(Theme.DARK);
		
		reports =new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("HostName", "localhost");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("UserName","Alam");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Browser", "chrome");	
	}
	
	
public void onTestSuccess(ITestResult tr) {
		
		test=reports.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		
	}
	public void onTestFailure(ITestResult tr) {
		test=reports.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		System.out.println("test is failed");
		try {
			String image=new BaseClass().captureScreen(tr.getName());
			test.addScreenCaptureFromPath(image);
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult tr) {
		test=reports.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		try {
			String imgpath=new BaseClass().captureScreen(tr.getName());
			test.addScreenCaptureFromPath(imgpath);
			
		}catch(Exception e3) {
			e3.printStackTrace();
		}
	}
	public void onFinish(ITestContext context) {
		reports.flush();
	}
    
	
	
}
