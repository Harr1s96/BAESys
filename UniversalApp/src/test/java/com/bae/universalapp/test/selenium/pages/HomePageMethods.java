package com.bae.universalapp.test.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.bae.universalapp.test.selenium.pages.HomePageElements;

/**
 * Home
 */
public class HomePageMethods {

    HomePageElements elements;

    public void submitDetails(String teacherName, String moduleName, String moduleCode) throws InterruptedException {

        elements.teacherInputField.sendKeys(teacherName);
        Thread.sleep(2000);
        elements.moduleNameInputField.sendKeys(moduleName);
        Thread.sleep(2000);
        elements.moduleCodeInputField.sendKeys(moduleCode);
        Thread.sleep(2000);
        elements.submitButton.click();
    }

    public void proceedtoModules() {

        elements.teacherListElement.click();
    }

    public void proceedToLectures() throws InterruptedException {
        
        elements.moduleDropDownList.click();
        Thread.sleep(2000);
        elements.optionElement.click();
    }

    public void getContextMenu(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.contextClick(elements.teacherListElement).perform();
    }

    public void deleteTeacher() {
        
        elements.deleteTeacherButton.click();        
    }

    public void updateTeacher(String teacherName, String moduleCode, String moduleName) throws InterruptedException {

        elements.updateTeacherInputField.sendKeys(teacherName);
        Thread.sleep(2000);
        elements.updateModuleCodeInputField.sendKeys(moduleCode);
        Thread.sleep(2000);
        elements.updateModuleNameInputField.sendKeys(moduleName);
        Thread.sleep(2000);
        elements.updateTeacherButton.click();
    }

}