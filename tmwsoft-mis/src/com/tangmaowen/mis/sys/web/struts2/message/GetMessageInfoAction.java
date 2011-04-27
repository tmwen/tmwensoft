package com.tangmaowen.mis.sys.web.struts2.message;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;

/**
 * @author 唐懋文
 * @since 2010-07-30 上午09:45:06
 *
 */
public class GetMessageInfoAction extends MisSysBaseAction {

	@Override
	public String execute() {
		setLog(false);
		setVerifyRequest("login");
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		try {
			setResultInfo("{success: true, data:" + getMessageInfoByFile() + "}");
		} catch (IOException e) {
			setResultInfo("{success: false, message: '获取消息失败'}");
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "获取消息";
	}
	
	private String getMessageInfoByFile() throws IOException {
		ServletContext servletContext = (ServletContext)context.get("com.opensymphony.xwork2.dispatcher.ServletContext");
		String path = servletContext.getRealPath(Constants.MESSAGEFILE);
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String str;
			StringBuilder sb = new StringBuilder();
			while((str = in.readLine()) != null) sb.append(str + "\n");
			return sb.toString();
		} finally {
			in.close();
		}
	}

}
