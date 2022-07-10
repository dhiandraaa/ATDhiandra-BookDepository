package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBasketPO {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/basket/addisbn/isbn13/9781529176643']")
    WebElement addToBasketButton;

    @FindBy(xpath = "//h3[@class='modal-title']")
    WebElement itemAddedTitle;

    @FindBy(xpath = "//a[.='Basket / Checkout']")
    WebElement basketButton;

    @FindBy(xpath = "//h1[.='Your basket']")
    WebElement myBaksetTitle;

    @FindBy(xpath = "//select[@name='quantity']")
    WebElement quantityDropdown;

    @FindBy(xpath = "//option[.='9']")
    WebElement tenPlusDropdown;

    @FindBy(xpath = "//option[.='1']")
    WebElement oneDropdown;

    @FindBy(xpath = "//div[@class='right-section']//span[@class='item-count']")
    WebElement myBasketCount;

    @FindBy(xpath = "//button[@class='btn remove-btn']")
    WebElement removeButton;

    @FindBy(xpath = "//h2[.='Need some help finding a book?']")
    WebElement titleBasketZero;

    public MyBasketPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToBasketButton() {
        addToBasketButton.click();
    }

    public void popUpItemAddedDisplayed() {
        itemAddedTitle.isDisplayed();
    }

    public void clickBasketButton() {
        basketButton.click();
    }

    public void navigateToYourBasketPage() {
        myBaksetTitle.isDisplayed();
    }

    public void clickQuantityDropdown() {
        quantityDropdown.click();
    }

    public void setHigherQuantity() {
        tenPlusDropdown.click();
    }

    public void setLowerDropdown() {
        oneDropdown.click();
    }

    public void checkHigherQuantity() {
        int high = Integer.parseInt(myBasketCount.getText());
        if (high>1) {
            System.out.println("Success! - The Quantity: " +  high);
        } else {
            driver.quit();
        }
    }

    public void checkLowerQuantity() {
        int low = Integer.parseInt(myBasketCount.getText());
        if (low==1) {
            System.out.println("Success! - The Quantity: " + low);
        } else {
            driver.quit();
        }
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public void theBookRemoved() {
        titleBasketZero.isDisplayed();
    }

}
