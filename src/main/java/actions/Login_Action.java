package actions;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseFile;
import library.Utility;
public class Login_Action extends BaseFile{
	
	public static ExtentTest extent_test;
	public static ExtentReports extent_report;
	public static void report_path() {
		extent_report=new ExtentReports();
		File file = new File("./extent_report/new.html");
		ExtentSparkReporter  sparkReporter = new ExtentSparkReporter(file);
		extent_report.attachReporter(sparkReporter);
		
		
	}
	public static void reportend() {
		extent_report.removeTest(extent_test);
		extent_report.flush();
	}
	
	public  void login() throws IOException, InterruptedException {
		String base64code=Utility.CaptureScreenShot("sdhd.png");
		
		extent_test=extent_report.createTest("Login1 Functionality");
		//driver.navigate().refresh();
		WebElement email = driver.findElement(By.xpath("//input[@name='username']"));
		//driver.navigate().refresh();
		email.sendKeys("abc@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		//driver.navigate().refresh();
		password.sendKeys("abc");
		
		WebElement Login_Btn= driver.findElement(By.xpath("//button[@type='submit']"));
		Login_Btn.click();
		Thread.sleep(5000);
		
		WebElement error_message = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
		String error_msg_text = error_message.getText();
		System.out.println(error_msg_text);
		
		if(error_msg_text.equals("Invalid credenti,l'l;'als")) {
			extent_test.log(Status.PASS, "Login Success");
		
		}else {
			
			extent_test.log(Status.FAIL, "Login Fail");
			extent_report.createTest("Binod").addScreenCaptureFromBase64String(base64code);
			
			
			
		}
		assertEquals(error_msg_text, "Invalid ");
	}

//public  void login2() throws IOException, InterruptedException {
//
//	extent_test=extent_report.startTest("Login2 Functionality");
//	WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
//	email.sendKeys("abc@gmail.com");
//	
//	WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//	password.sendKeys("abc");
//	
//	WebElement Login_Btn= driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
//	Login_Btn.click();
//	Thread.sleep(3000);
//	WebElement error_message = driver.findElement(By.xpath("//div[text()='Please enter valid username and password.']"));
//	String error_msg_text = error_message.getText();
//	System.out.println(error_msg_text);
//	if(error_msg_text.equals("Please enter valid  and password.")) {
//		extent_test.log(LogStatus.PASS, "Login Success");
//	}else {
//		
//		extent_test.log(LogStatus.FAIL, "Login Fail");
//		Utility.CaptureScreenShot(driver, "invalid_login1");
//		
//	}
//	assertEquals(error_msg_text, "Please enter valid usehrname and password.");
//}
}
 




