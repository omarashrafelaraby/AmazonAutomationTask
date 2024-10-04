package org.example;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class AmazonAutomationTask {
    public static void main(String[] args){
        WebDriver driver = getWebDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

  /*     WebElement changeLanguageButton = driver.findElement(By.xpath("//span[@class=\"icp-nav-link-inner\"]//span[@class=\"nav-line-2\"]"));
        changeLanguageButton.click();

        WebElement changeLanguageToEnglish = driver.findElement(By.xpath("//input[@value=\"en_AE\"]/following-sibling::i[@class=\"a-icon a-icon-radio\"]"));
        changeLanguageToEnglish.click();

        WebElement saveChangesButton = driver.findElement(By.xpath("//input[@class=\"a-button-input\"]"));
        saveChangesButton.click();*/

        WebElement loginButton = driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]"));
        loginButton.click();

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id=\"ap_email\"]"));
        emailTextBox.sendKeys("01155502161");

        WebElement continueButton = driver.findElement(By.xpath("//input[@id=\"continue\"]"));
        continueButton.click();


        WebElement passwordTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"ap_password\"]")));
//        actions.sendKeys(Keys.ESCAPE).perform();
        passwordTextBox.sendKeys("Semester-Re5tar");

        WebElement signInButton = driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]"));
        signInButton.click();

      /*  System.out.println("Please enter the OTP sent to your device and press Enter...");
        new java.util.Scanner(System.in).nextLine(); */// Wait for user input


        WebElement allMenuButton = driver.findElement(By.id("nav-hamburger-menu"));
        allMenuButton.click();

        WebElement videoGames = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Video Games")));
        videoGames.click();

//        WebElement allVideoGames = driver.findElement(By.linkText("All Video Games"));
//        allVideoGames.click();

        WebElement freeShippingCheckbox =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//input[@id=\"apb-browse-refinements-checkbox_2\"]")));
        freeShippingCheckbox.click();

        WebElement newCheckBox = driver.findElement(By.xpath("//a[@aria-current=\"step\"]/following::span[text()='New']"));
        newCheckBox.click();

        WebElement sortMenuButton = driver.findElement(By.xpath("//span[@class=\"a-button-text a-declarative\"]"));
        sortMenuButton.click();

        WebElement highToLowOption = driver.findElement(By.xpath("//li[@aria-labelledby=\"s-result-sort-select_2\"]"));
        highToLowOption.click();


        while (true) {
            List<WebElement> productsList = driver.findElements(By.cssSelector(".s-result-item"));
            for (WebElement product : productsList) {
                String priceTag = product.findElement(By.cssSelector(".a-price-whole")).getText();
                if (15000 > Integer.parseInt(priceTag.replace(",", ""))) {
                    WebElement priceFilter = product.findElement(By.cssSelector(".a-button-input"));
                    priceFilter.click();
                }
            }
            if (driver.findElements(By.cssSelector(".s-pagination-item s-pagination-next")).isEmpty()) {
                driver.findElement(By.cssSelector(".s-pagination-item s-pagination-next")).click();
            }else{
                break;
            }
        }

        WebElement cartButton = driver.findElement(By.id("nav-cart"));
        cartButton.click();

        WebElement proceedToCheckoutButton = driver.findElement(By.id("sc-buy-box-ptc-button"));
        proceedToCheckoutButton.click();


        WebElement addressButton = driver.findElement(By.id("address-book-entry-0"));
        addressButton.click();

        WebElement cashPaymentOption = driver.findElement(By.cssSelector(".a-button-input"));
        cashPaymentOption.click();

        String totalAmount = driver.findElement(By.id("sc-subtotal-amount-buybox")).getText();
        String shippingFees = driver.findElement(By.id("sc-shipping-charge-buybox")).getText();
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Shipping Fees: " + shippingFees);
        driver.quit();
    }

    private static @NotNull WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--password-manager-enabled=false");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-application-cache");
        options.addArguments("--disable-cache");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.eg/?language=en_AE");
        return driver;
    }
}
