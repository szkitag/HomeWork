import org.checkerframework.checker.units.qual.C;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        //A driver.quit() ki lett kommentezve a BaseTest.java-ban, hogy lehessen látni a logot a futás végén
        //Nem tettem minden elem-page-frame-hez wait-et, csak ahol flaky volt a teszt
        //Nem raktam driver managert a frameworkbe, mert jelenleg egy fix 112-s verziót használok a chrome-hoz a notebookon így kézzel megadott driverrel dolgozik a framework
    }
}