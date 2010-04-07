package com.tangmaowen.mis.sys.web.struts2.users;

import org.springframework.beans.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.UserBO;
import com.tangmaowen.mis.sys.web.UserVO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-20 下午01:53:01
 *
 */
public class UpdateInfoAction extends MisSysBaseAction implements ModelDriven<UserVO> {

	@Override
	protected String misExecute() {
		UserBO bo = getMisSys().getUserInfo(user.getUserid());
		BeanUtils.copyProperties(user, bo);
		bo.setLastupdater(userSession.getUserid());
		bo.setLastupdatertime(Tools.getCurrDefaultDateTime());
		getMisSys().updateUserInfo(bo);
		setResultInfo("{success: true, message: '修改成功'}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "更新系统用户：" + user.getUserid() + "的基本信息 " + Tools.getJsonStringFromObject(user);
	}
	
	private UserVO user = new UserVO();

	@Override
	public UserVO getModel() {
		return user;
	}
}
