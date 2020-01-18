package com.bae.universalapp.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LecturePageElements
 */
public class LecturePageElements {

    @FindBy(xpath = "//*[@id='lecture']")
    public WebElement lectureInputField;

    @FindBy(xpath = "//*[@id='submit']")
    public WebElement lectureSubmitButton;

    @FindBy(xpath = "/html/body/div[3]/ul/li")
    public WebElement lectureListElement;

    @FindBy(xpath = "//*[@id='update-lecture']")
    public WebElement updateLectureInputField;

    @FindBy(xpath = "//*[@id='update-button']")
    public WebElement updateLectureButton;

    @FindBy(xpath = "//*[@id='delete-button']")
    public WebElement deleteLectureButton;

    public LecturePageElements() {

    }

}