package com.bae.universalapp.test.selenium.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.universalapp.test.selenium.constants.Constants;
import com.bae.universalapp.test.selenium.pages.HomePage;

/**
 * MainPageTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainPageTest {

	private WebDriver chromeDriver;

	// "3.11.133.109";
	private final String ADDRESS = "localhost";

	private HomePage homePage;

	@LocalServerPort
	private int port;

	@Before
	public void setup() {

		System.setProperty(Constants.PROPERTY, Constants.PATH);
		ChromeOptions opts = new ChromeOptions();
		opts.setHeadless(true);
		
		chromeDriver = new ChromeDriver(opts);
		homePage = PageFactory.initElements(chromeDriver, HomePage.class);
		chromeDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
	}

	// Testing create method and page navigation
	@Test
	public void secondMethod() throws InterruptedException {

		chromeDriver.get("http://" + ADDRESS + ":" + port + "/UniversalApp/");
		homePage.submitDetails("James Kiesslinger", "Introduction to Thermodynamics", "CHEM 390");

		homePage.proceedtoModules();

		homePage.proceedToLectures();

		assertEquals("http://" + ADDRESS + ":" + port + "/UniversalApp/lecture-page.html?id=1",
				this.chromeDriver.getCurrentUrl());
	}

	// Testing update method
	@Test
	public void firstMethod() throws InterruptedException {

		chromeDriver.get("http://" + ADDRESS + ":" + port + "/UniversalApp");
		homePage.submitDetails("James Kiesslinger", "Introduction to Data Analysis", "CHEM 300");

		homePage.getContextMenu(chromeDriver);

		homePage.updateTeacher("Jess Layton", "CHEM 101", "Introduction to Organic Chemistry");

		assertEquals(true, homePage.getTeacherListElement().isDisplayed());
	}

	// Testing delete method
	@Test
	public void thirdMethod() throws InterruptedException {
		chromeDriver.get("http://" + ADDRESS + ":" + port + "/UniversalApp");
		homePage.deleteTeacher();
	}

	@After
	public void cleanUp() {

		chromeDriver.close();
	}
}