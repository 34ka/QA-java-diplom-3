package com.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class MainPageBurgers {

    //главная страница тестового стенда Бургеры
    public static final String HOME_PAGE_BURGERS = ("https://stellarburgers.nomoreparties.site/");

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
    //локатор раздела "Начинки" после клика на него
    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab_type_current__2BEPc']")
    private SelenideElement headerFillingVisibleAfterClick;
    //локатор раздела "Соусы"
    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement sauces;
    //локатор заголовка "Соусы"
    @FindBy(how = How.XPATH,using = ".//h2[text()='Соусы']")
    private SelenideElement headerSauces;
    //локатор раздела "Соусы" после клика на него
    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab_type_current__2BEPc']")
    private SelenideElement headerSaucesVisibleAfterClick;
    //локатор раздела "Булки"
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Булки')]")
    private SelenideElement buns;
    //локатор заголовка "Булки"
    @FindBy(how = How.XPATH,using = ".//h2[text()='Булки']")
    private SelenideElement headerBuns;
    //локатор раздела "Булки" после клика на него
    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab_type_current__2BEPc']")
    private SelenideElement headerBunsVisibleAfterClick;
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
    @Step("Клик по разделу \"Начинки\"")
    public void clickFilling() {
        filling.shouldBe(exist);
        filling.click();
    }
    //метод нахождения заголовка "Начинки"
    public boolean isHeaderFillingVisible() {
        return headerFillingVisibleAfterClick.getText().contentEquals("Начинки");
    }
    //метод клика по разделу "Соусы"
    @Step("Клик по разделу \"Соусы\"")
    public void clickSauces() {
        sauces.shouldBe(exist);
        sauces.click();
    }
    //метод нахождения заголовка "Соусы"
    public boolean isHeaderSaucesVisible() {
        return headerSaucesVisibleAfterClick.getText().contentEquals("Соусы");
    }
    //метод клика по разделу "Булки"
    @Step("Клик по разделу \"Булки\"")
    public void clickBuns() {
        buns.shouldBe(exist);
        buns.click();
    }
    //метод нахождения заголовка "Булки"
    public boolean isHeaderBunsVisible() {
        return headerBunsVisibleAfterClick.getText().contentEquals("Булки");
    }
    //метод нахождения кнопки "Оформить заказ"
    public boolean isCheckoutButtonDisplayed() {
        checkoutButton.shouldBe(exist);
        return checkoutButton.isDisplayed();
    }
}