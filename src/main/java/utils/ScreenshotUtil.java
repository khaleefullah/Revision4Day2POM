package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.DriverFactory;

public class ScreenshotUtil {

	public static String captureScreenshot(String testName) {

		Date d = new Date();
		String timeStamp = d.toString().replace(" ", "_").replace(":", "_").toUpperCase();
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\" + testName + "_"
				+ timeStamp + ".png";

		TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
