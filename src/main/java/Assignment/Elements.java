package Assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Elements {

	public WebDriver driver;

	public Elements(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "// h5[text()='Elements']")
	public WebElement elementTab;

	@FindBy(xpath = "//span[text()='Text Box']")
	public WebElement textBox;

	@FindBy(id = "userForm")
	public WebElement userForm;

	@FindBy(id = "userName")
	public WebElement uName;

	@FindBy(id = "userEmail")
	public WebElement uEmail;

	@FindBy(id = "currentAddress")
	public WebElement currentAdd;

	@FindBy(id = "permanentAddress")
	public WebElement permanentAdd;

	@FindBy(id = "submit")
	public WebElement submitBtn;

	@FindBy(xpath = "//span[text()='Check Box']")
	public WebElement checkBtn;

	@FindBy(xpath = "//*[@id=\"output\"]")
	public WebElement submitOutput;

	@FindBy(xpath = "//span[text()='Radio Button']")
	public WebElement radioBtnClick;

	@FindBy(xpath = "//button[@title='Expand all']")
	public WebElement expandAll;

	@FindBy(css = "button.rct-collapse-btn")
	public List<WebElement> expand_home;

	@FindBy(xpath = "//*[@id=\"result\"]")
	public WebElement output_text;

	@FindBy(css = ".rct-checkbox")
	public List<WebElement> home_checkBox;

	@FindBy(xpath = "//label[text()='Impressive']")
	public WebElement radioBtnImp;

	@FindBy(xpath = "//label[text()='Yes']")
	public WebElement radioBtnYes;

	@FindBy(id = "noRadio")
	public WebElement noRadio;

	@FindBy(css = "p.mt-3")
	public WebElement output_radioText;

	@FindBy(xpath = "//span[text()='Web Tables']")
	public WebElement webTables;

	@FindBy(id = "addNewRecordButton")
	public WebElement addBtn;

	@FindBy(id = "firstName")
	public WebElement wt_name;

	@FindBy(id = "lastName")
	public WebElement wt_lname;

	@FindBy(id = "userEmail")
	public WebElement wt_email;

	@FindBy(id = "age")
	public WebElement wt_age;

	@FindBy(id = "salary")
	public WebElement wt_salary;

	@FindBy(id = "department")
	public WebElement wt_dpt;

	@FindBy(id = "submit")
	public WebElement wt_submit;

	@FindBy(id = "delete-record-1")
	public WebElement deleteButton;

	@FindBy(id = "searchBox")
	public WebElement searchTextBox;

	@FindBy(xpath = "//div[.='No rows found']")
	public WebElement noRowsText;

	@FindBy(id = "edit-record-1")
	public WebElement editButton;

	@FindBy(xpath = "//div[@class='rt-tr -odd']")
	public WebElement tableCol;

	@FindBy(id = "item-4")
	public WebElement btn_click;

	@FindBy(id = "doubleClickBtn")
	public WebElement double_click;

	@FindBy(id = "rightClickBtn")
	public WebElement right_click;

	@FindBy(xpath = "(//div/button)[3]")
	public WebElement click;

	@FindBy(id = "doubleClickMessage")
	public WebElement doubleClick_msg;

	@FindBy(id = "rightClickMessage")
	public WebElement rightClick_msg;

	@FindBy(id = "dynamicClickMessage")
	public WebElement click_msg;

	@FindBy(xpath = "//div[@class='rt-tr -even']")
	public List<WebElement> newcol_add;

	@FindBy(xpath = "//span[text()='Links']")
	public WebElement links_page;

	@FindBy(id = "created")
	public WebElement error_link;

	@FindBy(xpath = "//*[@id=\"linkResponse\"]")
	public WebElement link_resp;

	public void goTo() {

		driver.get("https://demoqa.com/");

	}

	public void elementsPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", elementTab);
		textBox.click();
        
	}

	public void textBox() throws IOException, InterruptedException {

		String expectedFullName = "Shreya Sharma";
		String expectedEmail = "shreya@gmail.com";
		String expectedCurrentAddress = "Street:1234,JawaharColony";
		String expectedPermanentAddress = "Street:1234,JawaharColony";

		uName.sendKeys(expectedFullName);
		uEmail.sendKeys(expectedEmail);
		currentAdd.sendKeys(expectedCurrentAddress);
		permanentAdd.sendKeys(expectedPermanentAddress);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", submitBtn);

		String submitOutputText = submitOutput.getText();

		ArrayList<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add(expectedFullName);
		expectedOutput.add(expectedEmail);
		expectedOutput.add(expectedCurrentAddress);
		expectedOutput.add(expectedPermanentAddress);

		for (String output : expectedOutput) {

			Assert.assertTrue(submitOutputText.contains(output));
		}

	}

	public void checkBox() throws InterruptedException {

		checkBtn.click();
		expand_home.get(0).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(home_checkBox));

		home_checkBox.get(0).click();
		Assert.assertTrue(output_text.isDisplayed());
		home_checkBox.get(0).click();

		expand_home.get(1).click();
		home_checkBox.get(1).click();
		Assert.assertTrue(output_text.isDisplayed());
		expand_home.get(1).click();

		expand_home.get(2).click();
		home_checkBox.get(2).click();
		Assert.assertTrue(output_text.isDisplayed());
		expand_home.get(2).click();

		expand_home.get(3).click();
		home_checkBox.get(3).click();
		Assert.assertTrue(output_text.isDisplayed());
		expand_home.get(3).click();

	}

	public void radioBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", radioBtnClick);

		if (radioBtnYes.isSelected()) {
			radioBtnYes.click();
			String expected_yesOutputText = "You have selected Yes";
			String actual_yesOutputText = output_radioText.getText();
			Assert.assertEquals(expected_yesOutputText, actual_yesOutputText);

		} else if (radioBtnImp.isSelected()) {
			radioBtnImp.click();
			String expected_ImpOutputText = "You have selected Impressive";
			String actual_ImpOutputText = output_radioText.getText();
			Assert.assertEquals(expected_ImpOutputText, actual_ImpOutputText);
		}

	}

	public void webTableSelect(String name, String lname, String wtemail, String age, String salary, String dpt)
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", webTables);

		addBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElements(wt_name));

		Assert.assertTrue(addBtn.isDisplayed());

		wt_name.sendKeys(name);
		wt_lname.sendKeys(lname);
		wt_email.sendKeys(wtemail);
		wt_age.sendKeys(age);
		wt_salary.sendKeys(salary);
		wt_dpt.sendKeys(dpt);
		wt_submit.click();

		ArrayList<String> expected_wtAdd = new ArrayList<String>();
		expected_wtAdd.add(name);
		expected_wtAdd.add(lname);
		expected_wtAdd.add(wtemail);
		expected_wtAdd.add(age);
		expected_wtAdd.add(salary);
		expected_wtAdd.add(dpt);

		newcol_add.get(1).getText();
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.visibilityOfAllElements(deleteButton));
		deleteButton.click();
		searchTextBox.sendKeys("Cierra");
		Assert.assertTrue(noRowsText.isDisplayed());
		searchTextBox.clear();

	}

	public void buttonClick() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btn_click);

		Actions actions = new Actions(driver);

		actions.doubleClick(double_click).perform();
		Assert.assertTrue(doubleClick_msg.isDisplayed());

		actions.contextClick(right_click).perform();
		Assert.assertTrue(rightClick_msg.isDisplayed());

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.visibilityOfAllElements(right_click));

		// actions.click(click).perform();
		actions.click(click);
		Assert.assertTrue(click_msg.isDisplayed());

	}

	public void linksPage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", links_page);
		error_link.click();
		String expect = "Link has responded with staus 201 and status text";
		String actual = link_resp.getText();
		Assert.assertEquals(expect, actual);

	}

}
