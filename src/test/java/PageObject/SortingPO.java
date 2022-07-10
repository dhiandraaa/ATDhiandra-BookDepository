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
    WebElement searchBar;

    @FindBy(xpath = "//span[@class='text']")
    WebElement searchButton;

    @FindBy(xpath = "//h1[contains(.,'Search results for tree')]")
    WebElement searchResult;

    @FindBy(xpath = "//form[@class='form-inline pull-left search-filter-dropdown']")
    WebElement selectDropdown;

    @FindBy(xpath = "//option[.='Price, low to high']")
    WebElement selectLowToHigh;

    @FindBy(xpath = "//a[contains(.,'Shrubs and Trees')]")
    WebElement lowestBook;

    public void clickSearchBar() {
        searchBar.click();
    }

    public void typeOnSearchBar(String keyword) {
        searchBar.sendKeys(keyword);
    }

    public void clickSearchBtn() {
        searchButton.click();
    }

    public void navigateToResultPage() {
        searchResult.isDisplayed();
    }

    public void clickDropdown() {
        selectDropdown.click();
    }

    public void clickLowToHigh() {
        selectLowToHigh.click();
    }

    public void lowestBookDisplayed() {
        lowestBook.isDisplayed();
    }
}
