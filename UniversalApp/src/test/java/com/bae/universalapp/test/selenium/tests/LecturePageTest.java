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
import com.bae.universalapp.test.selenium.pages.LecturePage;

/**
 * LecturePageTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LecturePageTest {

    private WebDriver chromeDriver;

    private final String ADDRESS = "localhost";

    private LecturePage lecturePage;

    @LocalServerPort
    public int port;

    @Before
    public void setup() {
        
        System.setProperty(Constants.PROPERTY, Constants.PATH);
        chromeDriver = new ChromeDriver();
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(true);
        
        chromeDriver = new ChromeDriver(opts);
		lecturePage = PageFactory.initElements(chromeDriver, LecturePage.class);
		chromeDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

    }

    // Testing post and get lecture functionality
    @Test
    public void firstMethod() throws InterruptedException {

        chromeDriver.get("http://" + ADDRESS + ":" + port + "/UniversalApp/"); 
        HomePage homePage = PageFactory.initElements(chromeDriver, HomePage.class);
        
        homePage.submitDetails("James Kiesslinger", "Introduction to Thermodynamics", "CHEM 390");
        Thread.sleep(2000);
        homePage.proceedtoModules();
        Thread.sleep(2000);
        homePage.proceedToLectures();
        lecturePage.submitLectureDetails("lecture 1");

        assertEquals(true, lecturePage.getLectureListElement().isDisplayed());
    }

    // Testing update functionality
    @Test
    public void secondMethod() throws InterruptedException {

        chromeDriver.get("http://" + ADDRESS + ":" + port + "/UniversalApp/lecture-page.html");
        lecturePage.getContextMenu(chromeDriver);
        lecturePage.updateLecture("updated lecture");
    }

    // Testing delete functionality
    @Test
    public void thirdMethod() {

        chromeDriver.get("http://" + ADDRESS + ":" + port +  "/UniversalApp/lecture-page.html");
        lecturePage.getContextMenu(chromeDriver);
        lecturePage.deleteLecture();
    }

    @After
    public void cleanUp() {

        chromeDriver.close();
    }
    
}