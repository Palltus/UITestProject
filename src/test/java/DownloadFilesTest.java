import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DownloadFilesTest extends BaseTest{

    @DisplayName("скачивание файлов с File Download")
//    @Disabled("Пока не буду загружать файлы")
    @Test
    public void downloadFiles() {

        step("Скачивание только .png",() -> {
            $(byText("File Download")).click();
            $$("#content a").forEach(element -> {
                String href = element.attr("href");
                if (href != null && !href.isEmpty() && href.matches(".*\\.png$")) {
                    element.click();
                }
            });
            sleep(5000);
        });
    }
}
