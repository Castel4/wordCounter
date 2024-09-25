package com.lumu.test.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import static com.lumu.test.ui.WordCounterPage.WRITE_WORD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WriteWord implements Interaction{
    private String text;

    public WriteWord(String text) {
        this.text = text;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (text == null || text.trim().isEmpty()) {
            text = " ";
        }
        String[] lines = text.split("-");
        actor.attemptsTo(Clear.field(WRITE_WORD));
        for (String line : lines) {
            actor.attemptsTo(
                    SendKeys.of(line).into(WRITE_WORD),
                    SendKeys.of(Keys.RETURN).into(WRITE_WORD)
            );
        }

    }

    public static WriteWord intoWordCounter(String text) {
        return instrumented(WriteWord.class, text);
    }
}
