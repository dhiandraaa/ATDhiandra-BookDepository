package Steps;

import PageObject.MyBasketPO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyBasketSteps {

    WebDriver driver = null;
    MyBasketPO mybasket;

    @Before("@MyBasket")
    public void browserOpen() {
        String driverPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", driverPath + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        mybasket = new MyBasketPO(driver);
    }

    @After("@MyBasket")
    public void browserClose() {
        driver.close();
        driver.quit();
    }

    @Given("user is in landing page")
    public void user_is_in_landing_page() throws InterruptedException {
        driver.get("https://www.bookdepository.com/");
        Thread.sleep(2000);
    }

    @When("user click add to basket on a book")
    public void user_click_add_to_basket_on_a_book() throws InterruptedException {
        mybasket.clickAddToBasketButton();
        Thread.sleep(1000);
    }

    @And("pop up item added appears")
    public void pop_up_item_added_appears() {
        mybasket.popUpItemAddedDisplayed();
    }

    @And("user click basket or checkout button")
    public void user_click_basket_or_checkout_button() {
        mybasket.clickBasketButton();
    }

    @Then("user is navigated to your basket page")
    public void user_is_navigated_to_your_basket_page() {
        mybasket.navigateToYourBasketPage();
    }

    @And("user click quantity dropdown")
    public void user_click_quantity_dropdown() {
        mybasket.clickQuantityDropdown();
    }

    @And("user click the higher value")
    public void user_click_the_higher_value() {
        mybasket.setHigherQuantity();
    }

    @Then("user will see the value beside increase the basket icon")
    public void user_will_see_the_value_beside_increase_the_basket_icon() {
        mybasket.checkHigherQuantity();
    }

    @And("user click the lower value")
    public void user_click_the_lower_value() {
        mybasket.setLowerDropdown();
    }

    @Then("user will see the value decrease beside the basket icon")
    public void user_will_see_the_value_beside_decrease_the_basket_icon() {
        mybasket.checkLowerQuantity();
    }

    @And("user click remove button")
    public void user_click_remove_button() throws InterruptedException {
        mybasket.clickRemoveButton();
        Thread.sleep(2000);
    }

    @Then("the book will disappear from the list")
    public void the_book_will_disappear_from_the_list() {
        mybasket.theBookRemoved();
    }
}
