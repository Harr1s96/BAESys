package com.bae.universalapp.test.selenium.tests;

import static org.junit.Assert.assertEquals;

import com.bae.universalapp.test.selenium.constants.Constants;
import com.bae.universalapp.test.selenium.pages.HomePageElements;
import com.bae.universalapp.test.selenium.pages.HomePageMethods;

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

    private HomePageElements homePageElements;

    private HomePageMethods homePageMethods;

    @Before
    public void setup() {
        
        System.setProperty(Constants.PROPERTY, Constants.PATH);
        chromeDriver = new ChromeDriver();
        homePageElements = PageFactory.initElements(chromeDriver, HomePageElements.class);
        homePageMethods = new HomePageMethods();
    }

    // Testing create method and page navigation
    @Test
    public void secondMethod() throws InterruptedException {
        
        chromeDriver.get("http://3.11.133.109:8181/UniversalApp/");
        homePageMethods.submitDetails("James Kiesslinger", "Introduction to Thermodynamics", "CHEM 390");
        Thread.sleep(2000);
        homePageMethods.proceedtoModules();
        Thread.sleep(2000);
        homePageMethods.proceedToLectures();
        
        assertEquals("http://3.11.133.109:8181/UniversalApp/lecture-page.html?id=1", this.chromeDriver.getCurrentUrl());
    }

    // Testing update method
    @Test
    public void firstMethod() throws InterruptedException {
        
        chromeDriver.get("http://3.11.133.109:8181/UniversalApp");
        homePageMethods.submitDetails("James Kiesslinger", "Introduction to Data Analysis", "CHEM 300");
        Thread.sleep(2000);
        homePageMethods.getContextMenu(chromeDriver);
        Thread.sleep(2000);
        homePageMethods.updateTeacher("Jess Layton", "CHEM 101", "Introduction to Organic Chemistry");

        assertEquals(true, homePageElements.teacherListElement.isDisplayed());
    }

    // Testing delete method
    @Test
    public void thirdMethod() throws InterruptedException {

        chromeDriver.get("http://3.11.133.109:8181/UniversalApp");
        Thread.sleep(2000);
        homePageMethods.deleteTeacher();
    }

    @After
	public void cleanUp() {
        
        chromeDriver.close();
	}
}