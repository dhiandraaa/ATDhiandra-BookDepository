package Steps;

import PageObject.SortingPO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortingSteps {

    WebDriver driver = null;
    SortingPO sorting;

    @Before("@Sorting")
    public void browserOpen() {
        String driverPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", driverPath + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sorting = new SortingPO(driver);
    }

    @After("@Sorting")
    public void browserClose() {
        driver.close();
        driver.quit();
    }

    @Given("user is on landing page")
    public void user_is_on_landing_page() throws InterruptedException {
        driver.get("https://www.bookdepository.com/");
        Thread.sleep(2000);
    }

    @When("user click on the search bar")
    public void user_click_on_the_search_bar() {
        sorting.clickSearchBar();
    }

    @And("user enter {string} into the search bar")
    public void user_enter_into_the_search_bar(String keyword) {
        sorting.typeOnSearchBar(keyword);
    }

    @And("user click on the search button")
    public void user_click_on_the_search_button() {
        sorting.clickSearchBtn();
    }

    @Then("user is navigated to search result page")
    public void user_is_navigated_to_search_result_page() {
        sorting.navigateToResultPage();
    }

    @Given("user is on search result page")
    public void user_is_on_search_result_page() throws InterruptedException {
        driver.get("https://www.bookdepository.com/search?searchTerm=tree&search=Find+book");
        Thread.sleep(3000);
    }

    @When("user click on search sort by dropdown")
    public void user_click_on_search_sort_by_dropdown() {
        sorting.clickDropdown();
    }

    @And("user click low to high price")
    public void user_click_low_to_high_price() {
        sorting.clickLowToHigh();
    }

    @Then("user will see a list of books sorted from the lowest price")
    public void user_will_see_a_list_of_books_sorted_from_the_lowest_price() {
        sorting.lowestBookDisplayed();
    }
}
