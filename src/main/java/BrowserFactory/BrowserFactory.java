package BrowserFactory;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BrowserFactory {
    private static final ThreadLocal<WebDriver> INSTANCE= new InheritableThreadLocal<>();

    public static WebDriver getDriver(String browser){
        if(INSTANCE.get()==null){
            switch (browser)
            {
                case "Chrome":
                    ChromeDriverManager.getInstance().setup();
                    INSTANCE.set(new ChromeDriver());
                    break;
                case "Edge":
                    System.setProperty("webdriver.edge.driver","src/drivers/msedgedriver.exe");
                    INSTANCE.set(new EdgeDriver());
                    break;
                default:
                    System.out.println("Wrong browser");
            }

        }
        return INSTANCE.get();
    }
}
