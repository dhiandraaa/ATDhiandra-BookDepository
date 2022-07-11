package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBasketPO {

    WebDriver driver;

    public MyBasketPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/basket/addisbn/isbn13/9781529176643']")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//h3[@class='modal-title']")
    private WebElement itemAddedTitle;

    @FindBy(xpath = "//a[.='Basket / Checkout']")
    private WebElement basketButton;

    @FindBy(xpath = "//h1[.='Your basket']")
    private WebElement myBaksetTitle;

    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement quantityDropdown;

    @FindBy(xpath = "//option[.='9']")
    private WebElement nineDropdown;

    @FindBy(xpath = "//option[.='1']")
    private WebElement oneDropdown;

    @FindBy(xpath = "//div[@class='right-section']//span[@class='item-count']")
    private WebElement myBasketCount;

    @FindBy(xpath = "//button[@class='btn remove-btn']")
    private WebElement removeButton;

    @FindBy(xpath = "//h2[.='Need some help finding a book?']")
    private WebElement titleBasketZero;

    /**
     * user click add to basket on a book
     */
    public void clickAddToBasketButton() {
        addToBasketButton.click();
    }

    /**
     * pop up item added appear
     */
    public void popUpItemAddedDisplayed() {
        itemAddedTitle.isDisplayed();
    }

    /**
     * user click on Basket/Checkout Button
     */
    public void clickBasketButton() {
        basketButton.click();
    }

    /**
     * user is navigated to Your Basket page and see Your Basket title
     */
    public void navigateToYourBasketPage() {
        myBaksetTitle.isDisplayed();
    }

    /**
     * user click on quantity dropdown
     */
    public void clickQuantityDropdown() {
        quantityDropdown.click();
    }

    /**
     * user select higher quantity
     */
    public void setHigherQuantity() {
        nineDropdown.click();
    }

    /**
     * user click lower quantitiy
     */
    public void setLowerDropdown() {
        oneDropdown.click();
    }

    /**
     * quantity on the basket icon increased
     */
    public void checkHigherQuantity() {
        int high = Integer.parseInt(myBasketCount.getText());
        if (high>1) {
            System.out.println("Success! - The Quantity: " +  high);
        } else {
            driver.quit();
        }
    }

    /**
     * quantity on the basket icon decreased
     */
    public void checkLowerQuantity() {
        int low = Integer.parseInt(myBasketCount.getText());
        if (low==1) {
            System.out.println("Success! - The Quantity: " + low);
        } else {
            driver.quit();
        }
    }

    /**
     * user click on remove button
     */
    public void clickRemoveButton() {
        removeButton.click();
    }

    /**
     * check the book should be removed from this page
     */
    public void theBookRemoved() {
        titleBasketZero.isDisplayed();
    }

}
