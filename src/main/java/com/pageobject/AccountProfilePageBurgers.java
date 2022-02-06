package com.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;

public class AccountProfilePageBurgers {

    //локатор текста "Выход"
    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement logout;
    //локатор кнопки "Конструктор"
    @FindBy(how = How.LINK_TEXT,using = "Конструктор")
    private SelenideElement constructorButton;

    //метод клика по тексту "Выход"
    @Step("Клик по тексту \"Выход\"")
    public void clickLogout() {
        logout.click();
    }
    //метод нахождения текста "Выход"
    public boolean isLogoutDisplayed() {
        logout.shouldBe(exist);
        return logout.isDisplayed();
    }
    //метод клика по кнопке "Конструктор"
    @Step("Клик по кнопке \"Конструктор\"")
    public void clickConstructorButton() {
        constructorButton.shouldBe(exist);
        constructorButton.click();
    }
}