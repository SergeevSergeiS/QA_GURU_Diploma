package ru.internet.sergeevss90.config.web;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/remote.properties",
        "classpath:config/local.properties",
        "classpath:litres.properties"
})
public interface WebConfig extends Config {

    @DefaultValue("chrome")
    String browser();
    @DefaultValue("99.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
    String todoistLogin();
    String todoistPassword();
}
