package com.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class LoginPageBurgers {

    //локатор поля "Email"
    @FindBy(how = How.XPATH,using = ".//input[@type='text']")
    private SelenideElement emailField;
    //локатор поля "Пароль"
    @FindBy(how = How.XPATH,using = ".//input[@type='password']")
    private SelenideElement passwordField;
    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement loginButtonField;
    //локатор текста "Зарегистрироваться"
    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    private SelenideElement register;
    //локатор текста "Восстановить пароль"
    @FindBy(how = How.LINK_TEXT,using = "Восстановить пароль")
    private SelenideElement recoverPassword;

    //метод заполнения поля "Email"
    public void setEmailField(String email) {
        emailField.shouldBe(exist);
        emailField.setValue(email);
    }
    //метод заполнения поля "Пароль"
    public void setPasswordField(String password) {
        passwordField.shouldBe(exist);
        passwordField.setValue(password);
    }
    //метод клика по кнопке "Войти"
    public void clickLoginButton() {
        loginButtonField.shouldBe(exist);
        loginButtonField.click();
    }
    //метод нахождения кнопки "Войти"
    public boolean isLoginButtonDisplayed() {
        loginButtonField.shouldBe(exist);
        return loginButtonField.isDisplayed();
    }
    //метод заполнения формы объединяет: заполнение поля "Email",
    // заполнение поля "Пароль", метод клика по кнопке "Войти"
    public void fillFormLogin(String email,String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLoginButton();
    }
    //метод клика по тексту "Зарегистрироваться"
    public void clickRegister() {
        loginButtonField.shouldBe(exist);
        register.shouldBe(exist);
        register.click();
    }
    //метод клика по тексту "Восстановить пароль"
    public void clickRecoverPassword() {
        recoverPassword.shouldBe(exist);
        recoverPassword.click();
    }
}