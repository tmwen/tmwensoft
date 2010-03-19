<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tangmaowen.mis.common.DictConstants" %>
<%@ include file="../../common/IncludeTop.jspf" %>
<%@ include file="../../common/dictionary.jspf" %>
<%@ include file="formColumn.jspf" %>
<%@ include file="toolbar.jspf" %>
<%@ include file="userRole.jspf" %>
<script type="text/javascript">
//<![CDATA[
	var title = new Ext.Action({
        text: '',
        disabled: false
    });
    
	var indexProxy = new Ext.data.HttpProxy({ 
		autoLoad 	: true, 
		method		: 'post',
       	params		: '',
		url		 	: 'getUsersList.${extension}'
	});
	
	var indexTbar = [{
        xtype:'buttongroup',
        items: [{
        	text: '查询',
        	icon: '${webroot}/resources/shared/images/user/user.png',
        	handler: showConditionWin
        }]
    }, {
        xtype:'buttongroup',
        items: [{
            text: '新增',
            icon: '${webroot}/resources/shared/images/add.png',
            scale: 'small',
            handler: showInsertWin
        }]
    }, {
        xtype:'buttongroup',
        items: [{
            text: '修改',
            icon: '${webroot}/resources/shared/images/edit.gif',
            scale: 'small',
            handler: showUpdateWin
        }]
    }, {
        xtype:'buttongroup',
        items: [{
            text: '查看',
            icon: '${webroot}/resources/shared/images/new_tab.gif',
            scale: 'small',
            handler: showViewWin
        }]
    }, {
        xtype:'buttongroup',
        items: [{
            text: '停用/启用',
            icon: '${webroot}/resources/shared/images/connect.png',
            scale: 'small',
            handler: function(){
            	if (!isRecordClick()) return;
            	var requestConfig = {
					url: 'changeUserActive.${extension}',
					params: {userid:recordData.userid},
					success: function(response, opts) {
    					indexStore.reload();
					}
                };
            	var result = Ext.Ajax.request(requestConfig);
            }
        }]
    }, {
        xtype:'buttongroup',
        items: [{
            text: '角色',
            icon: '${webroot}/resources/shared/images/plugin.gif',
            scale: 'small',
            handler: showRoleWin
        }]
    }, {
        xtype:'buttongroup',
        items: [{
            text: '重置密码',
            icon: '${webroot}/resources/shared/images/logout.png',
            scale: 'small',
            handler: function(){
            	if (!isRecordClick()) return;
            	var requestConfig = {
					url: 'resetPasswordByUsers.${extension}',
					params: {userid:recordData.userid}
                };
            	var result = Ext.Ajax.request(requestConfig);
            }
        }]
    }, '->', title
    ];

	var indexMenu = new Ext.menu.Menu({
        id		:'grid-ctx',
        items	: [{
            text	: '查看',
            icon	: '${webroot}/resources/shared/images/new_tab.gif',
            handler	: function(){
    			clickRecord(ctxRecord);
        		showViewWin(ctxRecord);
            }
        },{
            text	: '修改',
            icon	: '${webroot}/resources/shared/images/edit.gif',
            handler	: function(){
        		clickRecord(ctxRecord);
        		showUpdateWin(ctxRecord);
            }
        },'-',{
            icon	: '${webroot}/resources/shared/images/refresh.gif',
            text	: '刷新',
            handler	: function(){
                ctxRow = null;
                indexStore.reload();
            }
        }]
    });
    
	function clickRecord(record){
    	record = (record && record.data) ? record : gsm.getSelected();
    	recordData = record.data;
    	title.setText('<b>' + recordData.username + '</b>');
	}
//]]>
</script>
<%@ include file="../../common/onReady.jspf" %>
<%@ include file="../../common/IncludeBottom.jspf" %>