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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_053_Report {

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
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	//updates
	@Test(priority=0)
	public void validLoginTest() {	
		mediumPOM.sendUserName("admin");
		mediumPOM.sendPassword("admin@123");
		mediumPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoggedIn");
		mediumPOM.reportingTabClick();
		mediumPOM.followedStudentsClick();
		screenShot.captureScreenShot("List of Follwed Stud	ents");
		mediumPOM.studentNameEnter("Kanchan");
		mediumPOM.stdntSrchBtnClick();
		mediumPOM.stdntTableRows();
		screenShot.captureScreenShot("StudentTable");
		mediumPOM.detailsButtonClick("Kanchan");
		screenShot.captureScreenShot("User Details");
		mediumPOM.crsTableRows();
		mediumPOM.crsClick("Automation");	
		screenShot.captureScreenShot("Course Details");
	}
	}

