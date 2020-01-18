package com.bae.universalapp.test.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * HomePage
 */
public class HomePage {

	@FindBy(xpath = "//*[@id='lecturer']")
	private WebElement teacherInputField;

	@FindBy(id = "moduleName")
	private WebElement moduleNameInputField;

	@FindBy(xpath = "//*[@id='moduleCode']")
	private WebElement moduleCodeInputField;

	@FindBy(xpath = "//*[@id='submit']")
	private WebElement submitButton;

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

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getTeacherInputField() {
		return teacherInputField;
	}

	public void setTeacherInputField(WebElement teacherInputField) {
		this.teacherInputField = teacherInputField;
	}

	public WebElement getModuleNameInputField() {
		return moduleNameInputField;
	}

	public void setModuleNameInputField(WebElement moduleNameInputField) {
		this.moduleNameInputField = moduleNameInputField;
	}

	public WebElement getModuleCodeInputField() {
		return moduleCodeInputField;
	}

	public void setModuleCodeInputField(WebElement moduleCodeInputField) {
		this.moduleCodeInputField = moduleCodeInputField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}

	public WebElement getModuleDropDownList() {
		return moduleDropDownList;
	}

	public void setModuleDropDownList(WebElement moduleDropDownList) {
		this.moduleDropDownList = moduleDropDownList;
	}

	public WebElement getOptionElement() {
		return optionElement;
	}

	public void setOptionElement(WebElement optionElement) {
		this.optionElement = optionElement;
	}

	public WebElement getUpdateTeacherButton() {
		return updateTeacherButton;
	}

	public void setUpdateTeacherButton(WebElement updateTeacherButton) {
		this.updateTeacherButton = updateTeacherButton;
	}

	public WebElement getDeleteTeacherButton() {
		return deleteTeacherButton;
	}

	public void setDeleteTeacherButton(WebElement deleteTeacherButton) {
		this.deleteTeacherButton = deleteTeacherButton;
	}

	public WebElement getUpdateTeacherInputField() {
		return updateTeacherInputField;
	}

	public void setUpdateTeacherInputField(WebElement updateTeacherInputField) {
		this.updateTeacherInputField = updateTeacherInputField;
	}

	public WebElement getUpdateModuleCodeInputField() {
		return updateModuleCodeInputField;
	}

	public void setUpdateModuleCodeInputField(WebElement updateModuleCodeInputField) {
		this.updateModuleCodeInputField = updateModuleCodeInputField;
	}

	public WebElement getUpdateModuleNameInputField() {
		return updateModuleNameInputField;
	}

	public void setUpdateModuleNameInputField(WebElement updateModuleNameInputField) {
		this.updateModuleNameInputField = updateModuleNameInputField;
	}

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

		getTeacherListElement().click();
	}

	public void proceedToLectures() throws InterruptedException {

		moduleDropDownList.click();
		Thread.sleep(2000);
		optionElement.click();
	}

	public void getContextMenu(WebDriver driver) {

		Actions actions = new Actions(driver);
		actions.contextClick(getTeacherListElement()).perform();
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

	public WebElement getTeacherListElement() {
		return this.driver.findElement(By.xpath(".list-group-item"));
	}

}