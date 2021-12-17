package assignment;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import utilities.selenium.WebDriverManager;



public class Assignment1 {

	@Test
	public void launchFirefoxBrowser() {
		WebDriver driver;
		WebDriverManager webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("ff");
		driver.get("https://google.co.in");
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.quit();
	}

}