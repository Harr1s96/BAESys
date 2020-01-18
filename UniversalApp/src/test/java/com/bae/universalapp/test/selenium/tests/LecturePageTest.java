package com.bae.universalapp.test.selenium.tests;

import static org.junit.Assert.assertEquals;

import com.bae.universalapp.test.selenium.constants.Constants;
import com.bae.universalapp.test.selenium.pages.HomePageElements;
import com.bae.universalapp.test.selenium.pages.HomePageMethods;
import com.bae.universalapp.test.selenium.pages.LecturePageElements;
import com.bae.universalapp.test.selenium.pages.LecturePageMethods;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * LecturePageTest
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LecturePageTest {

    private WebDriver chromeDriver;

    private LecturePageElements lecturePageElements;

    private LecturePageMethods lecturePageMethods;

    @Before
    public void setup() {

        System.setProperty(Constants.PROPERTY, Constants.PATH);
        chromeDriver = new ChromeDriver();
        lecturePageElements = PageFactory.initElements(chromeDriver, LecturePageElements.class);
        lecturePageMethods = new LecturePageMethods();
    }

    // Testing post and get lecture functionality
    @Test
    public void firstMethod() throws InterruptedException {

        chromeDriver.get("http://3.11.133.109:8181/UniversalApp/"); 
        HomePageElements homePageElements = PageFactory.initElements(chromeDriver, HomePageElements.class);
        HomePageMethods homePageMethods = new HomePageMethods();
        
        homePageMethods.submitDetails("James Kiesslinger", "Introduction to Thermodynamics", "CHEM 390");
        Thread.sleep(2000);
        homePageMethods.proceedtoModules();
        Thread.sleep(2000);
        homePageMethods.proceedToLectures();
        lecturePageMethods.submitLectureDetails("lecture 1");

        assertEquals(true, lecturePageElements.lectureListElement.isDisplayed());
    }

    // Testing update functionality
    @Test
    public void secondMethod() throws InterruptedException {

        chromeDriver.get("http://3.11.133.109:8181/UniversalApp/lecture-page.html");
        lecturePageMethods.getContextMenu(chromeDriver);
        lecturePageMethods.updateLecture("updated lecture");
    }

    // Testing delete functionality
    @Test
    public void thirdMethod() {

        chromeDriver.get("http://3.11.133.109:8181/UniversalApp/lecture-page.html");
        lecturePageMethods.getContextMenu(chromeDriver);
        lecturePageMethods.deleteLecture();
    }

    @After
    public void cleanUp() {

        chromeDriver.close();
    }
    
}