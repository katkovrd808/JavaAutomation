package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //локатор для кнопки открытия меню пользователя
    @FindBy(xpath = "//*[@class='UserID-Account']")
    private WebElement userMenuBtn;
    //локатор для фрейма меню пользователя
    //@FindBy(xpath = "//iframe[contains(@class, 'UserWidget-Iframe')]//")
    //private WebElement userMenu;
    //локатор для имени пользователя в меню пользователя
    @FindBy(xpath = "//span[contains(@class, 'Subname')]")
    private WebElement userName;
    //локатор для кнопки выхода из аккаунта
    @FindBy(xpath = "//div[contains(@class, 'MenuItem_logout')]")
    private WebElement logoutBtn;

    //метод для получения логина пользователя в меню пользователя с переключением на iframe
    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'Subname')]")));
        String userLogin = userName.getText();
        return userLogin;
    }
    //метод для открытия меню пользователя
    public void entryMenu(){
        userMenuBtn.click();
    }
    //метод для нажатия кнопки выхода из аккаунта
    public void userLogout(){
        logoutBtn.click();
    }
}
