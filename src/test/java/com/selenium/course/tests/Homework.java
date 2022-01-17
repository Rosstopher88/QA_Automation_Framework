package com.selenium.course.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homework {
    //Selenium
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup(); //this download the needed web driver
        System.setProperty("webdriver.chrome.driver", "C:\\QA_Automation_Framework\\src\\test\\java\\com\\selenium\\course\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(); //creates the session and open the browser
    }

    @AfterTest //This cames from TestNG
    public void tearDown() throws InterruptedException {
        //driver.close(); closes only the current drive not closing the session
        Thread.sleep(6000);
        driver.quit(); //closing and killing the session
    }

    @Test
    public void HomeworkVariant1() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().fullscreen();

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");
        Thread.sleep(2000);

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(2000);

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();
        Thread.sleep(2000);


        WebElement productsMainLabel = driver.findElement(By.xpath("//span[text()='Products']"));
        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        Thread.sleep(3000);
        Assert.assertTrue(productsMainLabel.isDisplayed());
        Assert.assertTrue(shoppingCartLink.isDisplayed());

        WebElement productSortContainer = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select"));
        productSortContainer.click();
        Thread.sleep(3000);

        WebElement nameAtoZ = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]"));
        nameAtoZ.click();
        Thread.sleep(3000);

        WebElement nameZtoA = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]"));
        nameZtoA.click();
        Thread.sleep(3000);

        WebElement priceLowToHigh = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]"));
        priceLowToHigh.click();
        Thread.sleep(3000);

        WebElement priceHighToLow = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]"));
        priceHighToLow.click();
        Thread.sleep(3000);


    }

//    @Test //This cames from TestNG
//    public void logInWithWrongUser(){
//        driver.get("https://www.saucedemo.com/");
//
//        WebElement userNameInput = driver.findElement(By.id("user-name"));
//        userNameInput.sendKeys("standard_user");
//
//        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
//        passwordInput.sendKeys("secret_sauce");
//
//        WebElement loginBtn = driver.findElement(By.name("login-button"));
//        loginBtn.click();
//
//
//        WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));
//
//        Assert.assertTrue(wrongUserBtn.isDisplayed());


    @Test
    public void HomeworkVariant2() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().fullscreen();

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");
        Thread.sleep(2000);

        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(2000);

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();
        Thread.sleep(2000);


        Select objSelect = new Select(driver.findElement(By.className("product_sort_container")));
        objSelect.selectByValue("az");
        Thread.sleep(4000);

        objSelect.selectByValue("za");
        Thread.sleep(4000);
        objSelect = new Select(driver.findElement(By.className("product_sort_container")));
        objSelect.selectByValue("lohi");
        Thread.sleep(4000);
        objSelect = new Select(driver.findElement(By.className("product_sort_container")));
        objSelect.selectByValue("hilo");
        Thread.sleep(4000);


    }
}