<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/IncludeTop.jspf" %>
<jsp:directive.page import="com.tangmaowen.mis.common.AuthorityConstants"/>
<style type="text/css">
.<%=AuthorityConstants.M_STU_BASEINFO.replace('/','a')%> {background-image: url('${webroot}/resources/shared/images/user/user.png');}
.<%=AuthorityConstants.M_STU_FEES.replace('/','a')%> {background-image: url('${webroot}/resources/shared/images/user/user_green.png');}
.<%=AuthorityConstants.M_STU_SEARCH.replace('/','a')%> {background-image: url('${webroot}/resources/shared/images/user/user_orange.png');}
.<%=AuthorityConstants.M_SYS_USERS.replace('/','a')%> {background-image: url('${webroot}/resources/shared/images/group.png');}
.<%=AuthorityConstants.M_SYS_AUTH.replace('/','a')%> {background-image: url('${webroot}/resources/shared/images/plugin.gif');}
.<%=AuthorityConstants.M_SYS_DIC.replace('/','a')%> {background-image: url('${webroot}/resources/shared/images/book.png');}
.<%=AuthorityConstants.M_SYS_LOG.replace('/','a')%> {background-image: url('${webroot}/resources/shared/images/tickets.png');}
.<%=AuthorityConstants.M_SYS_SET.replace('/','a')%> {background-image: url('${webroot}/resources/shared/images/gears.png');}
.<%=AuthorityConstants.M_SYS_USER_SET.replace('/','a')%> {background-image: url('${webroot}/resources/shared/images/cog.png');}
.logo {float:left;width:800px;height:60px;margin-top:0px;}
.rightUserState {float:right;margin-top:6px;margin-right:6px}
a {color:black;text-decoration: none;}
a:hover {color:red;text-decoration: none}
</style>
<%@ include file="common/login.jspf" %>
<script type="text/javascript">
//<![CDATA[
Ext.onReady(function() {
	Ext.QuickTips.init();
    Ext.form.Field.prototype.msgTarget = 'side';
	var viewport = new Ext.Viewport({
        layout: 'border',
        items: [
        new Ext.BoxComponent({
            region: 'north',
            height: 60,
            autoEl: {
                tag: 'div',
                html: '<div><img src="${webroot}/resources/mis/xhzy/sms/images/logo.png" class="logo"/><div class="rightUserState">'
                    + '<a href="${webroot}"><img src="${webroot}/resources/shared/images/refresh.gif"/>刷新系统</a>'
                    + '&nbsp;&nbsp;<a href="${webroot}/upload/xhzysmshelp.pdf" target="_blank"><img src="${webroot}/resources/shared/images/help.png"/>帮助</a>'
                    + '&nbsp;&nbsp;<a href="logout.${extension}"><img src="${webroot}/resources/shared/images/user/user_go.png"/>注销“${username}”</a>'
                   // + '<div id="info">有新的消息</div></div></div>'
            }
        }), {
            region: 'center',
            deferredRender: false,
            xtype: 'grouptabpanel',
    		tabWidth: 130,
    		activeGroup: 0,
    		items: Ext.decode("${menu}")
        }]
    });
    
	new Ext.ToolTip({
        target: 'info',
        anchor: 'right',
        trackMouse: true,
        html: '通知 10号开会'
    });
});
           
//]]>
</script>
<%@ include file="common/IncludeBottom.jspf" %>