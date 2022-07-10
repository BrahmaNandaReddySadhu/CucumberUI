package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	/*
	 * Initialise the Properties values
	 */
	private Properties prop;

	public Properties init_proper() {
		prop = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fileInputStream);

		} catch (IOException e) {
			System.out.println(" Error Occured during the Property file Reading");
			e.printStackTrace();
		}

		return prop;
	}

}
