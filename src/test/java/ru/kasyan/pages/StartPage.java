package ru.kasyan.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.Map;

/**
 * Created by Kasyanenko Konstantin
 * on 19.09.2017.
 */
@PageEntry(title = "Стартовая страница")
public class StartPage extends Page {
    @ElementTitle("Логин")
    @FindBy(name = "login")
    public TextInput login;

    @ElementTitle("Пароль")
    @FindBy(name = "passwd")
    public WebElement pass;

    @ElementTitle("Войти")
    @FindBy(xpath = "//button/span[text()='Войти']/..")
    public WebElement enter;

    public StartPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }
}
