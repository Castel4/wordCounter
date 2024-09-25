package stepdefinitions;

import com.lumu.test.interactions.WriteWord;
import com.lumu.test.tasks.OpenTheWordCounter;
import com.lumu.test.utils.WebDriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.lumu.test.ui.WordCounterPage.WORD_COUNTER;

public class WordCounterStepDefinitions {

    private Actor user;

    @Given("^the user is on the WordCounter page$")
    public void theUserIsOnTheWordCounterPage() {
        user = WebDriverSetup.createUserWithBrowser();
        user.wasAbleTo(OpenTheWordCounter.page("https://wordcounter.net/"));
    }

    @When("^the user types the text (.*)$")
    public void theUserTypesTheTextExample(String text) {
        user.attemptsTo(WriteWord.intoWordCounter(text));
    }

    @Then("^it must have the number of words (.*) and characters (.*)$")
    public void theTextShouldBeEnteredInTheWordCounterArea(String words, String characters) throws InterruptedException {
        Thread.sleep(5000);
        String[] capturedText = Text.of(WORD_COUNTER).answeredBy(user).split(" ");
        user.attemptsTo(
                Ensure.that(capturedText[0]).isEqualTo(words),
                Ensure.that(capturedText[2]).isEqualTo(characters)
        );
    }

    @After
    public void tearDown() {
        WebDriverSetup.tearDown();
    }
}

