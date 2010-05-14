package com.tangmaowen.mis.sys.web.struts2.message;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.web.MessageVO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

public class UpdateMessageAction extends MisSysBaseAction implements ModelDriven<MessageVO> {
	
	@Override
	protected String misExecute() {
		String out = "{success: true, data:" + Tools.getJsonStringFromObject(message) + "}";
		System.out.println(out);
		try {
			saveInfo(out);
			setResultInfo("{success: true, message: '保存成功'}");
		} catch (IOException e) {
			setResultInfo("{success: false, message: '保存失败'}");
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "更新消息 状态:" + message.getActive() + "内容:" + message.getInfo();
	}
	
	private void saveInfo(String info) throws IOException {
		ServletContext servletContext = (ServletContext)context.get("com.opensymphony.xwork2.dispatcher.ServletContext");
		String path = servletContext.getRealPath("/upload/message.txt");
//		PrintWriter out = null;
//		try {
//			out = new PrintWriter(new BufferedWriter(new FileWriter(path)));
//			out.write(info);
//		} finally {
//			out.close();
//		}
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(path));
			out.write(info.getBytes("UTF-8"));
		} finally {
			out.close();
		}
	}
	
	private MessageVO message = new MessageVO();

	@Override
	public MessageVO getModel() {
		return message;
	}
}
