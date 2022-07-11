package Steps;

import PageObject.WishlistPO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishlistSteps {

    WebDriver driver = null;
    WishlistPO wishlist;

    @Before("@Wishlist")
    public void browserOpen() {
        String driverPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", driverPath + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wishlist = new WishlistPO(driver);
    }

    @After("@Wishlist")
    public void browserClose() {
        driver.close();
        driver.quit();
    }

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        driver.get("https://www.bookdepository.com/account/login/to/account");
        Thread.sleep(2000);
    }

    @When("user log in as member")
    public void user_log_in_as_member() throws InterruptedException {
        WebElement frame3 =driver.findElement(By.cssSelector(".signin-iframe"));
        driver.switchTo().frame(frame3);

        wishlist.signinMember("testerfarmacare@gmail.com","Dhiandra");

        driver.switchTo().defaultContent();
        Thread.sleep(2000);
    }

    @And("user click a book at the list")
    public void user_click_a_book_at_the_list() {
        wishlist.clickABook();
    }

    @And("user click add to wishlist button")
    public void user_click_add_to_wishlist_button() {
        wishlist.clickWishlistBtn();
    }

    @And("user fill the wishlist name with {string}")
    public void user_fill_the_wishlist_name(String wishlistName) throws InterruptedException {
        Thread.sleep(2000);
        wishlist.typeWishlistName(wishlistName);
    }

    @And("user click add button")
    public void user_click_add_button() {
        wishlist.clickAddWishlistNameButton();
    }

    @Then("user will see message item added")
    public void user_will_see_message_item_added() throws InterruptedException {
        Thread.sleep(2000);
        wishlist.wishlistCreated();
    }
}
