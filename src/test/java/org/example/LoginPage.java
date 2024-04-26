package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void myWiat(int sec){
        try {
            Thread.sleep(sec*1000); // Задержка в 1 секунду
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void getToESIA() {

        WebElement clickable = driver.findElement(By.className("button_link"));
        clickable.click();
        myWiat(1);
        clickable = driver.findElement(By.id("esia_agree"));
        clickable.click();
        myWiat(1);
        clickable = driver.findElement(By.id("esia_login"));
        clickable.click();
        myWiat(1);
        clickable = driver.findElement(By.xpath("/html/body/esia-root/div/esia-login/div/div[1]/form/div[4]/div/div[2]/div[2]/button"));
        clickable.click();
        myWiat(1);
        clickable = driver.findElement(By.xpath("/html/body/esia-root/div/esia-login/div/div[1]/esia-eds/div/button"));
        clickable.click();
        myWiat(5);
        clickable = driver.findElement(By.xpath("/html/body/esia-root/esia-modal/div/div[2]/div/ng-component/div/esia-eds-item[3]/div/button"));
        clickable.click();
        myWiat(5);
        clickable = driver.findElement(By.xpath("/html/body/esia-root/esia-modal/div/div[2]/div/ng-component/div/div[2]/button"));
        clickable.click();
        myWiat(5);
        clickable = driver.findElement(By.xpath("html/body/div/div/form/button[2]"));
        clickable.click();
        myWiat(1);
        clickable = driver.findElement(By.xpath("//*[@id=\"app-wrapper\"]/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/button"));
        clickable.click();
        myWiat(5);
        clickable = driver.findElement(By.xpath("//*[@id=\"app-side-nav\"]/div/nav/ul/li[1]/ul/li[2]/a"));
        clickable.click();
        myWiat(5);
        findInFGIS("1011125406805");
    }
    public void findInFGIS(String numOfFind){
        WebElement fieldOfMetr = driver.findElement(By.xpath("//*[@id=\"app-wrapper\"]/div[1]/div/section/div/div[1]/div[10]/div/input"));
        fieldOfMetr.sendKeys(numOfFind);
        myWiat(5);
        driver.findElement(By.xpath("//*[@id=\"app-wrapper\"]/div[1]/div/section/div/div[1]/div[10]/div/div/button")).click();
        myWiat(5);
        driver.findElement(By.xpath("//*[@id=\"item_348232210\"]/td[1]/div/label")).click();
        myWiat(5);
        driver.findElement(By.xpath("//*[@id=\"app-wrapper\"]/div[1]/div/section/div/div[1]/div[3]/a/button")).click();
        myWiat(5);
        driver.findElement(By.xpath("//*[@id=\"tab-means\"]")).click();
        myWiat(5);
    }
}