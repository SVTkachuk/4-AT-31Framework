package BrowserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
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
//                    System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
                    WebDriverManager.edgedriver().setup();
                    INSTANCE.set(new EdgeDriver());
                    break;
                default:
                    System.out.println("Wrong browser");
            }

        }
        return INSTANCE.get();
    }
}
