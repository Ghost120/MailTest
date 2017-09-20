package ru.kasyan.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.pagefactory.support.ScreenShooter;

/**
 * Created by Kasyanenko Konstantin
 * on 19.09.2017.
 */
public class StepDefs {
    private static final Logger LOG = LoggerFactory.getLogger(StepDefs.class);

    @When("^пользователь открывает письмо от \"(.*)\" с темой \"(.*)\"$")
    public void onenLetter(String email, String tema) {
        LOG.info("email: " + email);
        LOG.info("тема: " + tema);
        String xpath = String.format("//span[@title='%s']/../../..//span[@title='%s']", email, tema);
        WebElement message = (new WebDriverWait(PageFactory.getDriver(), 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        ScreenShooter.takeWithDriver();
        message.click();
    }

    @Then("^пользователь проверет текст \"(.*)\" на элементе \"(.*)\"$")
    public void checkText(String text, String nameElement) throws PageException {
        String valueElement = getTextToElement(nameElement);
        LOG.info("Ожидаемый текст: ", text);
        Assert.assertEquals("Текст не совпал", text, valueElement);
    }

    @Then("^пользователь проверет что текст \"(.*)\" содержится на элементе \"(.*)\"$")
    public void checkTextContains(String text, String nameElement) throws PageException {
        String valueElement = getTextToElement(nameElement);
        LOG.info("Ожидаемый текст: ", text);
        Assert.assertTrue("Текст не совпал", valueElement.contains(text));
    }

    private String getTextToElement(String element) throws PageException {
        String valueElement = PageFactory.getInstance().getCurrentPage().getElementByTitle(element).getText();
        LOG.info("Текст на элементе: " + valueElement);
        return valueElement;
    }

}
