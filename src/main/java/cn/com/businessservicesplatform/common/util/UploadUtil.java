package cn.com.businessservicesplatform.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {

	private static UploadUtil instance = null;
	
    public static synchronized UploadUtil getInstance() {
        if (instance == null) {
            instance = new UploadUtil();
        }
        return instance;
    }
    
    /**
	 * 将上传的文件写到本地临时存储
	 * 
	 * @param uploadFile
	 *            上传文件
	 * @return 本地临时文件
	 * @throws IOException
	 */
	public String saveToLocal(MultipartFile uploadFile,String path) throws IOException {
		String resultPath = "v/business/images";
		File filePathDir = new File(path);
		if (!filePathDir.exists()) {
			filePathDir.mkdirs();
		}
		String extName = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		if (StringUtils.isBlank(extName)) {
			throw new IllegalStateException("扩展名不能为空");
		}
		String mainName = String.format("%d_%04d", System.currentTimeMillis(), new Random().nextInt(9999));
		String picName = String.format("%s.%s",mainName, extName.toLowerCase());
		resultPath = String.format("%s/%s",resultPath,picName);
		
		File dstFile = new File(String.format("%s/%s", path,picName));
		InputStream src = null;
		OutputStream dst = null;
		try {
			src = uploadFile.getInputStream();
			dst = new FileOutputStream(dstFile);
			IOUtils.copy(src, dst);
		} finally {
			IOUtils.closeQuietly(dst);
			IOUtils.closeQuietly(src);
		}
		return resultPath;
	}
}
