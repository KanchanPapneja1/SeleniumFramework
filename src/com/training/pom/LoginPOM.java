package com.training.pom;
//Login POM updates
import java.util.List;

import org.openqa.selenium.By;
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
	
//	***********************************************Medium TCs**********************************************
	
	@FindBy(xpath="//a[contains(text(),'Administration')]")
 
	private WebElement AdminTab;
	
	public void AdminTabClick() {
		this.AdminTab.click();
	}
	
	@FindBy(xpath= "//div[@class='alert alert-info']//span[contains(text(),'×')]")
	private WebElement msg;
	
	public void msgclick() {
		this.msg.click();
		System.out.println("Msg closed");
	}
	
	
	
	@FindBy(xpath="//a[contains(text(),'User list')]")
	//@FindBy(xpath= "//div[@class='panel panel-default block-admin-users']//a[contains(text(),'User list')]")
	private WebElement UserList;
	
	public void UserListClick() {
		this.UserList.click();
	}
	
	@FindBy(id="search_simple_keyword")
	private WebElement SearchUser;
	
	public void giveusername(String name)
	{
		this.SearchUser.sendKeys(name);
	}

	@FindBy(id="search_simple_submit")
	private WebElement UserSearchBtn;
	
	public void UserSearchBtnClick()
	{
		this.UserSearchBtn.click();
	}
			
	//***************Below code isn't working ****************
	
	@FindBy(xpath="//table[@class='table table-bordered data_table']//tr")
	private List<WebElement> UserTable;
//	int noofRows = UserTable.size();
	
	
	public void EditButtonClick() {
		
		for(int i=2; i<=UserTable.size(); i++) 
		{
        System.out.println("No of rows"+ UserTable.size());
	    String name = driver.findElement(By.xpath("//table[@class='table table-bordered data_table']/tbody/tr["+i+"]/td[4]")).getText();
	        System.out.println("UserName = "+name);
	    if(name.equalsIgnoreCase("KanchanTest")) {  	
	    	
	       driver.findElement(By.xpath("//table[@class='table table-bordered data_table']/tbody/tr["+i+"]/td[11]/a[6]")).click();
	        System.out.println("You can now edit");
	        
		}
		}
	}
	
	//**************** Above code isn't working ****************
	
		@FindBy(id="user_edit_email")
		private WebElement emailtxtbox;
		
		public void emailtxtboxclear()
		{
			this.emailtxtbox.clear();
		}
		
		public void sendnewemail(String email)
		{
			this.emailtxtbox.sendKeys(email);
		}
		
		@FindBy(css="input#qf_f4924c")
		private WebElement inactiveradiobtn;
		
		public void radiobtnclick() {
			if(inactiveradiobtn.isDisplayed()==true) {
			this.inactiveradiobtn.click();
		}else {
			System.out.println("Radio Button isn't present");
		}
		}
		@FindBy(xpath="//button[@id='user_edit_submit']")
		private WebElement savebtn;
		
		public void savebtnclk()
		{
			this.savebtnclk();
		}
}
	


