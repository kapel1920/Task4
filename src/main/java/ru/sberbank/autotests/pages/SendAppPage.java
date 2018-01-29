package ru.sberbank.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class SendAppPage extends BasePage {
    @FindBy(name = "insured0_surname")
    WebElement insured_surname;

    @FindBy(name = "insured0_name")
    WebElement insured_name;

    @FindBy(name = "insured0_birthDate")
    WebElement insured_birthDate;

    @FindBy(name = "surname")
    WebElement surname;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
    public WebElement sendButton;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        if (fieldName.equals("Фамилия")) {
            fillField(surname, value);

        } else if (fieldName.equals("Имя")) {
            fillField(name, value);

        } else if (fieldName.equals("Отчество")) {
            fillField(middlename, value);

        } else if (fieldName.equals("Фамилия2")) {
            fillField(insured_surname, value);

        } else if (fieldName.equals("Имя2")) {
            fillField(insured_name, value);

        } else if (fieldName.equals("Дата рождения")) {
            fillField(insured_birthDate, value);

        } else if (fieldName.equals("Дата рождения2")) {
            fillField(birthDate, value);

        } else {
            throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void checkFields(){
        assertEquals("Ivanov", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("Ivan", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("01.01.1990", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Иванов", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("01.01.1990", driver.findElement(By.name("birthDate")).getAttribute("value"));
    }
    public void checkError(){
        assertEquals("Заполнены не все обязательные поля", driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).getText());
    }
}
