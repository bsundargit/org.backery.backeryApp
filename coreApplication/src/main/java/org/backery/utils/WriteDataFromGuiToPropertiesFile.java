package org.backery.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Level;
import org.backery.common.BackeryConstants;
import org.backery.common.BackeryLogger;

/**
 * This method appends/writes the data from the GUI
 * to the properties file.
 * @author esxxbhs
 *
 */
public class WriteDataFromGuiToPropertiesFile {

	StringBuilder strBuilder;

	public WriteDataFromGuiToPropertiesFile(StringBuilder aInStrBuilder) {
		this.strBuilder = aInStrBuilder;
	}

	public void writeDataToPropertiesFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(BackeryConstants.PROPERTIES_FILE_URL, true));
			writer.newLine(); // Add new line
			strBuilder.append(System.lineSeparator());
			writer.write(strBuilder.toString());
			writer.close();
		} catch (IOException e) {
			BackeryLogger.log(Level.ERROR, "Unable to write contents to the properties file " + e.getMessage());
		}
	}
}
