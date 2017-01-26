package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;

public abstract class DownloadFileUtil {
	
	public static void downloadFile(File target, String downloadFileName, HttpServletResponse response) throws IOException {
		
		BufferedInputStream in = null;
	    BufferedOutputStream out = null;
	    try {
	    	
	        long fileLength = target.length();
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	        response.setHeader("content-disposition", "attachment;filename=\"" + downloadFileName + "\"");
	        response.setHeader("content-length", String.valueOf(fileLength));
	        in = new BufferedInputStream(new FileInputStream(target));
	        out = new BufferedOutputStream(response.getOutputStream());
	        StreamUtils.copy(in, out);
	        response.flushBuffer();
	        
	    } finally {
	    	
	        try {
	        	in.close();
	        	in = null;				
			} catch (Exception e) {
				
	        }
	        
	        try {
	        	out.close();
	        	out = null;				
			} catch (Exception e) {
				
			}
	    }
	}
	
	public static void forceDownload(File file, String downloadFileName, HttpServletResponse response) {
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			
			inputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			
			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition","attachment; filename=" + downloadFileName);
			FileCopyUtils.copy(inputStream, outputStream);
			response.flushBuffer();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(outputStream);
		}
		
	}

}
