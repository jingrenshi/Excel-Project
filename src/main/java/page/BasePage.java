package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


	public void waitForElement(WebDriver driver, int waitTimeInSecond, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecond);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		
	public int generateRandomNumber(int boundaryNumber) {
		Random random = new Random();
		return random.nextInt(boundaryNumber);
	}
	

	public void selectDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);	
	}
}
