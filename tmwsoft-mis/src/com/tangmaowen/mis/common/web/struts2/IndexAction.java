package com.tangmaowen.mis.common.web.struts2;

import java.util.List;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.AuthorityBO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午12:36:52
 *
 */
public class IndexAction extends BaseAction {

	@Override
	public String execute() {
		setAjax(false);
		setLog(false);
		setVerifyRequest("login");
		return super.execute();
	}

	@Override
	protected String misExecute() {
		username = userSession.getUsername();
		userid = userSession.getUserid();
		setMenu();
//		menu = "[";
//		menu += "{mainItem:0,items:[{xtype:'portal',title:'学生管理',html:'<img src=" + Constants.WEBROOT + "/resources/images/mis/xhzy/sms/stu.jpg style=width:700px;height:1000px;margin-top:0px;/>'}";
//		menu += ",{title:'学生基本信息',layout:'fit',iconCls:'x-icon-11',html:'<iframe id=studentsBaseInfoIndex scrolling=auto frameborder=0 width=100% height=100% src=" + Constants.WEBROOT + "/mis/xhzy/sms/studentsBaseInfoIndex." + Constants.EXTENSION + "></iframe>'}";
//		menu += "]}";
//		menu += ",{expanded:true,items:[{title:'系统管理',html:'系统管理'}";
//		menu += ",{title:'用户管理',iconCls:'x-icon-21',style:'padding: 10px;',html:'<iframe id=usersIndex scrolling=auto frameborder=0 width=100% height=100% src=${webroot}/mis/sys/usersIndex.${extension}></iframe>'}";
//		menu += "]}";
//		menu += "]";
		return Constants.MAINFRAME;
	}
	
	private void setMenu() {
		List<AuthorityBO> menuList = getMisComm().getAuth(Constants.MENUAUTHCODE);
		if(!Tools.isEmpty(menuList)) {
			StringBuilder stu = new StringBuilder();
			StringBuilder sys = new StringBuilder();
			for(int i = 0; i < menuList.size(); i++) {
				if(userSession.getAuthoritys().indexOf(menuList.get(i).getAuthid()) == -1) continue;
				if(menuList.get(i).getAuthdesc().equals("学生管理")) {
					if(stu.length() == 0) stu.append("{mainItem:0,items:[{xtype:'portal',title:'学生管理',html:'<img src=" + Constants.WEBROOT + "/resources/mis/xhzy/sms/images/stu_index.jpg style=width:1280px;/>'}");
					stu.append(getTree(menuList.get(i)));
				} else {
					if(sys.length() == 0) sys.append("{expanded:true,items:[{title:'系统管理',html:'<img src=" + Constants.WEBROOT + "/resources/mis/xhzy/sms/images/sys_index.jpg style=width:1280px;/>'}");
					sys.append(getTree(menuList.get(i)));
				}
			}
			if(stu.length() != 0) stu.append("]}");
			if(sys.length() != 0) sys.append("]}");
			if(stu.length() != 0 && sys.length() != 0) {
				stu.append(",");
			}
			if(stu.length() != 0 || sys.length() != 0) {
				menu = "[" + stu.toString() + sys.toString() + "]";
			}
		} 
		if(Tools.isNull(menu)) {
			menu = "[{mainItem: 0,items:[{xtype: 'portal',title: '无权限'}]}]";
		}
	}
	
	private String getTree(AuthorityBO bo) {
		return ",{title:'" + bo.getAuthname() + "',layout:'fit',iconCls:'aaa'," +
				"html:'<iframe id=" + bo.getAuthid() + " scrolling=auto frameborder=0 width=100% height=100% src=" + Constants.WEBROOT + bo.getAuthid() + "." + Constants.EXTENSION + "></iframe>'}";
	}

	@Override
	protected String actionInfo() {
		return "跳转到主页面";
	}
	
	private String menu;
	private String username;
	private Integer userid;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
}
