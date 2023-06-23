package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.BasePage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;


public class ListCustomerTest {

	WebDriver driver;
	
	@Test
	@Parameters({"username","password","name","company","email","phone","address","city","state","zip","country"})
	public void userShouldBeAbleAddCustomerFromListCustomer(String username, String password, String name, String company, String email, String phone, String address, String city, String state, String zip, String country) throws InterruptedException {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername(username);
		loginPage.insertPassword(password);
		loginPage.clickSubmit();
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		Thread.sleep(2000);
		dashboardPage.clickOnCustomerMenu();
		dashboardPage.clickonListCustMenu();
		
		ListCustomerPage listCustPage = PageFactory.initElements(driver, ListCustomerPage.class);
		listCustPage.validateListCustomerPage();
		Thread.sleep(2000);
		listCustPage.clickAddCustomerButton();
		
	
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage();
		Thread.sleep(2000);
		addCustomerPage.insertFullName(name);
		addCustomerPage.selectCompanyName(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhoneNum(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountryName(country);
		addCustomerPage.clickonSubmit();
		
		dashboardPage.clickonListCustMenu();
		Thread.sleep(2000);
		listCustPage.clickonSearchBar();
		listCustPage.validateInsertedNameonSearchBarAndProfPage();
//		listCustPage.validateInsertAndDelete();
		
	}
	
}
