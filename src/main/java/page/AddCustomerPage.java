package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage{
	
WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5") WebElement ADD_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_DPDWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]") WebElement COUNTRY_DPDWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]") WebElement SAVE_BUTTON_ELEMENT;

	public void validateAddCustomerPage(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
		validateElement(ADD_CUSTOMER_HEADER_ELEMENT.getText(), expectedText, "Add Customer page is not available!!");
	}
	
	String insertedName; 
	public void insertFullName(String fullName) {
		insertedName = fullName + randomNumGenerator(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}
	
	public void selectCompanyName(String company) {
		selectFromDropdown(COMPANY_DPDWN_ELEMENT, company);
	}
	
	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(randomNumGenerator(999) + email);
	}
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + randomNumGenerator(999));
	}
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}
	public void insertCountry(String country) {
		selectFromDropdown(COUNTRY_DPDWN_ELEMENT, country);
	}
	public void clickOnSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}
	
	//tbody/tr[1]/td[3]/a
	//tbody/tr[2]/td[3]/a
	//tbody/tr[3]/td[3]/a
	//tbody/tr[i]/td[3]/a
	//tbody/tr[1]/td[7]/a[2]
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	String after_xpath_delete = "]/td[7]/a[2]";
	
	public void validateInsertedNameAndDelete() throws InterruptedException {
		for(int i = 1; i <= 10; i++) {
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(actualName);
			if(actualName.contains(insertedName)) {
				System.out.println("Inserted name exist.");
				Thread.sleep(2000);
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
			break;
		}
	}
	
	
	
}
