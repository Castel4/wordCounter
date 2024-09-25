package com.lumu.test.questions;

import com.lumu.test.ui.WordCounterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class KeywordDensity implements Question<String> {

    private final String keyword;

    public KeywordDensity(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String answeredBy(Actor actor) {
        String densityText = WordCounterPage.WORD_DENSITY.of(keyword).resolveFor(actor).getText();
        System.out.println("desidad " + densityText);
        String percentage = densityText.split(" ")[1].replace("(", "").replace("%)", "");
        System.out.println("porcentaje" + percentage);
        return percentage;
    }

    public static KeywordDensity of(String keyword) {
        return new KeywordDensity(keyword);
    }
}
