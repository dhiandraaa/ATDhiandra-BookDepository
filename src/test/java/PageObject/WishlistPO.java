package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPO {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement emailSignin;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passSignin;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement signinButton;

    @FindBy(xpath = "//a[contains(.,'Great Circle')]")
    WebElement aBook;

    @FindBy(xpath = "//a[contains(.,'Add to wishlist')]")
    WebElement wishlistButton;

    @FindBy(xpath = "//input[@name='wishlistLabel']")
    WebElement wishlistNameTextbox;

    @FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
    WebElement addWishlistNameButton;

    @FindBy(xpath = "//a[contains(.,'Go to')]")
    WebElement successAddWishlistButton;

    public WishlistPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signinMember(String email, String pass) {
        emailSignin.sendKeys(email);
        passSignin.sendKeys(pass);
        signinButton.click();
    }

    public void clickABook() {
        aBook.click();
    }

    public void clickWishlistBtn() {
        wishlistButton.click();
    }

    public void typeWishlistName(String wishlistName) {
        wishlistNameTextbox.sendKeys(wishlistName);
    }

    public void clickAddWishlistNameButton() {
        addWishlistNameButton.click();
    }

    public void wishlistCreated() {
        successAddWishlistButton.isDisplayed();
    }
}
