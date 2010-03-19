package com.tangmaowen.mis.xhzy.sms.web.struts2.stubaseinfo;

import org.springframework.beans.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.StudentBaseInfoVO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-20 下午01:53:01
 *
 */
public class InsertInfoAction extends MisXhzySmsBaseAction implements ModelDriven<StudentBaseInfoVO> {
	
	@Override
	protected String misExecute() {
		StudentBaseInfoBO bo = new StudentBaseInfoBO();
		String time = Tools.getCurrDefaultDateTime();
		BeanUtils.copyProperties(studentBaseInfo, bo);
		bo.setActive("1");
		bo.setCreater(userSession.getUserid());
		bo.setCreatetime(time);
		bo.setLastupdater(userSession.getUserid());
		bo.setLastupdatertime(time);
		String result = getMisXhzySms().insertStudentBaseInfo(bo);
		if(result.equals("")) {
			setResultInfo("{success: true, message: '新增成功'}");
		} else {
			setResultInfo("{success: false, message: '"+ result +"'}");
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "新增学生基本信息：" + Tools.getJsonStringFromObject(studentBaseInfo);
	}
	
	private StudentBaseInfoVO studentBaseInfo = new StudentBaseInfoVO();

	@Override
	public StudentBaseInfoVO getModel() {
		return studentBaseInfo;
	}
}
