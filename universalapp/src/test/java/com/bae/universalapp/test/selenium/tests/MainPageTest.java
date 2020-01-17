package com.bae.universalapp.test.selenium.tests;

import static org.junit.Assert.assertEquals;

import com.bae.universalapp.test.selenium.constants.Constants;
import com.bae.universalapp.test.selenium.pages.Home;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * TestApp
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainPageTest {

    private WebDriver chromeDriver;

    @Before
    public void setup() {
        
        System.setProperty(Constants.PROPERTY, Constants.PATH);
        chromeDriver = new ChromeDriver();
    }

    // Testing create method and page navigation
    @Test
    public void secondMethod() throws InterruptedException {
        chromeDriver.get("http://3.11.133.109:8181/UniversalApp/");
        
        Home homePage = PageFactory.initElements(chromeDriver, Home.class);
        homePage.submitDetails("James Kiesslinger", "Introduction to Thermodynamics", "CHEM 390");
        Thread.sleep(2000);
        homePage.proceedtoModules();
        Thread.sleep(2000);
        homePage.proceedToLectures();
        
        assertEquals("http://3.11.133.109:8181/UniversalApp/lecture-page.html?id=1", this.chromeDriver.getCurrentUrl());
    }

    // Testing update method
    @Test
    public void firstMethod() throws InterruptedException {
        
        chromeDriver.get("http://3.11.133.109:8181/UniversalApp");

        Home homePage = PageFactory.initElements(chromeDriver, Home.class);
        homePage.submitDetails("James Kiesslinger", "Introduction to Data Analysis", "CHEM 300");
        Thread.sleep(2000);
        homePage.getContextMenu(chromeDriver);
        Thread.sleep(2000);
        homePage.updateTeacher("Jess Layton", "CHEM 101", "Introduction to Organic Chemistry");
    }

    // Testing delete method
    @Test
    public void thirdMethod() throws InterruptedException {

        chromeDriver.get("http://3.11.133.109:8181/UniversalApp");

        Home homePage = PageFactory.initElements(chromeDriver, Home.class);
        homePage.getContextMenu(chromeDriver);
        Thread.sleep(2000);
        homePage.deleteTeacher();
    }

    @After
	public void cleanUp() {
        
        chromeDriver.close();
	}
}