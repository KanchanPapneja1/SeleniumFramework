package com.training.pom;
//Medium TC POM
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MediumPOM{
	private WebDriver driver; 
	private String course;
	private int tablerows;
	private int stdnttablerows;
	private int stdtCourse;
	private int crstablerows;
	private String category;
	//update

	public MediumPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
//Finding WebeElements
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement Logoutdrpdwn;
	
	@FindBy(id="logout_button")
	private WebElement LogoutBtn;
	
	@FindBy(xpath="//a[contains(text(),'Administration')]")
	private WebElement AdminTab;
	
	@FindBy(xpath="//a[contains(text(),'Reporting')]")
	private WebElement reportingTab;
	
	@FindBy(xpath= "//div[@class='alert alert-info']//span[contains(text(),'×')]") //Closing msg box on admin login
	private WebElement msg;
	
	@FindBy(xpath="//a[contains(text(),'User list')]")
	private WebElement UserList;
	
	@FindBy(id="search_simple_keyword")
	private WebElement SearchUser;
	
	
	@FindBy(xpath="//table[@class='table table-bordered data_table']//tr") // User List Table
	private List<WebElement> UserTable;
	
	@FindBy(id="user_edit_email")
	private WebElement emailtxtbox;
	
	@FindBy(xpath="//input[@name='active' and @value= '0']")
	private WebElement inactiveradiobtn;
	
	@FindBy(id="user_edit_submit")
	private WebElement savebtn;
	
	@FindBy(id="search_simple_submit")
	private WebElement UserSearchBtn;
	
	@FindBy(xpath= "//a[contains(text(),'Session')]")
	private WebElement SsnCtgList;
	
	@FindBy(xpath="//*[@title='Add category']")
	private WebElement addCtgry;
	
	@FindBy(xpath="//input[@placeholder='Category']")
	private WebElement Ctgry;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement addbtn;
	
	@FindBy(xpath="//a[contains(text(),'Session list')]")
	private WebElement ssnlist;
	
	@FindBy(xpath="//*[@title='Add a training session']")
	private WebElement addtrng;
	
	@FindBy(id="add_session_name")
	private WebElement ssnName;
	
	@FindBy(id="advanced_params")
	private WebElement advnc;
	
	@FindBy(xpath="//div[@class='filter-option']")
	private WebElement ssnField;
	
	@FindBy(xpath="//*[@id=\"advanced_params_options\"]/div[1]/div[1]/div/div/div[1]/input")
	private WebElement ssnDrpdwn;
	
	@FindBy(xpath="//span[@class='select2-selection__placeholder']")
	private WebElement coachName;
		
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement coachDrpDown;
	
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")
	private WebElement nxtStep;
	
	@FindBy(id="origin")
	private WebElement crsList; 
	
	@FindBy(xpath="//em[@class='fa fa-chevron-right']")
	private WebElement arwSign;

	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement nextStep;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement subscribeUsr;
	
	@FindBy(id="origin")
	private WebElement userList;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement finishBtn;
	
	//*********
	
	
	@FindBy(xpath="//a[contains(text(),'Followed students')]")
	private WebElement followedStudents;
	
	@FindBy(id="search_user_keyword")
	private WebElement studentName;
	
	@FindBy(id="search_user_submit")
	private WebElement stdntSrchBtn;
	
	@FindBy(xpath="//table[@class='table table-bordered data_table']//tr")
	private List<WebElement> stdntTable;
	
	@FindBy(xpath="//table[@class='table table-striped table-hover courses-tracking']//tr")
	private List<WebElement> crsTable;
	
	//Methods***********
	//TC 51

	
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
	
	
	public void Logoutdrpdwn() {
		
		this.Logoutdrpdwn.click();
	}
	

	public void Logoutclick() {
		this.LogoutBtn.click();
	}
	
	
	public void AdminTabClick() {
		this.AdminTab.click();
	}
	
	
	public void msgclick() {
		this.msg.click();
	}
	
	
	public void UserListClick() {
		this.UserList.click();
	}
	
		
	public void giveusername(String name)
	{
		this.SearchUser.sendKeys(name);
	}
	
	public void UserSearchBtnClick()
	{
		this.UserSearchBtn.click();
	}

	public void tablerows() 
		{
					tablerows = UserTable.size();
					System.out.println("Table has" + tablerows +"number of rows");
		}
	
	public void EditButtonClick() {
		
		for(int i=2; i<=tablerows; i++) 
		{
        
			String name = driver.findElement(By.xpath("//table[@class='table table-bordered data_table']/tbody/tr["+i+"]/td[4]")).getText();
	        System.out.println("UserName = "+name);
	    if(name.equalsIgnoreCase("KanchanTest")) {  	
	    	
	       driver.findElement(By.xpath("//table[@class='table table-bordered data_table']/tbody/tr["+i+"]/td[11]/a[6]")).click();
	        System.out.println("You can now edit");
		}
		}
		}
	
	public void emailtxtboxclear()
	{
		this.emailtxtbox.clear();
	}
	
	public void sendnewemail(String email)
	{
		this.emailtxtbox.sendKeys(email);
	}

	public void radiobtnclick() {
		this.inactiveradiobtn.click();
	}
	public void savebtnclk()
	{
		this.savebtn.click();
	}
			
	//*********** For TC 52
	
	public void SsnCtgListClk() {
		this.SsnCtgList.click();
	}
	
	public void addCtgryClck() {
		this.addCtgry.click();
	}
	
	public void CtgryValue(String category) {
		this.Ctgry.sendKeys(category);
	}
	public void addbtnclk() {
		this.addbtn.click();
	}
	
	public void ssnlistclk() {
		this.ssnlist.click();
	}
	
	public void addtrngclk() {
		this.addtrng.click();
	}
	
	public void ssnNameValue(String name)
	{
		this.ssnName.clear();
		this.ssnName.sendKeys(name);
	}
	

	/*public String ctgry(String ctrgy) {	//To pass Category
		ctrgy= this.ctgry(ctrgy);
		return ctrgy;
	}*/
	
	
	public void coachNameSelect(String cch) throws AWTException, InterruptedException 
	{
		this.coachName.click();
		this.coachDrpDown.sendKeys(cch);
		Thread.sleep(3000);
		Robot robo = new Robot();
        robo.keyPress(KeyEvent.VK_DOWN);
        robo.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	public void advncClick()
	{
		this.advnc.click();
	}
	
	public void ssnDrpDwnSlct(String Ctgry) throws AWTException, InterruptedException 
	{
		this.ssnField.click();
		this.ssnDrpdwn.click();
		this.ssnDrpdwn.sendKeys(Ctgry);
		Thread.sleep(3000);
		Robot robo = new Robot();
        robo.keyPress(KeyEvent.VK_DOWN);
        robo.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void nxtStepClk() 
	{
		
		this.nxtStep.click();
	}
	
	public void crsListSlct(String crs) {
		Select sel = new Select(crsList);
		sel.selectByVisibleText(crs);
	}
	
	public void arwSignClc() {
		this.arwSign.click();
	}
	
	public void nextStepClk() {
		this.nextStep.click();
	}
	
	public void subscribeUsrValue(String User) {
		this.subscribeUsr.sendKeys(User);
	}
	 public void selectUser() {
		 Select sel = new Select(userList);
		 sel.selectByIndex(1);
		 
	 }
	 
	 public void finishBtnClk() {
		 this.finishBtn.click();
		 
	 }
		// ********************* For TC 53*****
	 
	 public void reportingTabClick()
	 {
		 this.reportingTab.click();
	 }
	 
	 public void followedStudentsClick()
	 {
		 this.followedStudents.click();
	 }
	 
	 
	 public void studentNameEnter(String Student)
	 {
		 this.studentName.sendKeys(Student);
		 
	 }
	 
	 public void stdntSrchBtnClick()
	 {
		 this.stdntSrchBtn.click();
	 }
	 public void stdntTableRows() 
		{
					stdnttablerows = stdntTable.size();
					System.out.println("Student Table has " + tablerows +" number of rows");
		}
	 
	 
	 public void detailsButtonClick(String desiredUser) {
			
			for(int i=2; i<=stdnttablerows; i++) 
			{
	        
				String name = driver.findElement(By.xpath("//table[@class='table table-bordered data_table']/tbody/tr["+i+"]/td[1]")).getText();
		        System.out.println("UserName = "+name);
		    if(name.equalsIgnoreCase(desiredUser)) {  	
		    	
		       driver.findElement(By.xpath("//table[@class='table table-bordered data_table']/tbody/tr["+i+"]/td[5]/a[2]")).click();
		        System.out.println("Here are " + desiredUser + " Details");
			}
			}
			}
	 
	 public void crsTableRows() 
		{
					crstablerows = crsTable.size();
					System.out.println("Course Table has " + crstablerows +" number of rows");
		}
	 
	 
	 public void crsClick(String stdtCourse) {
			
			for(int i=2; i<=stdnttablerows; i++) 
			{
	        
				String crs = driver.findElement(By.xpath("//table[@class='table table-striped table-hover courses-tracking']/tbody/tr["+i+"]/td[1]")).getText();
				System.out.println("Course = "+crs);
		    if(crs.equalsIgnoreCase(stdtCourse)) {  	
		        driver.findElement(By.xpath("//table[@class='table table-striped table-hover courses-tracking']/tbody/tr["+i+"]/td[7]/a[1]")).click();
		        System.out.println("Here are Quiz Details");
			}
			}
			}
	 	}

	

