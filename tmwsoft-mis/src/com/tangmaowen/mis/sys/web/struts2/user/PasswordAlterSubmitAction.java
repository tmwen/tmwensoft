package com.tangmaowen.mis.sys.web.struts2.user;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.MD5;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-20 下午01:53:01
 *
 */
public class PasswordAlterSubmitAction extends MisSysBaseAction {

	@Override
	protected String misExecute() {
		if (Tools.isNull(password) || Tools.isNull(newpass) || !newpass.equals(newpasscfrm)) {
			setResultInfo("{success: false, message: '输入的密码有误'}");
			return Constants.FORWARDJSONINFO;
		}
		//验证用户名密码
		boolean ok = getMisSys().verifyPassword(userSession.getUserid(), MD5.crypt(password));
		if (!ok) {
			setResultInfo("{success: false, message: '密码错误'}");
		} else {
			//验证成功
			getMisSys().passwordAlter(userSession.getUserid(), MD5.crypt(newpass));
			context.getSession().clear();
			setResultInfo("{success: true, message: '密码修改成功，请重新登录', verifyresult: 'login'}");
			return Constants.FORWARDJSONINFO;
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "用户：" + userSession.getUserid() + " 修改密码";
	}
	
	private String password;
	private String newpass;
	private String newpasscfrm;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpass() {
		return newpass;
	}
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}
	public String getNewpasscfrm() {
		return newpasscfrm;
	}
	public void setNewpasscfrm(String newpasscfrm) {
		this.newpasscfrm = newpasscfrm;
	}

}
