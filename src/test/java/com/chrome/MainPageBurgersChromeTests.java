package com.chrome;

import com.codeborne.selenide.Configuration;
import com.pageobject.*;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.pageobject.MainPageBurgers.homePageBurgers;
import static org.junit.Assert.assertTrue;

public class MainPageBurgersChromeTests {

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
    @Description("Checking the click on the filling")
    public void checkClickFillingTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на раздел "Начинки"
        mainPage.clickFilling();

        //Проверить на дисплее заголовок "Начинки"
        assertTrue(mainPage.isHeaderFillingDisplayed());
    }

    @Test
    @Description("Checking the click on the buns")
    public void checkClickBunsTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        AccountProfilePageBurgers accountProfile = page(AccountProfilePageBurgers.class);
        //кликнуть на "Конструктор"
        accountProfile.clickConstructorButton();

        //кликнуть на раздел "Начинки"
        mainPage.clickFilling();

        //кликнуть на раздел "Булки"
        mainPage.clickBuns();

        //Проверить на дисплее заголовок "Булки"
        assertTrue(mainPage.isHeaderBunsDisplayed());
    }

    @Test
    @Description("Checking the click on the sauces")
    public void checkClickSaucesTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(homePageBurgers, MainPageBurgers.class);

        //кликнуть на раздел "Соусы"
        mainPage.clickSauces();

        //Проверить на дисплее заголовок "Соусы"
        assertTrue(mainPage.isHeaderSaucesDisplayed());
    }
}
