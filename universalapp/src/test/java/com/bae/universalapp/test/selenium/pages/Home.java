package com.bae.universalapp.test.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Home
 */
public class Home {

    @FindBy(xpath = "//*[@id='lecturer']")
    private WebElement teacherInputField;

    @FindBy(xpath = "//*[@id='moduleName']")
    private WebElement moduleNameInputField;

    @FindBy(xpath = "//*[@id='moduleCode']")
    private WebElement moduleCodeInputField;

    @FindBy(xpath = "//*[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "/html/body/div[4]/ul/li")
    private WebElement teacherListElement;

    @FindBy(xpath = "//select[@id='dropdown']")
    private WebElement moduleDropDownList;

    @FindBy(xpath = "/html/body/div[5]/select/option[2]")
    private WebElement optionElement;

    @FindBy(xpath = "//*[@id='teacher-update-button']")
    private WebElement updateTeacherButton;

    @FindBy(xpath = "//*[@id='teacher-delete-button']")
    private WebElement deleteTeacherButton;

    @FindBy(xpath = "//*[@id='update-teacher']")
    private WebElement updateTeacherInputField;

    @FindBy(xpath = "//*[@id='update-module-code']")
    private WebElement updateModuleCodeInputField;

    @FindBy(xpath = "//*[@id='update-module-name']")
    private WebElement updateModuleNameInputField;

    public void submitDetails(String teacherName, String moduleName, String moduleCode) throws InterruptedException {

        teacherInputField.sendKeys(teacherName);
        Thread.sleep(2000);
        moduleNameInputField.sendKeys(moduleName);
        Thread.sleep(2000);
        moduleCodeInputField.sendKeys(moduleCode);
        Thread.sleep(2000);
        submitButton.click();
    }

    public void proceedtoModules() {

        teacherListElement.click();
    }

    public void proceedToLectures() throws InterruptedException {
        
        moduleDropDownList.click();
        Thread.sleep(2000);
        optionElement.click();
    }

    public void getContextMenu(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.contextClick(teacherListElement).perform();
    }

    public void deleteTeacher() {
        
        deleteTeacherButton.click();        
    }

    public void updateTeacher(String teacherName, String moduleCode, String moduleName) throws InterruptedException {

        updateTeacherInputField.sendKeys(teacherName);
        Thread.sleep(2000);
        updateModuleCodeInputField.sendKeys(moduleCode);
        Thread.sleep(2000);
        updateModuleNameInputField.sendKeys(moduleName);
        Thread.sleep(2000);
        updateTeacherButton.click();
    }

}