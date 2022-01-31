package giacom.settings.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Profile("default")
@Configuration
@ComponentScan(basePackages = {"giacom.settings", "giacom.general"})
public class ChromeDriverBean {

    /**
     * Creates instance of {@link WebDriver} for {@link ChromeDriver}, which can be used in all tests.
     */
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--disable-web-security");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");

        String chromeDriverServerPath = "chromedriver.exe";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(chromeDriverServerPath)).getFile());

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath().replace("%20", " "));

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        return driver;
    }
}
