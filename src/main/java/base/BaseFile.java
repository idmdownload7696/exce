
package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseFile {


		public static WebDriver driver;
		public static Properties prop;

		public void browser() throws InterruptedException  {

			try {
				FileInputStream fs = new FileInputStream("D:\\workspace\\Excel\\config.properties");
				prop = new Properties();
				prop.load(fs);
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
				//chromeOptions.addArguments("--disable-notifications");
				driver = new ChromeDriver(chromeOptions);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public void stop() {
			driver.close();
		}

}





