package com.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class RegistrationPageBurgers {

    //локатор поля "Имя"
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    private SelenideElement nameField;
    //локатор поля "Email"
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")
    private SelenideElement emailField;
    //локатор поля "Пароль"
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordField;
    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    //локатор текста "Войти"
    @FindBy(how = How.LINK_TEXT,using = "Войти")
    private SelenideElement login;
    //локатор текста "Некорректный пароль"
    @FindBy(how = How.XPATH,using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement unCorrectPassword;

    //метод заполнения поля "Имя"
    public void setNameField(String name) {
        nameField.setValue(name);
    }
    //метод заполнения поля "Email"
    public void setEmailField(String email) {
        emailField.setValue(email);
    }
    //метод заполнения поля "Пароль"
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }
    //метод клика по кнопке "Зарегистрироваться"
    public void clickRegisterButton() {
        registerButton.click();
    }
    //метод заполнения формы объединяет:заполнение поля "Имя", заполнение поля "Email",
    // заполнение поля "Пароль", метод клика по кнопке "Зарегистрироваться"
    public void fillFormRegistration(String name, String email,String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickRegisterButton();
    }
    //метод клика по тексту "Войти"
    public void clickLogin() {
        login.click();
    }
    //метод нахождения текста "Некорректный пароль"
    public boolean isUnCorrectPasswordDisplayed() {
        unCorrectPassword.shouldBe(visible);
        return unCorrectPassword.isDisplayed();
    }
}