package by.intexsoft.billing.util;

public interface Utility {
	/**
	 * Write to file (create file, if file not exist)
	 * 
	 * @param dirPath
	 *            - directory with file
	 * @param fileName
	 *            - path to file
	 * @param text
	 *            - text for write
	 * @param append
	 *            - This parameter specifies whether to overwrite the file
	 *            (false) or to add (true)
	 */
	void write(String dirPath, String fileName, String text, boolean append);

	/**
	 * The method reads and returns the contents of the file
	 * 
	 * @param dirPath
	 *            - directory with file
	 * @param fileName
	 *            - path to file
	 * @return the contents of a file in a string format or "file not found"
	 */
	String read(String dirPath, String fileName);

	/**
	 * The method deletes the file
	 * 
	 * @param dirPath
	 *            - directory with file
	 * @param fileName
	 *            - path to file
	 * @return true - if success, false - if file not exist
	 */
	boolean delete(String dirPath, String fileName);

	/**
	 * Method moves the file from one directory to another
	 * 
	 * @param sourcePath
	 *            - path to source directory
	 * @param fileName
	 *            - name of file
	 * @param targetPath
	 *            - path to target directory
	 * @return true - if success, false - if failed
	 */
	boolean move(String sourcePath, String fileName, String targetPath);
}
