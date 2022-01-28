package com.quyuanjin.imsevensave.controller.msg;

import com.google.gson.Gson;
import com.quyuanjin.imsevensave.constant.Constant;
import com.quyuanjin.imsevensave.pojo.AllTypeMsg;
import com.quyuanjin.imsevensave.pojo.Msg;
import com.quyuanjin.imsevensave.session.HibernateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController

public class SendMsg {
    @RequestMapping(value = "msgSave", produces = "application/json; charset=UTF-8")
    public String msgSave(HttpServletRequest request) {
        String contant = request.getParameter("contant");
       // System.out.println(contant);
        Gson gson = new Gson();
        AllTypeMsg allTypeMsg = gson.fromJson(contant, AllTypeMsg.class);
        Msg msg = allTypeMsg.getMsg();
        msg.setSendState(Constant.un_send);
        // HibernateUtil.update(msg);
        Msg msg1 = new Msg();
        msg1.setMsg(msg.getMsg());
        msg1.setMsgUUID(msg.getMsgUUID());
      // msg1.setId(8L);
        //msg.getId()
        msg.setId(null);
        HibernateUtil.add(msg);
        System.out.println(msg.toString());
//        if (!allTypeMsg.getJsonTpye().equals("")) {
//            switch (allTypeMsg.getJsonTpye()) {
//                case Constant.msg_json:
//                    Msg msg = allTypeMsg.getMsg();
//                    msg.setSendState(Constant.un_send);
//                    HibernateUtil.add(msg);
//
//                    break;
//            }
//        }


        return "ok";

    }
}
