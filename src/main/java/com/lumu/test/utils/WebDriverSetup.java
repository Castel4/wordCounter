package com.lumu.test.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetup {

    private static WebDriver webDriver;

    public static Actor createUserWithBrowser() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
        }
        Actor user = Actor.named("User").can(BrowseTheWeb.with(webDriver));
        return user;
    }

    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}

