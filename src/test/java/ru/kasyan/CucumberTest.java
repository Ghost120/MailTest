package ru.kasyan;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import ru.sbtqa.tag.cucumber.TagCucumber;

/**
 * Created by Kasyanenko Konstantin
 * on 19.09.2017.
 */
@RunWith(TagCucumber.class)
@CucumberOptions(monochrome = true, format = {"pretty"},
        glue = {"ru.sbt.webdriver.stepdefs", "ru.sbtqa.tag.pagefactory.stepdefs", "ru.kasyan.stepdefs"},
        features = {"src/test/resources/features/"},
        tags = {"@smokeTest"})
public class CucumberTest {

}
