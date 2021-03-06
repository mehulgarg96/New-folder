package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class seleniumCodeClass {

	public static void main(String[] args) {

		String businessPrices = null;
		String payAsYouGoPrices = null;
		String premiumPrices = null;
		String enterprisePrices = null;
		String[] actualPrice = null;
		int passCounter = 0;
		int failCounter = 0;
		WebElement businessPrice = null;
		WebElement payAsYouGoPrice = null;
		WebElement premiumPrice = null;
		WebElement enterprisePrice = null;
		WebElement activeRadioButton = null;
		Properties property = new Properties();
		Properties expectedPrices = new Properties();
		WebDriver driver = null;

		try {
			property.load(new FileInputStream("src/configuration/configuration.properties"));
			expectedPrices.load(new FileInputStream("src/configuration/expectedPrices.properties"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.setProperty("webdriver.chrome.driver", "E:\\workspace\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.manage().window().maximize();
			driver.get("https://callhub.io/pricing/");

			try {
				// Test case 1 starts from here.
				activeRadioButton = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(property.getProperty("monthlyRadioButton"))));
				activeRadioButton.click();

				businessPrice = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(property.getProperty("monthlyBusinessPrice"))));
				businessPrices = businessPrice.getText().trim();

				payAsYouGoPrice = driver.findElement(By.xpath(property.getProperty("payAsYouGoPrice")));
				payAsYouGoPrices = payAsYouGoPrice.getText().trim();

				premiumPrice = driver.findElement(By.xpath(property.getProperty("monthlyPremiumPrice")));
				premiumPrices = premiumPrice.getText().trim();
				enterprisePrice = driver.findElement(By.xpath(property.getProperty("enterprisePrice")));
				enterprisePrices = enterprisePrice.getText().trim();

				if (businessPrices.equals(expectedPrices.getProperty("monthlyBusinessPrice"))
						&& payAsYouGoPrices.equals(expectedPrices.getProperty("monthlyPayAsYouGoPrice"))
						&& premiumPrices.equals(expectedPrices.getProperty("monthlyPremiumPrice"))
						&& enterprisePrices.equals(expectedPrices.getProperty("monthlyEnterprisePrice"))) {
					System.out.println("Test Case 1 passed successfully.");
					System.out.println(
							"The Expected and the Actual Prices for the Monthly Scheme of Call Hub matched Successfully.");
					passCounter++;
				} else {
					System.out.println("Test Case 1 failed.");
					System.out.println(
							"The Expected and the Actual Prices for the Monthly Scheme of Call Hub did not match. Please recheck the pricing chart.");
					failCounter++;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// Test case 2 starts from here.
			try {
				activeRadioButton = driver.findElement(By.xpath(property.getProperty("quaterlyRadioButton")));
				activeRadioButton.click();

				businessPrice = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(property.getProperty("quaterlyBusinessPrice"))));
				businessPrices = businessPrice.getText().trim();
				actualPrice = businessPrices.split("  ");
				businessPrices = actualPrice[0].toString();
				payAsYouGoPrice = driver.findElement(By.xpath(property.getProperty("payAsYouGoPrice")));
				payAsYouGoPrices = payAsYouGoPrice.getText().trim();

				premiumPrice = driver.findElement(By.xpath(property.getProperty("quaterlyPremiumPrice")));
				premiumPrices = premiumPrice.getText().trim();
				actualPrice = premiumPrices.split("  ");
				premiumPrices = actualPrice[0].toString();
				enterprisePrice = driver.findElement(By.xpath(property.getProperty("enterprisePrice")));
				enterprisePrices = enterprisePrice.getText().trim();

				if (businessPrices.equals(expectedPrices.getProperty("quaterlyBusinessPrice"))
						&& payAsYouGoPrices.equals(expectedPrices.getProperty("quaterlyPayAsYouGoPrice"))
						&& premiumPrices.equals(expectedPrices.getProperty("quaterlyPremiumPrice"))
						&& enterprisePrices.equals(expectedPrices.getProperty("quaterlyEnterprisePrice"))) {
					System.out.println("Test Case 2 passed successfully.");
					System.out.println(
							"The Expected and the Actual Prices for the Quaterly Scheme of Call Hub matched Successfully.");
					passCounter++;
				} else {
					System.out.println("Test Case 2 failed.");
					System.out.println(
							"The Expected and the Actual Prices for the Quaterly Scheme of Call Hub did not match. Please recheck the pricing chart.");
					failCounter++;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// Test case 3 starts from here.
			try {
				activeRadioButton = driver.findElement(By.xpath(property.getProperty("halfyearlyRadioButton")));
				activeRadioButton.click();

				businessPrice = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(property.getProperty("halfyearlyBusinessPrice"))));
				businessPrices = businessPrice.getText().trim();
				actualPrice = businessPrices.split("  ");
				businessPrices = actualPrice[0].toString();
				payAsYouGoPrice = driver.findElement(By.xpath(property.getProperty("payAsYouGoPrice")));
				payAsYouGoPrices = payAsYouGoPrice.getText().trim();

				premiumPrice = driver.findElement(By.xpath(property.getProperty("halfyearlyPremiumPrice")));
				premiumPrices = premiumPrice.getText().trim();
				actualPrice = premiumPrices.split("  ");
				premiumPrices = actualPrice[0].toString();
				enterprisePrice = driver.findElement(By.xpath(property.getProperty("enterprisePrice")));
				enterprisePrices = enterprisePrice.getText().trim();

				if (businessPrices.equals(expectedPrices.getProperty("halfyearlyBusinessPrice"))
						&& payAsYouGoPrices.equals(expectedPrices.getProperty("halfyearlyPayAsYouGoPrice"))
						&& premiumPrices.equals(expectedPrices.getProperty("halfyearlyPremiumPrice"))
						&& enterprisePrices.equals(expectedPrices.getProperty("halfyearlyEnterprisePrice"))) {
					System.out.println("Test Case 3 passed successfully.");
					System.out.println(
							"The Expected and the Actual Prices for the Half-Yearly Scheme of Call Hub matched Successfully.");
					passCounter++;
				} else {
					System.out.println("Test Case 3 failed.");
					System.out.println(
							"The Expected and the Actual Prices for the Half-Yearly Scheme of Call Hub did not match. Please recheck the pricing chart.");
					failCounter++;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// Test case 4 starts from here.
			try {
				activeRadioButton = driver.findElement(By.xpath(property.getProperty("yearlyRadioButton")));
				activeRadioButton.click();

				businessPrice = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(property.getProperty("yearlyBusinessPrice"))));
				businessPrice = driver.findElement(By.xpath(property.getProperty("yearlyBusinessPrice")));
				businessPrices = businessPrice.getText().trim();
				actualPrice = businessPrices.split("  ");
				businessPrices = actualPrice[0].toString();
				payAsYouGoPrice = driver.findElement(By.xpath(property.getProperty("payAsYouGoPrice")));
				payAsYouGoPrices = payAsYouGoPrice.getText().trim();

				premiumPrice = driver.findElement(By.xpath(property.getProperty("yearlyPremiumPrice")));
				premiumPrices = premiumPrice.getText().trim();
				actualPrice = premiumPrices.split("  ");
				premiumPrices = actualPrice[0].toString();
				enterprisePrice = driver.findElement(By.xpath(property.getProperty("enterprisePrice")));
				enterprisePrices = enterprisePrice.getText().trim();

				if (businessPrices.equals(expectedPrices.getProperty("yearlyBusinessPrice"))
						&& payAsYouGoPrices.equals(expectedPrices.getProperty("yearlyPayAsYouGoPrice"))
						&& premiumPrices.equals(expectedPrices.getProperty("yearlyPremiumPrice"))
						&& enterprisePrices.equals(expectedPrices.getProperty("yearlyEnterprisePrice"))) {
					System.out.println("Test Case 4 passed successfully.");
					System.out.println(
							"The Expected and the Actual Prices for the Yearly Scheme of Call Hub matched Successfully.");
					passCounter++;
				} else {
					System.out.println("Test Case 4 failed.");
					System.out.println(
							"The Expected and the Actual Prices for the Yearly Scheme of Call Hub did not match. Please recheck the pricing chart.");
					failCounter++;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// Test case 5 starts from here. To Showcase failed scenario.
			try {
				activeRadioButton = driver.findElement(By.xpath(property.getProperty("yearlyRadioButton")));
				activeRadioButton.click();

				businessPrice = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(property.getProperty("yearlyBusinessPrice"))));
				businessPrices = businessPrice.getText().trim();
				actualPrice = businessPrices.split("  ");
				businessPrices = actualPrice[0].toString();
				payAsYouGoPrice = driver.findElement(By.xpath(property.getProperty("payAsYouGoPrice")));
				payAsYouGoPrices = payAsYouGoPrice.getText().trim();

				premiumPrice = driver.findElement(By.xpath(property.getProperty("yearlyPremiumPrice")));
				premiumPrices = premiumPrice.getText().trim();
				actualPrice = premiumPrices.split("  ");
				premiumPrices = actualPrice[0].toString();
				enterprisePrice = driver.findElement(By.xpath(property.getProperty("enterprisePrice")));
				enterprisePrices = enterprisePrice.getText().trim();

				if (businessPrices.equals(expectedPrices.getProperty("halfyearlyBusinessPrice"))
						&& payAsYouGoPrices.equals(expectedPrices.getProperty("yearlyPayAsYouGoPrice"))
						&& premiumPrices.equals(expectedPrices.getProperty("yearlyPremiumPrice"))
						&& enterprisePrices.equals(expectedPrices.getProperty("yearlyEnterprisePrice"))) {
					System.out.println("Test Case 5 passed successfully.");
					System.out.println(
							"The Expected and the Actual Prices for the Yearly Scheme of Call Hub matched Successfully.");
					passCounter++;
				} else {
					System.out.println("Test Case 5 failed.");
					System.out.println(
							"The Expected and the Actual Prices for the Yearly Scheme of Call Hub did not match. Please recheck the pricing chart.");
					failCounter++;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println(
					"=========================================================================================================================");
			System.out.println("Total no. of test cases ran = " + Integer.sum(passCounter, failCounter));
			System.out.println("No. of test cases passed = " + passCounter);
			System.out.println("No. of test cases failed = " + failCounter);
			System.out.println(
					"=========================================================================================================================");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.quit();
		}
	}

}
