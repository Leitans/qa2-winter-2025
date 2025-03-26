import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class RegistrationTest {
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By REGISTRATION_BTN = By.xpath(".//strong[@class = 'user-block__title--strong']");
    private final By REGISTRATION_LINK = By.xpath(".//p[@class = 'users-session-form__signup']/a");
    private final By FIRST_NAME = By.id("user_first_name");
    private final By LAST_NAME = By.id("user_last_name");
    private final By EMAIL = By.id("user_email");
    private final By PASSWORD = By.id("user_password");
    private final By PASSWORD_CONFIRM = By.id("user_password_confirmation");
    private final By MARKETING_CHECKBOX = By.id("user_marketing_consent_1");
    private final By INFORMATION_CHECKBOX = By.id("user_marketing_consent_2");
    private final By REGISTR_BTN = By.name("commit");
    private final By ERROR_MSG = By.xpath(".//p[@class = 'users-session-form__error-message']");

    private final String PASSWORD_COMPLEXITY_ERROR = "parolei jāsatur vismaz viens skaitlis, mazā burti, lielā burti un īpašais simbols";
    private final String PASSWORD_MATCH_ERROR = "nesakrīt ar apstiprinājumu";
    @Test
    public void  successfullRegistrationTest() {
        // 1. Open browser window
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        // 2. Open Home page
        browser.get("http://1a.lv");

        // 3. Accept cookies
         browser.findElement(ACCEPT_COOKIES_BTN).click();

        // 4. Press Registration btn
        browser.findElement(REGISTRATION_BTN).click();

        // 5. Click Registration link
    //    browser.findElement(REGISTRATION_LINK).click(); - так как монитор маленький, то этот код не отрабатывает.
        WebElement registrationLink = browser.findElement(REGISTRATION_LINK);

        Actions actions = new Actions(browser);
        actions.scrollToElement(registrationLink);
        actions.perform();

        registrationLink.click();

        // 6. Enter First Name
        browser.findElement(FIRST_NAME).sendKeys("Aleksandrs");

        // 7. Enter Surname
        browser.findElement(LAST_NAME).sendKeys("Leitans");

        // 8. Enter e-mail
        browser.findElement(EMAIL).sendKeys("test@test.lv");

        // 9. Enter password
        browser.findElement(PASSWORD).sendKeys("qwerty12345!");

        // 10. Enter Password again with mistake
        browser.findElement(PASSWORD_CONFIRM).sendKeys("qwerty12345");

        //Scroll to the registration btn
        WebElement registrationBtn = browser.findElement(REGISTR_BTN);
        actions.scrollToElement(registrationBtn);
        actions.perform();

        // 11. Select SMART NET marketing check-box
        browser.findElement(MARKETING_CHECKBOX).click();

        // 12. Select 1A.LV marketing check-box
        browser.findElement(INFORMATION_CHECKBOX).click();

        // 13. Press Registration button
        registrationBtn.click();

        // 14. Check wrong password error message
        List<WebElement> errorMessages = browser.findElements(ERROR_MSG);
        Assertions.assertEquals(2, errorMessages.size(), "Wrong errors amount");
        Assertions.assertEquals(PASSWORD_COMPLEXITY_ERROR, errorMessages.get(0).getText(), "Error msg 1!");
        Assertions.assertEquals(PASSWORD_MATCH_ERROR, errorMessages.get(1).getText(), "Error msg 2!");
    }
}
