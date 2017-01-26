package file;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/***
 * 
 * @author sotheareth.ham
 *
 */
public class ContentTypeUtil {
	
	public static final String GIF_MIME 				= "image/gif";
	public static final String TIFF_MIME 				= "image/tiff";
	public static final String XTIFF_MIME 				= "image/x-tiff";
	public static final String PNG_MIME 				= "image/png";
	public static final String JPG_MIME 				= "image/jpeg";
	public static final String ICO_MIME 				= "image/x-icon";
	public static final String XCOMPRESS_MIME 			= "application/x-compressed";
	public static final String ZIP_MIME 				= "application/zip";
	public static final String XZIP_MIME 				= "application/x-zip-compressed";
	public static final String APK_MIME 				= "application/vnd.android.package-archive";
	public static final String IOS_MIME 				= "application/x-itunes-ipa";
	public static final String OCTET_STREAM_MIME 		= "application/octet-stream";
	public static final String PLIST_MIME 				= "text/xml";
	public static final String EXCEL_MIME 				= "application/x-msdownload";
	public static final String XITUNE_MIME 				= "application/x-itunes-ipa";
	
	public static Boolean checkContentType(MultipartFile multipartFile, String... mimeTypes) {
		Boolean result = false;
		for(String mime : mimeTypes) {
			if(StringUtils.equalsIgnoreCase(mime, multipartFile.getContentType())) {
				result = true;
				break;
			}
		}
		
		return result;
	}
}
