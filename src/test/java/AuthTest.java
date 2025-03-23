import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;

public class AuthTest {
    @Test
    @Disabled("Не законченный")
     void authTest() {
        // Загружаем properties-файл
        Properties properties = new Properties();
        try (InputStream input = AuthTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось загрузить config.properties", e);
        }

        // Получаем логин и пароль
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        // Используем логин и пароль для авторизации
        Selenide.open("https://" + username + ":" + password + "@example.com");
    }
}