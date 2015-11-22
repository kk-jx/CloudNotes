package com.mjl.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alvin on 15/11/22.
 */
public class FileNameChange {

    public String Change(String userName,String uploadname){
        StringBuffer sb = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMDDhhmmss");
        Date now = new Date();
        String nowstring = simpleDateFormat.format(now);
        sb.append(userName+"/");
        sb.append(nowstring+"/");
        sb.append(uploadname);
        return sb.toString();
    }
}
