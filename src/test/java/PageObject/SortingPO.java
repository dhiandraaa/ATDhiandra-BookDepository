package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortingPO {

    WebDriver driver;

    public SortingPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//input[@name='searchTerm']")
    private WebElement searchBar;

    @FindBy(xpath = "//span[@class='text']")
    private WebElement searchButton;

    @FindBy(xpath = "//h1[contains(.,'Search results for tree')]")
    private WebElement searchResult;

    @FindBy(xpath = "//form[@class='form-inline pull-left search-filter-dropdown']")
    private WebElement selectDropdown;

    @FindBy(xpath = "//option[.='Price, low to high']")
    private WebElement selectLowToHigh;

    @FindBy(xpath = "//a[contains(.,'Shrubs and Trees')]")
    private WebElement lowestBook;

    /**
     * user click on the search bar
     */
    public void clickSearchBar() {
        searchBar.click();
    }

    /**
     * user type the keyword
     *
     * @param keyword
     */
    public void typeOnSearchBar(String keyword) {
        searchBar.sendKeys(keyword);
    }

    /**
     * user click on the search button
     */
    public void clickSearchBtn() {
        searchButton.click();
    }

    /**
     * user is navigated to search result page
     */
    public void navigateToResultPage() {
        searchResult.isDisplayed();
    }

    /**
     * user click on sort by dropdown
     */
    public void clickDropdown() {
        selectDropdown.click();
    }

    /**
     * user select on Price, low to high
     */
    public void clickLowToHigh() {
        selectLowToHigh.click();
    }

    /**
     * user will see the cheapest book is at the top of the list
     */
    public void lowestBookDisplayed() {
        lowestBook.isDisplayed();
    }
}
