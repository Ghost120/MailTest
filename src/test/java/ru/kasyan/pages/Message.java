package ru.kasyan.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Письмо")
public class Message extends BasePage {

    @ElementTitle("Отправитель")
    @FindBy(xpath = "//span[contains (@class,'mail-Message-Sender-Email')]")
    public WebElement sender;

    @ElementTitle("Тема")
    @FindBy(xpath = "//div[contains(@class, 'mail-Message-Toolbar')]")
    public WebElement subject;

    @ElementTitle("Содержание письма")
    @FindBy(xpath = "//div[contains(@class, 'b-message-body__content')]")
    public WebElement contentOfLetter;

    public Message() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

}
