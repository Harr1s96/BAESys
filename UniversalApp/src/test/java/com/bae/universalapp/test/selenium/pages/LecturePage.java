package com.bae.universalapp.test.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


/**
 * LecturePage
 */
public class LecturePage {

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

    private WebDriver driver;
    
    public LecturePage(WebDriver driver) {
        this.driver = driver;
    }
    
    /**
     * @return the deleteLectureButton
     */
    public WebElement getDeleteLectureButton() {
        return deleteLectureButton;
    }

    /**
     * @return the lectureInputField
     */
    public WebElement getLectureInputField() {
        return lectureInputField;
    }

    /**
     * @return the lectureListElement
     */
    public WebElement getLectureListElement() {
        return this.driver.findElement(By.xpath("/html/body/div[3]/ul/li"));
    }

    /**
     * @return the lectureSubmitButton
     */
    public WebElement getLectureSubmitButton() {
        return lectureSubmitButton;
    }

    /**
     * @return the updateLectureButton
     */
    public WebElement getUpdateLectureButton() {
        return updateLectureButton;
    }

    /**
     * @return the updateLectureInputField
     */
    public WebElement getUpdateLectureInputField() {
        return updateLectureInputField;
    }

    /**
     * @param deleteLectureButton the deleteLectureButton to set
     */
    public void setDeleteLectureButton(WebElement deleteLectureButton) {
        this.deleteLectureButton = deleteLectureButton;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param lectureInputField the lectureInputField to set
     */
    public void setLectureInputField(WebElement lectureInputField) {
        this.lectureInputField = lectureInputField;
    }

    /**
     * @param lectureListElement the lectureListElement to set
     */
    public void setLectureListElement(WebElement lectureListElement) {
        this.lectureListElement = lectureListElement;
    }

    public void submitLectureDetails(String lectureName) {

        lectureInputField.sendKeys(lectureName);
        lectureSubmitButton.click();
    }

    public void getContextMenu(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.contextClick(getLectureListElement()).perform();
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