package com.yandex;

import com.BaseBurgers;
import com.codeborne.selenide.Configuration;
import com.pageobject.AccountProfilePageBurgers;
import com.pageobject.MainPageBurgers;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.pageobject.MainPageBurgers.HOME_PAGE_BURGERS;
import static org.junit.Assert.assertTrue;

public class MainPageBurgersYandexTests extends BaseBurgers {

    @Before
    public void setup() {

        //открыть браузер в максимальном разрешении
        Configuration.startMaximized = true;

        //запустить Яндекс браузер
        startYandexBrowser();
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
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на раздел "Начинки"
        mainPage.clickFilling();

        //Проверить на дисплее после перехода в раздел "Начинки"
        assertTrue("Нахождение не в разделе 'Начинки'", mainPage.isHeaderFillingVisible());
    }

    @Test
    @Description("Checking the click on the buns")
    public void checkClickBunsTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на раздел "Начинки"
        mainPage.clickFilling();

        //кликнуть на раздел "Булки"
        mainPage.clickBuns();

        //проверить на дисплее заголовок "Булки"
        assertTrue(mainPage.isHeaderBunsVisible());
    }

    @Test
    @Description("Checking the click on the sauces")
    public void checkClickSaucesTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на раздел "Соусы"
        mainPage.clickSauces();

        //проверить на дисплее после перехода в раздел "Начинки"
        assertTrue("Нахождение не в разделе 'Соусы'", mainPage.isHeaderSaucesVisible());
    }
}
