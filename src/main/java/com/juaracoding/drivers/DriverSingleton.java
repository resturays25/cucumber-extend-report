package com.juaracoding.drivers;

import com.juaracoding.drivers.strategies.DriverStrategy;
import com.juaracoding.drivers.strategies.DriverStrategyImplementer;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static DriverSingleton instance = null;
    private static WebDriver driver;

    public DriverSingleton(String driver){
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy){
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static DriverSingleton getInstance(String driver){
        if (instance == null || driver == null) {
            instance = new DriverSingleton(driver);
        } else {
            // Optional: Restart driver if driverType is Chrome
            if (driver.equalsIgnoreCase(Constants.CHROME)) {
                closeObjectInstance(); // Ensure old driver is closed
                instance = new DriverSingleton(driver);
            }
        }
        return instance;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void scroll(WebDriver driver, int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public static void closeObjectInstance() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver = null; // Ensure driver is set to null
                instance = null; // Reset instance
            }
        }
    }

}
