package com;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BaseTest {

   // Метод открытия страницы в разных браузерах
    public static void openInDifferentBrowsers(String browser) {
        if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
            Configuration.startMaximized = true;
        } else if (browser.equals("chrome")) {
            System.setProperty("selenide.browser", "chrome");
            Configuration.startMaximized = true;
        }
    }

    // Метод закрытия браузера
    public static void closeDriver() {
               getWebDriver().close();
           }



}
