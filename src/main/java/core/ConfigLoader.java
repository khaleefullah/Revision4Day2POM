package core;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {

	private static final ThreadLocal<Properties> properties = new ThreadLocal<Properties>();

	private ConfigLoader() {

	}

	public static Properties getInstance(String filePath) {
		if (properties.get() == null) {
			synchronized (ConfigLoader.class) {
				if (properties.get() == null) {
					properties.set(new Properties());
					try (FileInputStream fis = new FileInputStream(filePath)) {
						properties.get().load(fis);
					} catch (Exception e) {
						throw new IllegalArgumentException("File not found");
					}
				}
			}
		}
		return properties.get();
	}

	public static Properties getConfig() {
		return properties.get();
	}
}
