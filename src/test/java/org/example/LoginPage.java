package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //локатор для поля Логин на странице авторизации
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;
    //локатор для кнопки Войти на странице авторизации
    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement loginBtn;
    //локатор для поля Пароль на странице авторизации
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;

    //метод для ввода Логина
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    //метод для ввода пароля
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    //метод для нажатия на кнопку Войти
    public void clickLoginBtn(){
        loginBtn.click();
    }
}
