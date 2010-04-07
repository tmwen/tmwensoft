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
public class InsertInfoAction extends MisSysBaseAction implements ModelDriven<UserVO> {
	
	@Override
	protected String misExecute() {
		UserBO bo = new UserBO();
		String time = Tools.getCurrDefaultDateTime();
		BeanUtils.copyProperties(user, bo);
		bo.setActive(Constants.USERSTOPACTION);
		bo.setVisitcount(0);
		bo.setCreater(userSession.getUserid());
		bo.setCreatetime(time);
		bo.setLastupdater(userSession.getUserid());
		bo.setLastupdatertime(time);
		getMisSys().insertUserInfo(bo);
		setResultInfo("{success: true, message: '新增成功'}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "新增系统用户：" + Tools.getJsonStringFromObject(user);
	}
	
	private UserVO user = new UserVO();

	@Override
	public UserVO getModel() {
		return user;
	}
}
