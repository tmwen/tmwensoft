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
public class UpdateStuInfoByFee extends MisXhzySmsBaseAction implements ModelDriven<StudentBaseInfoByFeeVO> {

	@Override
	protected String misExecute() {
		StudentBaseInfoBO bo = getMisXhzySms().getStudentBaseInfo(studentBaseInfoByFee.getStuid());
		BeanUtils.copyProperties(studentBaseInfoByFee, bo);
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
		return "更新学生：" + studentBaseInfoByFee.getStuid() + "的费用信息 " + Tools.getJsonStringFromObject(studentBaseInfoByFee);
	}
	
	private StudentBaseInfoByFeeVO studentBaseInfoByFee = new StudentBaseInfoByFeeVO();

	@Override
	public StudentBaseInfoByFeeVO getModel() {
		return studentBaseInfoByFee;
	}
}
