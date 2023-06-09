package com.phonebook.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    public WebDriver driver;
    UserHelper user;
    ContactHelper contact;
    HeaderHelper header;
    HomePageHelper homePage;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public UserHelper getUser() {
        return user;
    }
    public ContactHelper getContact() {
        return contact;
    }
    public HeaderHelper getHeader() {
        return header;
    }
    public HomePageHelper getHomePage() {
        return homePage;
    }

    public void init() {
        System.err.close(); // zakrutie sistemnux predypregdeniy v konsole

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")){
            EdgeOptions options = new EdgeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new EdgeDriver(options);
        }

        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        header = new HeaderHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }
    //    ili

//    public void removeContact() {
//        if (!isContactListEmpty()) {
//            click(By.cssSelector(".contact-item_card__2SOIM"));
//            click(By.xpath("//button[.='Remove']"));
//        }
//    }
//
//    public boolean isContactListEmpty() {
//        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
//    }
}
