package frontend.stepdefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stackoverflowsteps {
	WebDriver driver;
	@Given("I lauch chrom browser")
	public void i_lauch_chrom_browser() {
		System.setProperty("webdriver.chrome.driver","G:\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();	
	}

	@Given("I open the stackoverflow page")
	public void i_open_the_stackoverflow_page() {
		//driver.get("https://stackoverflow.com/");
	}

	@When("Page is open i want to go  browser question section")
	public void page_is_open_i_want_to_go_browser_question_section() {
	  // driver.findElement(By.xpath("//a[@class='s-topbar--menu-btn js-left-sidebar-toggle']")).click();
	}

	@When("Click on the users in the left section")
	public void click_on_the_users_in_the_left_section() {
	
	}

	@Then("Click on editors")
	public void click_on_editors() {
	
	}

	@Then("Get the user name which has the max number of edits count")
	public void get_the_user_name_which_has_the_max_number_of_edits_count() {
	    
	}

	@Then("Get the user name location edits count in next page")
	public void get_the_user_name_location_edits_count_in_next_page() {
	    
	}

}
