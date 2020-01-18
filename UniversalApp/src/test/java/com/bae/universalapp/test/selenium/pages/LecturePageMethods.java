package com.bae.universalapp.test.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.bae.universalapp.test.selenium.pages.LecturePageElements;

/**
 * LecturePage
 */
public class LecturePageMethods {

    LecturePageElements elements;

    public void submitLectureDetails(String lectureName) {

        elements.lectureInputField.sendKeys(lectureName);
        elements.lectureSubmitButton.click();
    }

    public void getContextMenu(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.contextClick(elements.lectureListElement).perform();
    }

    public void updateLecture(String lectureName) throws InterruptedException {
        
        elements.updateLectureInputField.sendKeys(lectureName);
        Thread.sleep(2000);
        elements.updateLectureButton.click(); 
    }

    public void deleteLecture() {

        elements.deleteLectureButton.click();
    }

    
}