package stepdefinitions;

import com.lumu.test.interactions.WriteWord;
import com.lumu.test.questions.KeywordDensity;
import com.lumu.test.tasks.OpenTheWordCounter;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class keywordDensityStepDefinitions {

    private Actor user;
    private WebDriver webDriver;

    @Given("the user is on the WordCounter page2")
    public void theUserIsOnTheWordCounterPage() {
        webDriver = new ChromeDriver();
        user = Actor.named("User").can(BrowseTheWeb.with(webDriver));
        user.wasAbleTo(OpenTheWordCounter.page("https://wordcounter.net/"));
    }

    @When("the user types the text")
    public void theUserTypesTheText(String text) {
        user.attemptsTo(WriteWord.intoWordCounter(text));
    }

    @Then("the keyword densities should be:")
    public void theKeywordDensitiesShouldBe(Map<String, String> expectedDensities) {
        expectedDensities.forEach((keyword, expectedDensity) -> {
            user.should(
                    seeThat("Density for keyword " + keyword,
                            x -> expectedDensity, equalTo(KeywordDensity.of(keyword).answeredBy(user))
                    )
            );
        });
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

