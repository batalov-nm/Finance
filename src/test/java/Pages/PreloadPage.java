package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class PreloadPage extends BasePage{
//    @FindBy(xpath = "//ul[contains(@class, 'side__menu')]") // //ul[contains(@class, 'side__menu')]
//    private List<WebElement> sideMenu;

    @FindBy(xpath = "//input[contains(@type, 'email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[contains(@type, 'password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(@Class, 'layout__container')]")
    private WebElement layoutContainer;

    @FindBy(xpath = "//div[contains(@Class, 'form-field__errors-list')]") //form-field__errors-list
    private WebElement ErrorPopup;


    public PreloadPage(){
        driver.get("https://fabrique:fabrique@finance.dev.fabrique.studio/accounts/login/");
        PageFactory.initElements(driver, this);
    }

    public PreloadPage enterEmail(String email){
        emailInput.click();
        emailInput.sendKeys(email);
        return this;
    }
    public PreloadPage enterPassword(String pass){
        passwordInput.click();
        passwordInput.sendKeys(pass);
        return this;
    }
    public PreloadPage clickSubmitButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@type, 'submit')]")));
        submitButton.click();
        return this;
    }
    public boolean layoutContainerIsVisible(){
        System.out.println("Log in successfully");
        return layoutContainer.isDisplayed();
    }
    public boolean isErrorPopped(){
        System.out.println("Error is popped");
        return ErrorPopup.isEnabled();
    }
}
