package org.example;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public class AmazonAutomationTask {
    public static void main(String[] args) {
        WebDriver driver = getWebDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement changeLanguageButton = driver.findElement(By.xpath("//span[@class=\"icp-nav-link-inner\"]//span[@class=\"nav-line-2\"]"));
        changeLanguageButton.click();

        WebElement changeLanguageToEnglish = driver.findElement(By.xpath("//input[@value=\"en_AE\"]/following-sibling::i[@class=\"a-icon a-icon-radio\"]"));
        changeLanguageToEnglish.click();

        WebElement saveChangesButton = driver.findElement(By.xpath("//input[@class=\"a-button-input\"]"));
        saveChangesButton.click();

        WebElement loginButton = driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]"));
        loginButton.click();

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id=\"ap_email\"]"));
        emailTextBox.sendKeys("omarashrafelaraby@gmail.com");

        WebElement continueButton = driver.findElement(By.xpath("//input[@id=\"continue\"]"));
        continueButton.click();


        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id=\"ap_password\"]"));
        actions.sendKeys(Keys.ESCAPE).perform();
        passwordTextBox.sendKeys("P@ssw0rd");

        WebElement signInButton = driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]"));
        signInButton.click();

        WebElement allMenuButton = driver.findElement(By.id("nav-hamburger-menu"));
        allMenuButton.click();

        WebElement videoGames = driver.findElement(By.linkText("Video Games"));
        videoGames.click();

        WebElement allVideoGames = driver.findElement(By.linkText("All Video Games"));
        allVideoGames.click();

        WebElement freeShippingCheckbox = driver.findElement(By.name("//a//div[@class=\"a-checkbox a-checkbox-fancy aok-float-left apb-browse-refinements-checkbox\"][1]"));
        freeShippingCheckbox.click();

        WebElement newCheckBox = driver.findElement(By.xpath("//a[@aria-current=\"step\"]/following::span[text()='New']"));
        newCheckBox.click();

        WebElement sortMenuButton = driver.findElement(By.xpath("//span[@class=\"a-button-text a-declarative\"]"));
        sortMenuButton.click();

        WebElement highToLowOption = driver.findElement(By.xpath("//li[@aria-labelledby=\"s-result-sort-select_2\"]"));
        highToLowOption.click();


        while (true) {
            List<WebElement> products = driver.findElements(By.cssSelector(".s-result-item"));
            for (WebElement product : products) {
                String price = product.findElement(By.cssSelector(".a-price-whole")).getText();
                if (15000 > Integer.parseInt(price.replace(",", ""))) {
                    product.findElement(By.cssSelector(".a-button-input")).click();
                }
            }
            if (driver.findElements(By.cssSelector(".a-last")).isEmpty()) {
                driver.findElement(By.cssSelector(".a-last")).click();
            } else {
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
    }

    private static @NotNull WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--password-manager-enabled=false");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.eg/?language=en_AE");
        return driver;
    }
}
