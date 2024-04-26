package org.example;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static WorkWithExcel dateFromExcel;
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера

        ChromeOptions options = new ChromeOptions();

        options.addExtensions(new File(ConfProperties.getProperty("extensions")));
        driver = new ChromeDriver(options);

        loginPage = new LoginPage(driver);
        //profilePage = new ProfilePage(driver);

        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
        dateFromExcel = new WorkWithExcel("D:\\1.xlsx");
    }

    @Test
    public void loginTest() {
        //WorkWithExcel.ReadWorkbook();
        loginPage.getToESIA();
        for (int i = 0; i < dateFromExcel.lenght;i++){
            dateFromExcel.data.get(i).get(3).toString();

            }
        }
    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}