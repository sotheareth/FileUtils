package file;

import java.io.File;
import java.io.IOException;

public class FileUtilTest {
	
	public static void main(String[] args) {
		
		String path = "D:/software/SQLServer2012R2.7z";
		File file = new File(path);
		long start = 0L;
		long duration = 0L;
		
		///////////////////////////////////////////
		try {
			start = System.nanoTime();
			
			FileUtil.readFileUseScanner(path);
			
			duration = System.nanoTime() - start;
			System.out.println("Time taken by Stream Copy = " + duration);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		////////////////////////////////////////
		try {
			start = System.nanoTime();
			
			FileUtil.readFileUseCommonApache(file);
			
			duration = System.nanoTime() - start;
			System.out.println("Time taken by Stream Copy = " + duration);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
