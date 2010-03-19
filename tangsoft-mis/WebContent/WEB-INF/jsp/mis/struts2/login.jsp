<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/IncludeTop.jspf" %>
<%@ include file="common/login.jspf" %>
<style type="text/css">
body{
background: #000000 url('${webroot}/resources/mis/xhzy/sms/images/index.jpg') no-repeat center top;
}
</style>
<script type="text/javascript">
//<![CDATA[
Ext.onReady(function() {
	Ext.QuickTips.init();
    Ext.form.Field.prototype.msgTarget = 'side';
    loginWindow.plain = true;
	loginWindow.modal = false;
	loginWindow.pageX = 200;
	loginWindow.pageY = 240;
	loginWindow.show();
});
//]]>
</script>
<noscript>
<h2><br><br><br><br><br><br><br><br><br><br><br><br>该浏览器已禁用JavaScript!<br>该系统需要使用JavaScript，请在设置中启用JavaScript!</h2>
</noscript>
<%@ include file="common/IncludeBottom.jspf" %>