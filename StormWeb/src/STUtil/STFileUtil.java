package STUtil;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class STFileUtil {
	public static void fileDownload(HttpServletResponse resp, String oriName, String saveName, String path) {
		try {
			resp.reset();
			resp.setContentType("application/octet-stream");
			String	encoding = new String(oriName.getBytes("UTF-8"), "8859_1");
			resp.setHeader("Content-Disposition", "attachment; filename = " + encoding);
			FileInputStream	fin = new FileInputStream(path + "\\" + saveName);
			ServletOutputStream fout = resp.getOutputStream();
			while(true) {
				byte[]	 buff = new byte[1024];
				int	len = fin.read(buff);
				if(len == -1) {
					break;
				}
				fout.write(buff, 0, len);
			}
			fout.flush();
			fin.close();
			fout.close();
		}
		catch(Exception e) {System.out.println("파일다운에러"+e);
		}
	}
}
