package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Utils {

	final static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HHmmss");

	public static void takeEvidence(WebDriver driver, String nameMethod) throws IOException {
		Date date = new Date();
		String folderName = "output";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File outputfile = new File("output/evidence_" + nameMethod + dateFormat.format(date) + ".png");
		new File(folderName).mkdirs();
		Files.copy(scrFile, outputfile);
	}

}
