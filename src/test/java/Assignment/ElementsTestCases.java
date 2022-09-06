package Assignment;

import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class ElementsTestCases extends BaseClass {

	private Elements elementsObj;

	Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeTest
	public void testDriver() throws IOException, InterruptedException {

		driver = initializeDriver();
		log.info("Driver is initialized");
		elementsObj = new Elements(driver);

	}

	@Test(priority = 1)
	public void element() throws IOException, InterruptedException {

		elementsObj.goTo();
		log.info("Navigated to the home page");
		elementsObj.elementsPage();
		log.info("Navigated to the elements page");

	}

	@Test(priority = 2)
	public void textBoxTest() throws IOException, InterruptedException {

		elementsObj.textBox();
		log.info("Text information displayed");
	}

	@Test(priority = 3)
	public void checkBoxTest() throws InterruptedException {
		elementsObj.checkBox();
		log.info("CheckBox is selected");
	}

	@Test(priority = 4)
	public void radioBtnTest() {
		elementsObj.radioBtn();
		log.info("Radio Button is selected");
	}

	@Test(priority = 5)
	public void webTableTest() throws InterruptedException {
		elementsObj.webTableSelect("Shreya", "Sharma", "selenium@gmail.com", "20", "500", "computers");
		log.info("New coloumn added to the table");
	}

	@Test(priority = 6)
	public void btnTest() {
		elementsObj.buttonClick();
		log.info("Buttons are clicked");
	}

    @Test(priority = 7)
	public void linkTest() {
		elementsObj.linksPage();

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
