package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPO {

    WebDriver driver;

    public WishlistPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailSignin;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passSignin;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signinButton;

    @FindBy(xpath = "//a[contains(.,'Great Circle')]")
    private WebElement aBook;

    @FindBy(xpath = "//a[contains(.,'Add to wishlist')]")
    private WebElement wishlistButton;

    @FindBy(xpath = "//input[@name='wishlistLabel']")
    private WebElement wishlistNameTextbox;

    @FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
    private WebElement addWishlistNameButton;

    @FindBy(xpath = "//a[contains(.,'Go to')]")
    private WebElement successAddWishlistButton;

    /**
     * user type email and password on text box then click the sign-in button
     *
     * @param email
     * @param pass
     */
    public void signinMember(String email, String pass) {
        emailSignin.sendKeys(email);
        passSignin.sendKeys(pass);
        signinButton.click();
    }

    /**
     * user click on a book with Great Circle title
     */
    public void clickABook() {
        aBook.click();
    }

    /**
     * user click add to wishlist button
     */
    public void clickWishlistBtn() {
        wishlistButton.click();
    }

    /**
     * user types the name of the wishlist
     *
     * @param wishlistName
     */
    public void typeWishlistName(String wishlistName) {
        wishlistNameTextbox.sendKeys(wishlistName);
    }

    /**
     * user click add wishlist name
     */
    public void clickAddWishlistNameButton() {
        addWishlistNameButton.click();
    }

    /**
     * user has successfully added the book to the wishlist
     */
    public void wishlistCreated() {
        successAddWishlistButton.isDisplayed();
    }
}
