package com.training.sanity.tests;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
	import com.training.pom.ELTC_013_POM;
//import com.training.pom.ELTC_013_cctlgPOM;
	import com.training.pom.LoginPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class ELTC_013_cctlg {

		
		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private ELTC_013_POM cctlg1;
		private static Properties properties;
		private ScreenShot screenShot;
		
	//	JavascriptExecutor js = (JavascriptExecutor)driver;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		@Test(priority= 1)
		public void validLoginTest() throws InterruptedException {
		/*
		 * 	loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			 */
			
			loginPOM.sendUserName("Kanchan");
			loginPOM.sendPassword("Kanchan@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			
			//cctlg1.Homepage();
			
	//	Thread.sleep(3000);
		//js.executeScript("window.scrollBy(0,1000);");
						
			// cctlg1.clickcctlg();
			
				loginPOM.clickcctlg();
				loginPOM.enterCourse("Selenium");
				loginPOM.clkSrc();
				loginPOM.Subscribe();
				screenShot.captureScreenShot("Second");		
			
		}
	}


