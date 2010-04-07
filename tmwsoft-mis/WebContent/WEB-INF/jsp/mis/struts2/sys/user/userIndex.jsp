<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/IncludeTop.jspf" %>
<%@ include file="formColumn.jspf" %>
<%@ include file="passwordAlter.jspf" %>
<%@ include file="userInfoAlter.jspf" %>
<script type="text/javascript">
//<![CDATA[
	Ext.onReady(function() {
		Ext.QuickTips.init();
		Ext.form.Field.prototype.msgTarget = 'side';
		var tabs = new Ext.TabPanel( {
			region : 'center',
			activeTab : 0,
			plain : false,
			frame : true,
			defaults : {
				autoScroll : true
			}
		});
		tabs.add(pwdForm);
		tabs.add(userInfoForm);
		tabs.doLayout();

		var viewport = new Ext.Viewport( {
			layout : 'border',
			items : tabs
		});
	});
//]]>
</script>
<%@ include file="../../common/IncludeBottom.jspf" %>