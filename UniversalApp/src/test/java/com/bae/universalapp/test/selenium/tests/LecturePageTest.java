package com.bae.universalapp.test.selenium.tests;

import com.bae.universalapp.test.selenium.constants.Constants;
import com.bae.universalapp.test.selenium.pages.LecturePage;

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

    @Before
    public void setup() {
        
        System.setProperty(Constants.PROPERTY, Constants.PATH);
        chromeDriver = new ChromeDriver();

    }

    @Test
    public void firstMethod() throws InterruptedException {
        
        chromeDriver.get("http://3.11.133.109:8181/UniversalApp/lecture-page.html");

        LecturePage lecturePage = PageFactory.initElements(chromeDriver, LecturePage.class);
        lecturePage.submitLectureDetails();
        Thread.sleep(2000);
    }

    @Test
    public void secondMethod() throws InterruptedException {
        chromeDriver.get("http://3.11.133.109:8181/UniversalApp/lecture-page.html");
        LecturePage lecturePage = PageFactory.initElements(chromeDriver, LecturePage.class);
        lecturePage.getContextMenu(chromeDriver);
        lecturePage.updateLecture("lecture 2");
    }

    @Test
    public void thirdMethod() throws InterruptedException {
        chromeDriver.get("http://3.11.133.109:8181/UniversalApp/lecture-page.html");
        LecturePage lecturePage = PageFactory.initElements(chromeDriver, LecturePage.class);
        lecturePage.getContextMenu(chromeDriver);
        lecturePage.deleteLecture();

    }
    
}