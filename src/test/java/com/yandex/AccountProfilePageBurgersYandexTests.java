package com.yandex;

import com.BaseBurgers;
import com.codeborne.selenide.Configuration;
import com.pageobject.AccountProfilePageBurgers;
import com.pageobject.LoginPageBurgers;
import com.pageobject.MainPageBurgers;
import com.pageobject.RegistrationPageBurgers;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.pageobject.MainPageBurgers.HOME_PAGE_BURGERS;
import static org.junit.Assert.assertTrue;

public class AccountProfilePageBurgersYandexTests extends BaseBurgers {

    static String name = RandomStringUtils.randomAlphabetic(10);
    static String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    static String password = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setup() {

        //открыть браузер в максимальном разрешении
        Configuration.startMaximized = true;

        //запустить Яндекс браузер
        startYandexBrowser();

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

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
    @Description("Check the click-through to the \"Personal Account\"")
    public void checkAccountProfileTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        AccountProfilePageBurgers accountProfile = page(AccountProfilePageBurgers.class);
        //проверить на дисплее "Выход"
        assertTrue(accountProfile.isLogoutDisplayed());

        //разлогин
        //кликнуть на "Выход"
        accountProfile.clickLogout();
    }

    @Test
    @Description("Check the click on the \"Constructor\"")
    public void checkConstructorFromAccountProfileTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        AccountProfilePageBurgers accountProfile = page(AccountProfilePageBurgers.class);
        //кликнуть на "Конструктор"
        accountProfile.clickConstructorButton();

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());

        //разлогин
        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        //кликнуть на "Выход"
        accountProfile.clickLogout();

    }

    @Test
    @Description("Check the exit by clicking the \"Exit\" button in your personal account")
    public void checkLogoutFromAccountProfileTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        AccountProfilePageBurgers accountProfile = page(AccountProfilePageBurgers.class);
        //кликнуть на "Выход"
        accountProfile.clickLogout();

        //проверить на дисплее кнопку "Войти"
        assertTrue(loginPage.isLoginButtonDisplayed());
    }
}
