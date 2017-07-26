package by.intexsoft.billing.service;

import java.io.File;

public interface FileManager {
	/**
	 * Method find files in target directory
	 * 
	 * @param dirPath
	 *            - path to directory with files
	 * @return Array files from target directory
	 */
	File[] getFiles(String dirPath);

	/**
	 * Method send files into queue and move it
	 */
	void SendAndMove();
}
