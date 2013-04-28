package es.uniovi.asw.entrecine6.central.infrastructure.jdbc;

import java.io.IOException;
import java.util.Properties;

public class SQLLoader {

	private static final String CONF_FILE = "sql.properties";

	private static SQLLoader instance;
	private Properties properties;

	private SQLLoader() {
		properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(CONF_FILE));
		} catch (IOException e) {
			throw new RuntimeException("Propeties file can not be loaded", e);
		}
	}

	public static String get(String key) {
		return getInstance().getProperty(key);
	}

	private String getProperty(String key) {
		String value = properties.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Property not found in config file");
		}
		return value;
	}

	private static SQLLoader getInstance() {
		if (instance == null) {
			instance = new SQLLoader();
		}
		return instance;
	}

}