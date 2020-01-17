package com.bae.universalapp.test.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * LecturePage
 */
public class LecturePage {

    @FindBy(xpath = "//input[id='lecture']")
    private WebElement lectureInputField;

    @FindBy(xpath = "//button[id='submit'")
    private WebElement lectureSubmitButton;

    @FindBy(xpath = "/html/body/div[3]/ul/li")
    private WebElement lectureListElement;

    @FindBy(xpath = "//*[@id='update-lecture']")
    private WebElement updateLectureInputField;

    @FindBy(xpath = "//*[@id='update-button']")
    private WebElement updateLectureButton;

    @FindBy(xpath = "//*[@id='delete-button']")
    private WebElement deleteLectureButton;

    public void submitLectureDetails() {

        lectureInputField.sendKeys("Lecture 1");
        lectureSubmitButton.click();
    }

    public void getContextMenu(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.contextClick(lectureListElement).perform();
    }

    public void updateLecture(String lectureName) throws InterruptedException {
        
        updateLectureInputField.sendKeys(lectureName);
        Thread.sleep(2000);
        updateLectureButton.click(); 
    }

    public void deleteLecture() {

        deleteLectureButton.click();
    }

    
}