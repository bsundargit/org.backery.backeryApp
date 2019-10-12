package org.backery.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataFromGuiToPropertiesFile {

	StringBuilder strBuilder;
	public static String FILEURL = "src/main/resources/dataSource.properties";
	
	public WriteDataFromGuiToPropertiesFile(StringBuilder local) {
		this.strBuilder = local;
	}
	
	public void writeDataToPropertiesFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILEURL,true));
			writer.newLine();   //Add new line
			strBuilder.append(System.lineSeparator());
		    writer.write(strBuilder.toString());
		    writer.close();
		} catch (IOException e) {
			System.out.println("Unable to write contents to the file");
		}
	}
}
