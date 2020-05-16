package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.MediumPOM;
//import com.training.pom.MediumPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_051_Userdetails {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private MediumPOM mediumPOM;
	private static Properties properties;
	private ScreenShot screenShot;

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
		mediumPOM= new MediumPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser -
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	//Update
	@Test(priority = 0, enabled= true) 
	public void validLoginTest() throws InterruptedException {
	 	mediumPOM.sendUserName("admin");
		mediumPOM.sendPassword("admin@123");
		mediumPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LogIn");
		mediumPOM.AdminTabClick();
		mediumPOM.msgclick();
		mediumPOM.UserListClick();
		screenShot.captureScreenShot("User");
		mediumPOM.giveusername("Kanchan");
		mediumPOM.UserSearchBtnClick();
		//Thread.sleep(3000);
		mediumPOM.tablerows();
		mediumPOM.EditButtonClick(); 
		screenShot.captureScreenShot("EditScreen");
		mediumPOM.emailtxtboxclear();
		mediumPOM.sendnewemail("newemail@gmail.com");
		mediumPOM.radiobtnclick();
		screenShot.captureScreenShot("RadioBtn");
		mediumPOM.savebtnclk();
		screenShot.captureScreenShot("Success1");
		 							
	}
}
