package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.selenium.WebDriverManager;



public class Assignment2 {
	
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	SoftAssert sf;
	
	@BeforeClass
	public void setUp() {
	webDrvMgr = new WebDriverManager();
	driver = webDrvMgr.launchBrowser("chrome");
	wait = new WebDriverWait(driver, 120);
	driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	@BeforeMethod
	public void testPreReq() {
	sf = new SoftAssert();
	}

	
	@Test
	public void checkBoxDemoTest() throws InterruptedException {
		WebElement checkBox=driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
		checkBox.click();
		WebElement oTypeBox = driver.findElement(By.xpath("//div[@id='txtAge']"));
		String innerText=oTypeBox.getText();
		sf.assertEquals(innerText, "Success - Check box is checked");
		System.out.println("SUCCESS TEXT IS- "+innerText);
		checkBox.click();
		sf.assertNotEquals(innerText, "");
		sf.assertAll();
		

	}
	
	@Test
	public void multipleCheckBoxDemoTest(){
		WebElement multipleCheckBox=driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		multipleCheckBox.click();
		WebElement oTypeBox1 = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		String attribText=oTypeBox1.getAttribute("value");
		sf.assertEquals(attribText, "Uncheck All");
		sf.assertAll();
		
		
	}
	
	@AfterClass
	public void tearDown() {
	driver.quit();
	}

}