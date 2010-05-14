<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/IncludeTop.jspf" %>
<style type="text/css">
.aaa {background-image: url('${webroot}/resources/ext/resources/images/default/s.gif');}
.logo {float:left;width:800px;height:60px;margin-top:0px;}
.rightUserState {float:right;margin-top:6px;margin-right:6px}
a {color:black;text-decoration: none;}
a:hover {color:red;text-decoration: none}
</style>
<%@ include file="common/login.jspf" %>
<%@ include file="sys/message/alertMessage.jspf" %>
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
});
           
//]]>
</script>
<%@ include file="common/IncludeBottom.jspf" %>