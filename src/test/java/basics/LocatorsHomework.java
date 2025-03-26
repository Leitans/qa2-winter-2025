package basics;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocatorsHomework {

    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    private final By CONTACTS_LINK = By.xpath("//a[contains(text(), 'Kontakti')]");

    private final By MAIN_LOGO = By.className("main-logo");

    private final By SEARCH_ICON = By.className("main-search-submit__icon");

    private final By CART_ICON = By.className("cart-block__icon");

    private final By VISAS_PRECES_LINK = By.xpath("//a[contains(@class, 'submenu-lvl2__block-title-link')]" +
            "//span[text()='Visas preces']");

    private final By COOKIE_RADIT_DETALIZETI = By.id("CybotCookiebotDialogBodyLevelDetailsButton");

    private final By BALL_ICON = By.xpath(
            "//li[contains(@class, 'submenu-lvl1__list-item') and contains(@class, 'color-theme-10') and " +
                    "contains(@class, 'submenu-lvl1__list-item--has-child') and contains(@class, 'hover')]//svg[@id='icon-leisure']");

    @Test
    public void  homeworkTest() {
        // 1. Открыть браузер
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        // 2. Открыть главную страницу
        browser.get("http://1a.lv");

        // 3. Принять cookies
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        // 4. Навести мышь на элемент "Preču katalogs" (если это необходимо для отображения подменю)
        WebElement catalogueMenu = browser.findElement(CATALOGUE_MENU_ICON);
        Actions actions = new Actions(browser);
        actions.moveToElement(catalogueMenu).perform(); // Навести мышь на меню

        // 5. Навести мышь на "Spēļu konsoles un piederumi"
        WebElement gamesCategory = browser.findElement(By.xpath("//a[contains(text(), 'Spēļu konsoles un piederumi')]"));
        actions.moveToElement(gamesCategory).perform(); // Навести мышь на нужный элемент

        // 6. Кликнуть по картинке мячика (в красной рамке)
        WebElement ballIcon = browser.findElement(BALL_ICON);
        ballIcon.click();  // Кликаем по мячикам (иконке)

    }

}
