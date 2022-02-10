package com.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.UserOperations.EMAIL_POSTFIX;
import static com.codeborne.selenide.Selenide.page;

public class RegisterElementsSelenide {

    public static String registerURL = "https://stellarburgers.nomoreparties.site/register";

    //поля «Имя», «Email», «Пароль»
    @FindBy(how = How.XPATH, using = ".//input")
    public ElementsCollection nameEmailAndPasswordFields;


    //кнопка «Зарегистрироваться»
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    public SelenideElement registerButton;


    //заголовок "Вход"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    public SelenideElement enterHead;

    //ошибка «Некорректный пароль»
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']")
    public SelenideElement incorrectPasswordMessage;

    //ссылка «Войти»
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    public SelenideElement loginLink;



    @Step("Нажать на ссылку Войти на странице регистрации")
    public LoginPageElementsSelenide clickLogInButton() {
        loginLink.click();
        return page(LoginPageElementsSelenide.class);

    }

    //ошибка при некорректном пароле
    public boolean messageIncorrectPassword() {
        return incorrectPasswordMessage.isDisplayed();
    }



    @Step("Регистрация пользователя")
    public LoginPageElementsSelenide successRegistration() {
        (nameEmailAndPasswordFields.get(0)).sendKeys(RandomStringUtils.randomAlphabetic(10));
        (nameEmailAndPasswordFields.get(1)).sendKeys(RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX);
        (nameEmailAndPasswordFields.get(2)).sendKeys(RandomStringUtils.randomAlphabetic(6));
        registerButton.click();
        enterHead.shouldBe(Condition.visible);
        return page(LoginPageElementsSelenide.class);
    }


    @Step("Регистрация с невалидным паролем")
    public RegisterElementsSelenide invalidRegistration(){
        (nameEmailAndPasswordFields.get(0)).sendKeys(RandomStringUtils.randomAlphabetic(10));
        (nameEmailAndPasswordFields.get(1)).sendKeys(RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX);
        (nameEmailAndPasswordFields.get(2)).sendKeys(RandomStringUtils.randomAlphabetic(5));
        registerButton.click();
        incorrectPasswordMessage.shouldBe(Condition.visible);
        return this;

    }



}



