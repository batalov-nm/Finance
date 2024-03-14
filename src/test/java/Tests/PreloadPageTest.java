package Tests;

import Pages.PreloadPage;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class PreloadPageTest extends BaseTest{
    protected String adminLogin = "admin@admin.ad";
    protected String adminPassword = "admin";
    protected String wrongLogin = "s@a.ad";
    protected String wrongPassword = "adasd";

    @Test
    public void PositiveLoginIntoSystem() throws InterruptedException {
        PreloadPage preloadPage = new PreloadPage();
        preloadPage
                .enterEmail(adminLogin)
                .enterPassword(adminPassword)
                .clickSubmitButton();
        assertTrue(preloadPage.layoutContainerIsVisible());
    }

    @Test
    public void NegativeLoginIntoSystem() throws InterruptedException {
        PreloadPage preloadPage = new PreloadPage();
        preloadPage
                .enterEmail(wrongLogin)
                .enterPassword(wrongPassword)
                .clickSubmitButton();
        assertTrue(preloadPage.isErrorPopped());
    }

    @Test
    public void EmptyLoginIntoSystem() throws InterruptedException {
        PreloadPage preloadPage = new PreloadPage();
        preloadPage
                .enterEmail("")
                .enterPassword("")
                .clickSubmitButton();
        assertTrue(preloadPage.isErrorPopped());
    }
}
