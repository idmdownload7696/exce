package test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import actions.Login_Action;
import base.BaseFile;

public class Login_Test extends BaseFile{
	Login_Action login_action;
	
	
	
	@BeforeClass
	public void lauch() throws InterruptedException {
		browser();
		login_action = new Login_Action();
		login_action.report_path();
	}
	
	@AfterTest
	public void extentEnd() {
		login_action.reportend();
	}
	
	@Test(priority = 1)
	public void Login() throws IOException, InterruptedException {
		login_action.login();
		
		
	}
//	@Test(priority = 2)
//	public void Login2() throws IOException, InterruptedException {
//		login_action.login2();
//		
//		
//	}

}
