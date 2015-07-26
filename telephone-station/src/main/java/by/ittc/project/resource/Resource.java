package by.ittc.project.resource;

import java.util.ResourceBundle;

public class Resource {

	public static final String RESOURCE_PATH = "database";

	private static ResourceBundle resourceBundle = ResourceBundle
			.getBundle(RESOURCE_PATH);

	public static String getStr(String key) {
		return resourceBundle.getString(key);
	}

}
