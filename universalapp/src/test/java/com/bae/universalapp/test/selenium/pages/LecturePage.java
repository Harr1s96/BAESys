package com.bae.universalapp.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LecturePage
 */
public class LecturePage {

    @FindBy(xpath = "//input[id='lecture']")
    private WebElement lectureInputField;

    @FindBy(xpath = "//button[id='submit'")
    private WebElement lectureSubmitButton;

    public void enterLectureDetails() {

        lectureInputField.sendKeys("Lecture 1");
    }

    public void submitLectureDetails() {
        
        lectureSubmitButton.click();
    }
    
}