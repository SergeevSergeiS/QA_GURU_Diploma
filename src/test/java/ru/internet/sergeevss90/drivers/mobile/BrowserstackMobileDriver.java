package ru.internet.sergeevss90.drivers.mobile;

import com.codeborne.selenide.WebDriverProvider;
import ru.internet.sergeevss90.config.mobile.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static ru.internet.sergeevss90.helpers.mobile.Browserstack.browserstackLogin;
import static ru.internet.sergeevss90.helpers.mobile.Browserstack.browserstackPassword;


public class BrowserstackMobileDriver implements WebDriverProvider {

    public static BrowserstackConfig configBStack = ConfigFactory.create(BrowserstackConfig.class);

    public static URL getBrowserstackUrl() {
        try {
            return new URL(configBStack.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.appium_version", "1.22.0");
        mutableCapabilities.setCapability("browserstack.user", browserstackLogin);
        mutableCapabilities.setCapability("browserstack.key", browserstackPassword);
        mutableCapabilities.setCapability("app", configBStack.identificateapp());
        mutableCapabilities.setCapability("device", configBStack.deviceName());
        mutableCapabilities.setCapability("os_version", configBStack.platformVersion());
        mutableCapabilities.setCapability("project", "QA.GURU lesson 11/22");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "Sample tests run");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

}
