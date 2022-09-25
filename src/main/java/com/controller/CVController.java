package com.controller;

import com.bean.CV;
import com.bean.Company;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.CVService;
import com.service.CompanyService;
import com.utils.JSONFileUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 简历控制器类
 */
@Controller
public class CVController {
    //依赖注入
    @Autowired
    private CVService cvService;
    @Autowired
    private CompanyService companyService;

    /**
     * 简历上传
     */
    @RequestMapping(value = "/CV/upload.action")
    @ResponseBody
    public String CVUpload(MultipartFile file, int com_id, int user_id) {
        Company company = companyService.getCompanyById(com_id);
        String com_name = company.getCom_name();

        if (!file.isEmpty()) {
            File file1 = new File("F:\\temp1\\" + com_name);
            if (!file1.exists()) {
                file1.mkdirs();
            }
            try {
                cvService.addCV("F:\\temp1\\" + com_name + "\\" + file.getOriginalFilename(),
                        file.getOriginalFilename(), user_id, com_id);
                file.transferTo(new File(file1, file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "uploadSuccess";
        } else {
            return "uploadFail";
        }
    }

    /*@RequestMapping("/CV/upload.action")
    @ResponseBody
    public String CVUpload(MultipartFile[] files, HttpServletRequest request, int com_id, int user_id) throws IOException {
        String path = request.getServletContext().getRealPath("/") + "files/";
        System.out.println( );
        System.out.println(files != null);
        System.out.println(files.length != 0);
        ObjectMapper mapper = new ObjectMapper();
        if (files != null && files.length != 0) {
            //循环获取上传的文件
            for (MultipartFile file : files) {
                //获取上传文件的名称
                String filename = file.getOriginalFilename();
                ArrayList<CV> list = new ArrayList<>();
                //读取file.json文件中的文件名称
                String json = JSONFileUtils.readFile(path + "/files.json");
                if (json.length() != 0) {
                    //将file.json的内容转换为集合
                    list = mapper.readValue(json, new TypeReference<List<CV>>() {
                    });
                    for (CV cv : list) {
                        //如果上传的文件在files.json中有同名的文件，将当前上传的文件重命名，以避免重名
                        if (filename.equals(cv.getCVName())) {
                            String[] split = filename.split("\\.");
                            filename = split[0] + "(1)." + split[1];
                        }
                    }
                }
                //文件保存的路径
                String filepath = path + filename;
                //System.out.println(filepath);
                //保存上传的文件
                file.transferTo(new File(filepath));
                list.add(new CV(filename));
                json = mapper.writeValueAsString(list); //将集合转换为json
                //将上传文件的名称保存在file.json文件中
                JSONFileUtils.writeFile(json, path + "/file,json");
            }
            return "uploadSuccess";
        }
        return "uploadFail";
    }*/
    @ResponseBody
    @RequestMapping("/CV/showAllCV.action")
    public List<CV> showAllCV(int com_id, Model model) {
        List<CV> list= cvService.findCVByCom_id(com_id);
        System.out.println(list);
        model.addAttribute("cv", list);
        return list;
    }


    /**
     * 简历下载
     */
    /*@RequestMapping(value = "/CV/download.action")
    public ResponseEntity<byte[]> CVDownload(HttpServletRequest request, String filename, int com_id) throws IOException {
        //下载路径
        CV cv = cvService.findCVByCom_id(com_id);
        String path = cv.getCVPath();
        System.out.println(path);
        //创建该文件对象(File.separator相当于 / )
        File file = new File(path);
        //设置消息头
        HttpHeaders headers = new HttpHeaders();
        //通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", filename);
        //定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //使用StringMVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }*/
}
