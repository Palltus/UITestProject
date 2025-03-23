import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AddOrRemoveElements extends BaseTest {

    @DisplayName("Проверка добавления")
    @Test
    void addElement() {
        step("Отрыть Add/Remove Elements", () ->
                $(byText("Add/Remove Elements")).click());

        step("Добавить элемент, кликнув по нему", () -> {
            $(byText("Add Element")).click();
            $x("//button[contains(@class, 'added-manually') and text()='Delete']")
                    .should(exist);
        });
    }

    @DisplayName("Добавление нескольких кнопок и удаление одной")
    @Test
    void manyClicks() {
        step("Отрыть Add/Remove Elements", () ->
                $(byText("Add/Remove Elements")).click());

        step("Добавить 2 элемента, кликнув по нему", () -> {

            $(byText("Add Element")).doubleClick();
        });

        step("Проверка что добавилось 2 элемента", () ->
                $$x("//button[contains(@class, 'added-manually') and text()='Delete']")
                        .shouldHave(size(2)));

        step("Удаление одного элемента", () -> {

                    ElementsCollection items = $$x("//button[contains(@class, 'added-manually') and text()='Delete']");
                    items.first().click();
                    items.shouldHave(size(1));
                }
        );
    }
}
