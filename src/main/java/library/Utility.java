package library;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.bouncycastle.util.encoders.Base64;


import base.BaseFile;



public class Utility extends BaseFile{

	public static void CaptureScreenShot(File destFile, String filename) throws IOException {

		TakesScreenshot takescreenshot= (TakesScreenshot) driver;
		File  sourcefile=takescreenshot.getScreenshotAs(OutputType.FILE);
		File destFile= new File("./screenshots\\" + filename);
	//	FileOutputStream fos = new FileOutputStream(destFile);
		byte [] byteArrayScreenshot = Files.readAllBytes(new File(destFile).toPath());
	
		
	
	}
}
