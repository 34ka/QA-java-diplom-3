package com.chrome;

import com.codeborne.selenide.Configuration;
import com.pageobject.ForgotPasswordPageBurgers;
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

public class LoginPageBurgersChromeTests {

    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setup() {

        //открыть браузер в максимальном разрешении
        Configuration.startMaximized = true;

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPageBurgers registrationPage = page(RegistrationPageBurgers.class);
        //заполнить форму с именем, электронной почтой и паролем
        registrationPage.fillFormRegistration(name, email, password);
    }

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @Description("Check the login using the \"Log in to account\" button on the main page")
    public void checkLoginButtonMainPageForLoginTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Check the login via the \"Personal Account\" button on the main page")
    public void checkPersonalAccountButtonMainPageForLoginTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Check the login via the button in the registration form on the registration page")
    public void checkLoginButtonRegistrationPageForLoginTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPageBurgers registrationPage = page(RegistrationPageBurgers.class);
        //кликнуть на "Войти"
        registrationPage.clickLogin();

        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Check the login via the button in the password recovery form on the password recovery page")
    public void checkLoginButtonForgotPasswordPageForLoginTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //кликнуть на "Восстановить пароль"
        loginPage.clickRecoverPassword();

        ForgotPasswordPageBurgers forgotPassword = page(ForgotPasswordPageBurgers.class);
        //кликнуть на "Войти"
        forgotPassword.clickLogin();

        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }
}
