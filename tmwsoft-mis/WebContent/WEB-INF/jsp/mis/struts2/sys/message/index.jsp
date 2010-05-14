<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/IncludeTop.jspf" %>
<%@ include file="message.jspf" %>
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
		tabs.add(messageForm);
		tabs.doLayout();

		var viewport = new Ext.Viewport( {
			layout : 'border',
			items : tabs
		});
	});
//]]>
</script>
<%@ include file="../../common/IncludeBottom.jspf" %>