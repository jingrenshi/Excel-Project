package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		driver = this.driver;
	}
	
	//Element List
	@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'Add Contact')]")
	WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@name = 'cid']")
	WebElement COMPANY_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SUBMIT_BUTTON_ELEMENT;
	
	public void verifyAddContactPage() {
		waitForElement(driver, 10, ADD_CONTACT_HEADER_ELEMENT);
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), "Add Contact", "AddContact Page Not Found!!");
	}
	

	String enteredName;
	public void insertFullName(String fullName) {
		int generatedNumber = generateRandomNumber(999);
		enteredName = fullName + generatedNumber;
		FULL_NAME_ELEMENT.sendKeys(enteredName);
	}
	

	public void insertCompany(String company) {
		selectDropdown(COMPANY_NAME_ELEMENT, company);
	}
	

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNumber(999) + email);
	}
	
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandomNumber(999));
	}
	
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	
	public void insertCountry(String country) {
		selectDropdown(COUNTRY_ELEMENT, country);
	}
	
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	
	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}
	
	public void clickSubmitButton() {
		SUBMIT_BUTTON_ELEMENT.click();
	}
	
	//tbody//tr[i]//td[3]
	//tbody//tr[1]//td[3]
	//tbody//tr[2]//td[3]
	//tbody//tr[3]//td[3]
	//tbody//tr[4]//td[3]
	String before_xpath = "//tbody//tr[";
	String after_xpath = "]//td[3]";
	
	public void verifyEnteredName() {
		
		for(int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			Assert.assertEquals(name, enteredName, "Wrong name!!!");
			break;
		}
	}		
}
