package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

public class BalanceDetail {

	public xxxBalanceDetail(WebDriver driver) {
		this.driver = driver;
		totalBalance = 0f;
		calculatedTotal = 0f;
	}

	public void balanceChecking() {
		
		for (int i = 1; i < 7; i++) {
		
			// Test 1: check right count of values appear
			WebElement element = driver.findElement(By.id("txt_val_" + i));
			assertNotNull(element);
			
			String elementStr = element.getAttribute("value");
			assertNotNull(elementStr);
						
			// Test 2: check values are in currency format
			float value = getFloatCurrency(elementStr);
			
			// Test 3: check values greater than 0
			assertTrue(Math.abs(value) > 0.000001);
			
			if (i != 6) {
				calculatedTotal += value;
			} else {
				totalBalance = value;
			}
		}
		
		// Test 4: verify balanced calculated matches total balance
		assertTrue(Math.abs(calculatedTotal - totalBalance) < 0.000001);
		//assertTrue(Math.abs(calculatedTotal - totalBalance + 3000) < 0.000001);
	}
	
	// check value format as "$122,365.24" and return float value
	public float getFloatCurrency(String currency) {
		assertTrue(currency.charAt(0) == '$');
		assertEquals(currency.lastIndexOf('.'), currency.length() - 3);
		
		currency = currency.replace("$", "");
		currency = currency.replaceAll(",", "");
		
		return (Float.parseFloat(currency));
	}
	
	
	private WebDriver driver;
	private float totalBalance;
	private float calculatedTotal;
}
