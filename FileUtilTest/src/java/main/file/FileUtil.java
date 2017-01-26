package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import com.google.common.io.Files;

public abstract class FileUtil {
	
	/***
	 * This solution will iterate through all the lines in the file – allowing for processing of each line – without keeping references to them 
	 * – and in conclusion, without keeping them in memory: (~150 Mb consumed)
	 * 
	 * we’re going to use a java.util.Scanner to run through the contents 
	 * of the file and retrieve lines serially, one by one:
	 * @param path
	 * @throws IOException
	 */
	public static void readFileUseScanner(String path) throws IOException {
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream(path);
		    sc = new Scanner(inputStream, "UTF-8");
		    
		    while (sc.hasNextLine()) {
		       sc.nextLine();
		    }
		    
		    // note that Scanner suppresses exceptions
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		    
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
	}
	
	/***
	 * This solution will iterate through all the lines in the file 
	 * – allowing for processing of each line – without keeping references to them – and in conclusion, without keeping them in memory: (~150 Mb consumed)
	 * using the Commons IO library as well, by using the custom LineIterator provided by the library
	 * @param file
	 * @throws IOException
	 */
	public static void readFileUseCommonApache(File file) throws IOException {
		
		LineIterator it = FileUtils.lineIterator(file, "UTF-8");
		try {
			
		    while (it.hasNext()) {
		        it.nextLine();
		        // do something with line
		    }
		    
		} finally {
		    LineIterator.closeQuietly(it);
		}
		
	}
	
	/***
	 * The problem with this approach is that all the file lines are kept in memory 
	 * – which will quickly lead to OutOfMemoryError if the File is large enough.
	 * @param path
	 * @throws IOException
	 */
	public static void readFileGuava(String path) throws IOException {
		Files.readLines(new File(path), Charsets.UTF_8);
	}
	
	/***
	 * The problem with this approach is that all the file lines are kept in memory 
	 * – which will quickly lead to OutOfMemoryError if the File is large enough.
	 * @param path
	 * @throws IOException
	 */
	public static void readFileByApacheCommonIO(String path) throws IOException {
		FileUtils.readLines(new File(path));
	}
}
