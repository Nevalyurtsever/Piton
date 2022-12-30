package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String formattedDate = date.format(dtf);

        File allPageFoto = new File("target/screenshots/allpage" + formattedDate + ".jpeg");
        File temporaryFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(temporaryFile, allPageFoto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
