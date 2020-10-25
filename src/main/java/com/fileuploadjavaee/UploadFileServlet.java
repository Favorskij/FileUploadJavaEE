package com.fileuploadjavaee;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@WebServlet(name = "/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {

        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());

        try {
            List <FileItem> multiFiles = fileUpload.parseRequest(request);
            for (FileItem fileItem : multiFiles) {

                try {
                    fileItem.write(new File("D:\\GitHub\\Favorskij\\FileUploadJavaEE\\src\\main\\webapp\\resouces\\" + fileItem.getName()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
}
