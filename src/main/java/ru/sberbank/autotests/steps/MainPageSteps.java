package ru.sberbank.autotests.steps;

import ru.sberbank.autotests.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import static ru.sberbank.autotests.steps.BaseSteps.driver;

public class MainPageSteps {
    @Step("Выбран пунк меню {0}")
    public void stepSelectMainMenu(String menuItem){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu(menuItem);
    }

    @Step("Выбран пунк меню {0}]")
    public void stepSelectSubMenu(String menuItem){
        MainPage mainPage = new MainPage(driver);
        mainPage.waitVisibilityOfelement();
        mainPage.selectSubMenu(menuItem);
    }
}
