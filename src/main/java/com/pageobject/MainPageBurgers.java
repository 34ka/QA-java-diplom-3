package com.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class MainPageBurgers {

    //главная страница тестового стенда Бургеры
    public static final String homePageBurgers = ("https://stellarburgers.nomoreparties.site/");

    //локатор кнопки "Личный Кабинет"
    @FindBy(how = How.LINK_TEXT,using = "Личный Кабинет")
    private SelenideElement personalAccountButton;
    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;
    //локатор раздела "Начинки"
    @FindBy(how = How.XPATH,using = ".//span[text()='Начинки']")
    private SelenideElement filling;
    //локатор заголовка "Начинки"
    @FindBy(how = How.XPATH,using = ".//h2[text()='Начинки']")
    private SelenideElement headerFilling;
    //локатор раздела "Соусы"
    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement sauces;
    //локатор заголовка "Соусы"
    @FindBy(how = How.XPATH,using = ".//h2[text()='Соусы']")
    private SelenideElement headerSauces;
    //локатор раздела "Булки"
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Булки')]")
    private SelenideElement buns;
    //локатор заголовка "Булки"
    @FindBy(how = How.XPATH,using = ".//h2[text()='Булки']")
    private SelenideElement headerBuns;
    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH,using = ".//button[text()='Оформить заказ']")
    private SelenideElement checkoutButton;

    //метод клика по кнопке "Личный кабинет"
    public void clickPersonalAccountButton() {
        personalAccountButton.shouldBe(enabled).click();
    }
    //метод клика по кнопке "Войти в аккаунт"
    public void clickLoginButton() {
        loginButton.click();
    }
    //метод клика по разделу "Начинки"
    public void clickFilling() {
        filling.shouldBe(exist);
        filling.click();
    }
    //метод нахождения заголовка "Начинки"
    public boolean isHeaderFillingDisplayed() {
        headerFilling.shouldBe(exist);
        return headerFilling.isDisplayed();
    }
    //метод клика по разделу "Соусы"
    public void clickSauces() {
        sauces.shouldBe(exist);
        sauces.click();
    }
    //метод нахождения заголовка "Соусы"
    public boolean isHeaderSaucesDisplayed() {
        headerSauces.shouldBe(exist);
        return headerSauces.isDisplayed();
    }
    //метод клика по разделу "Булки"
    public void clickBuns() {
        buns.shouldBe(exist);
        buns.click();
    }
    //метод нахождения заголовка "Булки"
    public boolean isHeaderBunsDisplayed() {
        headerBuns.shouldBe(exist);
        return headerBuns.isDisplayed();
    }
    //метод нахождения кнопки "Оформить заказ"
    public boolean isCheckoutButtonDisplayed() {
        checkoutButton.shouldBe(exist);
        return checkoutButton.isDisplayed();
    }
}