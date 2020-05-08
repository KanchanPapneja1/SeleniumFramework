package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	private String course;
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	

	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement cctlg;
	

	public void clickcctlg() {
		this.cctlg.click(); 
		
	}
	
	@FindBy(name="search_term")
	private WebElement SrchTxtBox;
	
	public void enterCourse(String course) {
		this.SrchTxtBox.sendKeys(course);
		this.course=course;
	}
	
	@FindBy(xpath= "//div[@class='input-group']//button[1]")
	private WebElement SrchBtn;
	
	public void clkSrc()
	{
		this.SrchBtn.click();
	}
	
	@FindBy(xpath="//*[@id=\"cm-content\"]/div/div[3]/div[1]/div/div[2]/div[4]/div/a")
	private WebElement Subsrcibe;
	
	public void Subscribe() {
		this.Subsrcibe.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement Mycourse;
	
	public void Mycourse(String course) {
		this.Mycourse.click();
		this.course=course;
	}
	
	@FindBy(xpath="//a[contains(text(),'Automation')]")
	private WebElement SelectedCrs;
	
	public void getCrsTest() {
		String Text= SelectedCrs.getText();
		
		boolean a= Text.equalsIgnoreCase(course);
		if(a=true) {
			System.out.println("You have enrolled in"+ course );
		}
		else {
			System.out.println(course +" not enrolled");
			}
		}
		
		/*
		if(Text== course)
		{
			System.out.println("You have enrolled in" + course );
		}else
		{
			System.out.println(course +" not enrolled");
		}*/
		
	
	
	public void crsCick() {
		this.SelectedCrs.click();
	}
	
	@FindBy(id="toolimage_6545")
	private WebElement Coursedescription; 
		
	public void Coursedescription() {
		this.Coursedescription.click();
	}
	
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement Logoutdrpdwn;
	
	public void Logoutdrpdwn() {
		
		this.Logoutdrpdwn.click();
	}
	
	@FindBy(id="logout_button")
	private WebElement LogoutBtn;
	
	public void Logoutclick() {
		this.LogoutBtn.click();
	}
	
	
}
