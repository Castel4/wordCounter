package com.lumu.test.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class WordCounterPage {

    public static final Target WRITE_WORD = Target.the("write word")
            .locatedBy("//*[@id=\"box\"]");

    public static final Target WORD_COUNTER = Target.the("word counter")
            .located(By.cssSelector("h4 > span"));

    public static final Target WORD_DENSITY = Target.the("density of word {0}")
            .locatedBy("//span[contains(text(),'{0}')]/preceding-sibling::span[@class='badge']");

}

