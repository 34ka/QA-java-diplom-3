package com.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPageBurgers {

    //локатор текста "Войти"
    @FindBy(how = How.LINK_TEXT,using = "Войти")
    private SelenideElement login;

    //метод клика по тексту "Войти"
    @Step("Клик по тексту \"Войти\"")
    public void clickLogin() {
        login.click();
    }
}