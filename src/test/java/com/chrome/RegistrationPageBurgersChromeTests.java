package com.chrome;

import com.codeborne.selenide.Configuration;
import com.pageobject.LoginPageBurgers;
import com.pageobject.MainPageBurgers;
import com.pageobject.RegistrationPageBurgers;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.pageobject.MainPageBurgers.homePageBurgers;
import static org.junit.Assert.assertTrue;

public class RegistrationPageBurgersChromeTests {

    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String passwordCorrectWithSixCharacters = RandomStringUtils.randomAlphabetic(6);
    String passwordUnCorrectWithFiveCharacters = RandomStringUtils.randomAlphabetic(5);

    @Before
    public void setup() {
        //открыть браузер в максимальном разрешении
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @Description("Successful user registration")
    public void successfulRegistrationTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPageBurgers registrationPage = page(RegistrationPageBurgers.class);
        //заполнить форму с именем, электронной почтой и паролем из 6 символов
        registrationPage.fillFormRegistration(name, email, passwordCorrectWithSixCharacters);

        //проверить на дисплее кнопку "Войти"
        assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    @Description("Unsuccessful registration of a user with a five-character password")
    public void unsuccessfulRegistrationWithPasswordFiveCharactersTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPageBurgers registrationPage = page(RegistrationPageBurgers.class);
        //заполнить форму с именем, электронной почтой и паролем из 5 символов
        registrationPage.fillFormRegistration(name, email, passwordUnCorrectWithFiveCharacters);

        //проверить на диспле "Некорректный пароль"
        assertTrue(registrationPage.isUnCorrectPasswordDisplayed());
    }
}