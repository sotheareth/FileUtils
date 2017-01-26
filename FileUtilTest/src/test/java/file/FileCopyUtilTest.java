package file;

import java.io.File;

public class FileCopyUtilTest {

	public static void main(String[] args) {

		try {
			long start = 0L;
			long end = 0L;
			
			File source = new File("D:/software/eclipse-jee-luna-SR2-win32-x86_64.zip");
			File dest = new File("D:/software/copyTest/eclipse-jee-luna-SR2-win32-x86_64_1.zip");
	
			// copy file using FileStreams
			start = System.nanoTime();
			CopyFileUtil.copyFileUsingFileStreams(source, dest);
			System.out.println("Time taken by FileStreams Copy = "
					+ (System.nanoTime() - start));
	
			// copy files using java.nio.FileChannel
			source = new File("D:/software/eclipse-jee-luna-SR2-win32-x86_64.zip");
			dest = new File("D:/software/copyTest/eclipse-jee-luna-SR2-win32-x86_64_2.zip");
			start = System.nanoTime();
			CopyFileUtil.copyFileUsingFileChannels(source, dest);
			end = System.nanoTime();
			System.out.println("Time taken by FileChannels Copy = " + (end - start));
	
			// copy file using Java 7 Files class
			source = new File("D:/software/eclipse-jee-luna-SR2-win32-x86_64.zip");
			dest = new File("D:/software/copyTest/eclipse-jee-luna-SR2-win32-x86_64_3.zip");
			start = System.nanoTime();
			CopyFileUtil.copyFileUsingJava7Files(source, dest);
			end = System.nanoTime();
			System.out.println("Time taken by Java7 Files Copy = " + (end - start));
	
			// copy files using apache commons io
			source = new File("D:/software/eclipse-jee-luna-SR2-win32-x86_64.zip");
			dest = new File("D:/software/copyTest/eclipse-jee-luna-SR2-win32-x86_64_4.zip");
			start = System.nanoTime();
			CopyFileUtil.copyFileUsingApacheCommonsIO(source, dest);
			end = System.nanoTime();
			System.out.println("Time taken by Apache Commons IO Copy = " + (end - start));
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
