package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("testData\\testData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignin();
		
		DashboardPage dashboardPage = PageFactory.initElements( driver, DashboardPage.class);
		dashboardPage.verifDashboardHeader();
		
		BrowserFactory.tearDown();
	}
}
