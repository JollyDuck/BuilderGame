package james;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {
	/**
	 * 
	 * @param nameOfFile
	 *            i.e. "./output.txt"
	 * @param data
	 *            string of what you want to write.
	 */
	public void write(String nameOfFile, String data) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(nameOfFile));
			writer.write(data);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
	}
}
