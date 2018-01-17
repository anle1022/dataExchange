package gz.jszx.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
//@RequestMapping("upload")
public class UploadFilesController {
	
	@RequestMapping("/file")
	public String file(){
		return "uploadFiles";
	}
	
	@RequestMapping(value="/uploadFiles",produces="text/html;charset=utf-8")
	@ResponseBody
//	public String handleFileUpload(@RequestParam("file") MultipartFile file){
	public String handleFileUpload(HttpServletRequest request){
		MultipartFile file = null;BufferedOutputStream bos =null;
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		for (int i = 0; i < files.size(); i++) {
			file = files.get(i);
			if(!file.isEmpty()){
				try {
					bos = new BufferedOutputStream(new FileOutputStream(file.getOriginalFilename()));
					bos.write(file.getBytes());
					bos.flush();bos.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					bos = null;
					return "上传失败，"+e.getMessage();
				}
			}else
				return "请上传文件!";
		}
		return "上传成功！";
	}
}
