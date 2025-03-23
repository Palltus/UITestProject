
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Condition.matchText;


public class ABTestingPageTest extends BaseTest {

    @DisplayName("Проверка страницы 'ABTesting'")
    @Test
    void checkABTestingPage() {

        step("Открыть страницу A/B Testing", () ->
                $(byText("A/B Testing")).click());

        step("Проверка текста заголовка", () ->
                $("h3").shouldHave(matchText(".*(A/B Test Variation 1|A/B Test Control).*")));
        step("Проверка основного текста в <p>", () ->
                $("p").shouldHave(text("Also known as split testing." +
                " This is a way in which businesses are able to simultaneously " +
                "test and learn different versions of a page to see which text and/or" +
                " functionality works best towards a desired outcome " +
                "(e.g. a user action such as a click-through).")));
        step("Проверка подписи внизу", () ->
                $(".large-4").shouldHave(text("Powered by Elemental Selenium")));
        step("Проверка ссылки в тексте 'Elemental Selenium'", () ->
                $("[target=_blank]")
                .shouldHave(attribute("href", "http://elementalselenium.com/")));

    }
}
