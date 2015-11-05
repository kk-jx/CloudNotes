package com.mjl.controller;

import com.mjl.model.po.Note;
import com.mjl.model.po.User;
import com.mjl.model.vo.ResultResponse;
import com.mjl.service.NoteServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alvin on 15/11/4.
 */
@Controller
@RequestMapping(value = "/note")
public class NoteController {

    @Resource
    NoteServiceI noteServiceI;

    @RequestMapping(value = "listNotes-{userName}" ,method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse ListAllNotes(@PathVariable String userName){
        User dbuser = noteServiceI.ListAllNotesByUserName(userName);
        List<Note> noteList = dbuser.getNotes();
        ResultResponse res = new ResultResponse();
        res.setStatus(1);
        res.setMessage("查询成功");
        res.setData(noteList);
        return res;
    }
}
