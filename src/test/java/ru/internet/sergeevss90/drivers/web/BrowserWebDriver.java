package ru.internet.sergeevss90.drivers.web;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.internet.sergeevss90.config.web.WebConfig;

import java.util.HashMap;
import java.util.Map;

public class BrowserWebDriver {

    public static WebConfig config = ConfigFactory.create(WebConfig.class);

    public static boolean isWebMobile() {
        return !config.browserMobileView().equals("");
    }

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }

    public static void configure() {
        Configuration.baseUrl = "https://todoist.com/";
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        if (isWebMobile()) { // for chrome only
            Map<String, Object> mobileDevice = new HashMap<>();
            mobileDevice.put("deviceName", config.browserMobileView());
            chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
        }

        if (isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = "https://" + config.selenoidLogin() + ":" + config.selenoidPassword() + "@" + config.remoteDriverUrl();
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
