package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;



public class LoginTest {

     //осуществление первоначальной настройки
    @BeforeClass
    public static void setup() {
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
        //создание экземпляра метода авторизации
        loginPage = new LoginPage(driver);
        //создание экземпляра страницы пользователя
        profilePage = new ProfilePage(driver);
    }

    //тестовый сценарий
    @Test
    public void loginTest() {
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //и loginpage
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("passwd"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //открываем меню
        profilePage.entryMenu();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user );
    }

    //завершение теста
    @AfterClass
    public static void tearDown() {
        profilePage.userLogout();
        driver.quit();
    }

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
}
