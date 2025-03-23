import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;

import static com.codeborne.selenide.Selenide.open;


public class BaseTest {

    @BeforeAll
    static void baseTest () {
        Configuration.browser = "chrome";
        Configuration.downloadsFolder = "G:\\Git\\JAVA\\UITestProject\\src\\test\\resources\\Downloads";
        Configuration.fileDownload = FileDownloadMode.FOLDER;
    }

    @BeforeEach
    void beforeEach () {
        baseUrl = "https://the-internet.herokuapp.com";
        open(baseUrl);
    }

    @AfterEach
    void afterAllCases () {
        Selenide.closeWebDriver();
    }
}
