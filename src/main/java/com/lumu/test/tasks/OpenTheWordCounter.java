package com.lumu.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheWordCounter implements Task {

    private String wordCounterPage;

    public OpenTheWordCounter(String wordCounterPage) {
        this.wordCounterPage = wordCounterPage;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(wordCounterPage));
    }

    public static OpenTheWordCounter page(String wordCounterPage) {
        return instrumented(OpenTheWordCounter.class, wordCounterPage);
    }
}