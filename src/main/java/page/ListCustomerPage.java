package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ListCustomerPage extends BasePage {

	WebDriver driver;
	
	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div[2]/button[2]") WebElement OK_DELETE_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]") WebElement SEARCH_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement ADD_CUSTOMER_BUTTON;
	
 	//tbody/tr[1]/td[3]/a
 	//tbody/tr[1]/td[7]/a[2]
	//tbody/tr[1]/td[7]/a[1]
 	
 	String before_xpath = "//tbody/tr[";
 	String after_xpath = "]/td[3]/a";
 	String delete_xpath = "]/td[7]/a[2]";
 	String search_xpath = "]/td[7]/a[1]";
 	
 	public void validateInsertAndDelete() {
 		for(int i=1; i<=5; i++) {
 			String nameFromList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
 			if(nameFromList.contains(AddCustomerPage.insertName)) {
 				driver.findElement(By.xpath(before_xpath + i + delete_xpath)).click();
 				OK_DELETE_BUTTON.click();
 			}
 		}
 	}
	public void validateListCustomerPage() {
		Assert.assertTrue(ADD_CUSTOMER_BUTTON.isDisplayed(), "List Page is not available." );
		}
	public void clickAddCustomerButton() {
		ADD_CUSTOMER_BUTTON.click();
	}
	public void clickonSearchBar() {
		SEARCH_FIELD.sendKeys(AddCustomerPage.getInsertName());
	}
	
	public void validateInsertedNameonSearchBarAndProfPage() {
		for(int i=1; i<=5; i++) {
 			String nameFromList = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
 			if(nameFromList.contains(AddCustomerPage.getInsertName()))
 			System.out.println("Name is there!");
 			driver.findElement(By.xpath(before_xpath + i + search_xpath)).click();
 			break;
 			}
	}
	}
