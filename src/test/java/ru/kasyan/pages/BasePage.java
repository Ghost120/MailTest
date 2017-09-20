package ru.kasyan.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class BasePage extends Page {

    @ElementTitle("Иконка профиля")
    @FindBy(xpath = "//div[contains(@class, 'js-user-picture')]")
    public WebElement iconProfile;

    @ElementTitle("Выход")
    @FindBy(xpath = "//div/a[contains(text(), 'Выход')]")
    public WebElement exitButton;

    public BasePage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }
}
