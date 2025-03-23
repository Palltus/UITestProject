
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BasicAuthTest extends BaseTest {
    @DisplayName("Простая авторизация")
    @Test
    void authTest()  {
        step("Проверка успешной авторизации", () -> {
            open("https://admin:admin@the-internet.herokuapp.com/basic_auth");
            $(".example").shouldHave(text("Congratulations! You must have the proper credentials."));
        });
    }
}
