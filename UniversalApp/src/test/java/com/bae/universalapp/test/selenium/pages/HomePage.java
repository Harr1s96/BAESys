package com.bae.universalapp.test.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HomePageElements
 */
public class HomePageElements {

    @FindBy(xpath = "//*[@id='lecturer']")
    public  WebElement teacherInputField;

    @FindBy(xpath = "//*[@id='moduleName']")
    public  WebElement moduleNameInputField;

    @FindBy(xpath = "//*[@id='moduleCode']")
    public  WebElement moduleCodeInputField;

    @FindBy(xpath = "//*[@id='submit']")
    public  WebElement submitButton;

    @FindBy(xpath = "/html/body/div[4]/ul/li")
    public  WebElement teacherListElement;

    @FindBy(xpath = "//select[@id='dropdown']")
    public  WebElement moduleDropDownList;

    @FindBy(xpath = "/html/body/div[5]/select/option[2]")
    public  WebElement optionElement;

    @FindBy(xpath = "//*[@id='teacher-update-button']")
    public  WebElement updateTeacherButton;

    @FindBy(xpath = "//*[@id='teacher-delete-button']")
    public  WebElement deleteTeacherButton;

    @FindBy(xpath = "//*[@id='update-teacher']")
    public  WebElement updateTeacherInputField;

    @FindBy(xpath = "//*[@id='update-module-code']")
    public  WebElement updateModuleCodeInputField;

    @FindBy(xpath = "//*[@id='update-module-name']")
    public  WebElement updateModuleNameInputField;

    public HomePageElements() {
        
    }
}