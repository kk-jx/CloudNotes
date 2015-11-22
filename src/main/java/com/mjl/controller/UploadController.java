package com.mjl.controller;

import com.mjl.Util.FileNameChange;
import com.mjl.model.po.Upload;
import com.mjl.model.vo.ResultResponse;
import com.mjl.service.UploadServiceI;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Alvin on 15/11/22.
 */
@RequestMapping(value = "upload")
public class UploadController {

    @Resource
    UploadServiceI uploadServiceI;

    @RequestMapping(value = "{username}/{uploadname}")
    public ResultResponse addUploadFile(@PathVariable String uploadname,@PathVariable String username,int userid){
        Upload upload = new Upload();
        ResultResponse res = new ResultResponse();
        FileNameChange fnc = new FileNameChange();
        String fileurl = fnc.Change(username,uploadname);
        upload.setUploadUserId(userid);
        upload.setUploadUrlList(fileurl);
        upload.setUploadCreateTime(new Timestamp(new Date().getTime()));
        res.setStatus(1);
        res.setMessage("上传成功!");
        return  res;

    }

}
