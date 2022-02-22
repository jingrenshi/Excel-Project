package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import net.bytebuddy.asm.Advice.OffsetMapping.Target.AbstractReadOnlyAdapter;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		driver = this.driver;
	}

	// element list
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]")
	WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]")
	WebElement CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]")
	WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'List Customers')]")
	WebElement LIST_CUSTOMER_ELEMENT;

	public void verifDashboardHeader() {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard", "DashboardPage not found!");
	}

	public void clickCustomerButton() {
		CUSTOMER_ELEMENT.click();
	}

	public void clickAddCustomerButton() {
		ADD_CUSTOMER_ELEMENT.click();
	}
	
	public void clickListCustomerButton() throws InterruptedException {
		Thread.sleep(5000);
		LIST_CUSTOMER_ELEMENT.click();
		Thread.sleep(9000);
	}

}
