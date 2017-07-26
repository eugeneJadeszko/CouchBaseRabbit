package by.intexsoft.billing.util.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.intexsoft.billing.util.Utility;

public class FileUtilityImpl implements Utility {

	@Override
	public void write(String dirPath, String fileName, String text, boolean append) {
		File file = new File(dirPath, fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (FileWriter writer = new FileWriter(file, append)) {
			writer.write(text);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String read(String dirPath, String fileName) {
		File file = new File(dirPath, fileName);
		if (!file.exists())
			return "file not found";
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			String s;
			while ((s = in.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

	@Override
	public boolean delete(String dirPath, String fileName) {
		File file = new File(dirPath, fileName);
		if (!file.exists())
			return false;
		file.delete();
		return true;
	}

	@Override
	public boolean move(String sourcePath, String fileName, String targetPath) {
		String text = read(sourcePath, fileName);
		if (text != "file not found") {
			write(targetPath, fileName, text, false);
		} else
			return false;
		if (!delete(sourcePath, fileName)) {
			return false;
		}
		return true;
	}
}
