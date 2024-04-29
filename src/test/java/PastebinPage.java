import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locator definitions
    private By textArea = By.id("postform-text");
    private By expirationDropdown = By.id("select2-postform-expiration-container");
    private By expirationOption = By.xpath("//li[text()='10 Minutes']"); // More reliable locator
    private By titleField = By.id("postform-name");
    private By createButton = By.xpath("//button[text()='Create New Paste']");

    public PastebinPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterText(String text) {
        WebElement textField = wait.until(ExpectedConditions.elementToBeClickable(textArea));
        textField.sendKeys(text);
    }

    public void setExpiration() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(expirationDropdown));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(expirationOption));
        option.click();
    }

    public void enterTitle(String title) {
        WebElement titleFieldElement = wait.until(ExpectedConditions.elementToBeClickable(titleField));
        titleFieldElement.sendKeys(title);
    }

    public void createPaste() {
        WebElement createBtn = wait.until(ExpectedConditions.elementToBeClickable(createButton));
        createBtn.click();
    }
}





