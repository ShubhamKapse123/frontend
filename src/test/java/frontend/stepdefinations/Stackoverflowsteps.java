package frontend.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stackoverflowsteps {
	WebDriver driver;
	int maxEditCount = 0;
	@Given("I lauch chrom browser")
	public void i_lauch_chrom_browser() {
		System.setProperty("webdriver.chrome.driver","G:\\MyData@2022-23\\frontend\\chromedriver.exe");// change the path as per your system
		driver= new ChromeDriver();	
	}

	@Given("I open the stackoverflow page")
	public void i_open_the_stackoverflow_page() {
		driver.get("https://stackoverflow.com/");
	}

	@When("Page is open i want to go  browser question section")
	public void page_is_open_i_want_to_go_browser_question_section() {
	  driver.findElement(By.xpath("//a[@class='s-topbar--menu-btn js-left-sidebar-toggle']")).click();
	  String actual= driver.findElement(By.xpath("//a[@id='nav-questions']")).getText();
	  String expected="Questions";
	 
	  Assert.assertEquals(actual, expected);
	driver.findElement(By.xpath("//a[@id='nav-questions']")).click();
	Assert.assertEquals("All Questions", driver.findElement(By.xpath("//h1[@class='flex--item fl1 fs-headline1 mr12 mb12']")).getText());
	}

	@When("Click on the users in the left section")
	public void click_on_the_users_in_the_left_section() {
		driver.findElement(By.xpath("//div[contains(text(),'Users')]")).click();
		Assert.assertEquals("Users",driver.findElement(By.xpath("//h1[@class='fs-headline1 mb24']")).getText());	
	}

	@Then("Click on editors")
	public void click_on_editors() {
		driver.findElement(By.xpath("//a[@title='Users who edited at least 5 posts']")).click();
		Assert.assertTrue(driver.findElement(By.className("user-tags")).getText().contains("edits"));
	}

	@Then("Get the user name which has the max number of edits count")
	public void get_the_user_name_which_has_the_max_number_of_edits_count() {
        String maxEditUsername = "";

        // Iterate through each user row in the table
        for (WebElement userRow : driver.findElements(By.cssSelector(".user-info-container"))) {
            String username = userRow.findElement(By.cssSelector(".user-details a")).getText();
            int editCount = Integer.parseInt(userRow.findElement(By.cssSelector(".reputation-score span")).getText().replace(",", ""));

            // Check if the current user's edit count is greater than the maximum edit count
            if (editCount > maxEditCount) {
                maxEditCount = editCount;
                maxEditUsername = username;
            }
        }
	}

	@Then("Get the user name location edits count in next page")
	public void get_the_user_name_location_edits_count_in_next_page() {
		
        String maxEditUsername = "";

        // Iterate through each user row in the table to find the user with the maximum edit count
        for (WebElement userRow : driver.findElements(By.cssSelector(".user-info-container"))) {
            String username = userRow.findElement(By.cssSelector(".user-details a")).getText();
            int editCount = Integer.parseInt(userRow.findElement(By.cssSelector(".reputation-score span")).getText().replace(",", ""));

            // Check if the current user's edit count is greater than the maximum edit count
            if (editCount > maxEditCount) {
                maxEditCount = editCount;
                maxEditUsername = username;
            }
        }
		// Click on the username of the user with the maximum edit count to go to their profile page
        driver.findElement(By.linkText(maxEditUsername)).click();

        // Find and print the username, location, and edits count on the user's profile page
        String userProfileUsername = driver.findElement(By.cssSelector(".user-card-name a")).getText();
        String userProfileLocation = driver.findElement(By.cssSelector(".user-card-location")).getText();
        String userProfileEditsCount = driver.findElement(By.cssSelector(".s-badge__count")).getText();

        System.out.println("Username: " + userProfileUsername);
        System.out.println("Location: " + userProfileLocation);
        System.out.println("Edits Count: " + userProfileEditsCount);

        // Close the WebDriver
        driver.quit();
	}

}
