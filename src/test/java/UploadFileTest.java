import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class UploadFileTest extends BaseTest{
    @DisplayName("Тестирование страницы File Upload")
    @Test
    void uploadTest () {
        step("Проверка загрузки файлов на сайт", () -> {
            File file = new File("G:\\Git\\JAVA\\UITestProject\\src\\test\\resources\\Downloads\\1742747295198_8484_1\\webdriverIO.png");
            $(byText("File Upload")).click();

            $("#file-upload").uploadFile(file);
            $("#file-submit").click();
            $("#uploaded-files").shouldBe(visible)
                    .shouldHave(text("webdriverIO.png"));
        });
    }
}
