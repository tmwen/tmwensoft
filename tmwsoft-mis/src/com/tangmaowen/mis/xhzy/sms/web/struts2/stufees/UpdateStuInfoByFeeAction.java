package com.tangmaowen.mis.xhzy.sms.web.struts2.stufees;

import org.springframework.beans.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.StudentBaseInfoByFeeVO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-12-29 下午08:34:16
 *
 */
public class UpdateStuInfoByFeeAction extends MisXhzySmsBaseAction implements ModelDriven<StudentBaseInfoByFeeVO> {

	@Override
	protected String misExecute() {
		StudentBaseInfoBO bo = getMisXhzySms().getStudentBaseInfo(stuFeeInfo.getStuid());
		setJfze();
		BeanUtils.copyProperties(stuFeeInfo, bo);
		bo.setLastupdater(userSession.getUserid());
		bo.setLastupdatertime(Tools.getCurrDefaultDateTime());
		String result = getMisXhzySms().updateStudentBaseInfo(bo);
		if(result.equals("")) {
			setResultInfo("{success: true, message: '修改成功'}");
		} else {
			setResultInfo("{success: false, message: '"+ result +"'}");
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "更新学生：" + stuFeeInfo.getStuid() + "的费用信息，更新人：" + userSession.getUserid()
		+ "更新内容：" + Tools.getJsonStringFromObject(stuFeeInfo);
	}
	
	private StudentBaseInfoByFeeVO stuFeeInfo = new StudentBaseInfoByFeeVO();

	@Override
	public StudentBaseInfoByFeeVO getModel() {
		return stuFeeInfo;
	}
	
	private void setJfze() {
		double je = 0.00;
		if(stuFeeInfo.getYjfje() != null) je += stuFeeInfo.getYjfje();
		if(stuFeeInfo.getJfje() != null) je += stuFeeInfo.getJfje();
		if(stuFeeInfo.getJfje2() != null) je += stuFeeInfo.getJfje2();
		if(je == 0.00) {
			stuFeeInfo.setJfze(null);
		} else {
			stuFeeInfo.setJfze(je);
		}
	}
}
