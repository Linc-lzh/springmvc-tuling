package cn.tulingxueyuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 上传：
 *    会将文件上传到三个地方：
 *      1.项目路径（适用项目小，上传使用率低）
 *      2.磁盘路径 ，这种方式需要通过虚拟目录的映射
 *      3.静态资源服务器（CDN）
 */
@Controller
public class UploadController {

    /**
     * 基于springmvc MultiPartResolver文件上传
     * @param desc
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @PostMapping("/upload01")
    public String upload01(String desc, @RequestParam("myfile") MultipartFile multipartFile, Model model) throws  IOException {

        System.out.println(desc);
        System.out.println(multipartFile.getOriginalFilename());
        String path = "D:\\out\\" + multipartFile.getOriginalFilename();
        File file = new File(path);
        multipartFile.transferTo(file);
        // 上传后添加文件名到域中
        model.addAttribute("filename",multipartFile.getOriginalFilename());
        return "success";
    }

    /**
     * 基于springmvc MultiPartResolver多文件文件上传
     * @param desc
     * @param myfile
     * @return
     * @throws IOException
     */
    @PostMapping("/upload02")
    public String upload02(String desc,MultipartFile[] myfile) throws  IOException {

        for (MultipartFile multipartFile : myfile) {
            System.out.println(desc);
            System.out.println(multipartFile.getOriginalFilename());
            String path = "D:\\out\\" + multipartFile.getOriginalFilename();
            File file = new File(path);
            multipartFile.transferTo(file);
        }
        return "success";
    }


    /**
     * 基于springmvc MultiPartResolver多文件文件上传--多线程
     * @param desc
     * @param myfile
     * @return
     * @throws IOException
     */
    @PostMapping("/upload03")
    public String upload03(String desc,MultipartFile[] myfile) throws IOException, InterruptedException {

        System.out.println(desc);
        for (MultipartFile multipartFile : myfile) {
            // 声明线程
            Thread thread = new Thread(() -> {
                System.out.println(multipartFile.getOriginalFilename());
                String path = "D:\\out\\" + multipartFile.getOriginalFilename();
                File file = new File(path);
                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();   //启动线程
            thread.join();   // 让子线程执行完再执行主线程
        }
        return "success";
    }

}
