package core;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static volatile ExtentReports extent;

	private ExtentManager() {

	}

	public static ExtentReports getInstance(String reportPath) {
		if (extent == null) {
			synchronized (ExtentManager.class) {
				if (extent == null) {
					Date d = new Date();
					String timeStamp = d.toString().replace(" ", "_").replace(":", "_").toUpperCase();
					String reportFile = reportPath.replace(".html", "_" + timeStamp + ".html");
					ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportFile);

					htmlReporter.config().setEncoding("utf-8");
					htmlReporter.config().setTheme(Theme.DARK);
					htmlReporter.config().setReportName("Alaska Trips Regression Suite");
					htmlReporter.config().setDocumentTitle("Revision4 Day4 1402");

					extent = new ExtentReports();
					extent.attachReporter(htmlReporter);

					extent.setSystemInfo("Environment", "QA T140");
					extent.setSystemInfo("Platform", "Windows 11");
					extent.setSystemInfo("Build Number", "CDR-1402-0742");
					extent.setSystemInfo("Tester name", "Khaleefullah");
				}
			}
		}
		return extent;
	}

	public static ExtentReports getExtent() {
		if (extent == null) {
			throw new RuntimeException("ExtentReport is not initialized. Call getInstance first.");
		}
		return extent;
	}

}
