<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../common/IncludeTop.jspf" %>
<%@ include file="../../../common/dictionary.jspf" %>
<%@ include file="../stuBaseInfo/formColumn.jspf" %>
<%@ include file="formColumn.jspf" %>
<%@ include file="toolbar.jspf" %>
<%@ include file="upload.jspf" %>
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
		url		 	: 'getStudentsBaseInfoList.${extension}'
	});

	var indexTbar = [{
        xtype:'buttongroup',
        items: [{
            text: '读取Excel文件',
            icon: '${webroot}/resources/shared/images/data_import.png',
            scale: 'small',
            handler: readExcel
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
            text: '删除',
            icon: '${webroot}/resources/shared/images/delete.gif',
            scale: 'small',
            handler: deleteStuData
        }]
    }, {
        xtype:'buttongroup',
        items: [{
        	text: '保存',
        	icon: '${webroot}/resources/shared/images/accept.png',
        	handler: saveStuData
        }]
    }, {
        xtype:'buttongroup',
        items: [{
        	text: '返回',
        	icon: '${webroot}/resources/shared/images/cross.gif',
        	handler: onBack
        }]
    }, '->', title
    ];

	var indexMenu = new Ext.menu.Menu({
        items	: [{
            text	: '修改',
            icon	: '${webroot}/resources/shared/images/edit.gif',
            handler	: function(){
        		clickRecord(ctxRecord);
        		showUpdateWin(ctxRecord);
            }
        }, {
            text	: '删除',
            icon	: '${webroot}/resources/shared/images/new_tab.gif',
            handler	: function(){
    			clickRecord(ctxRecord);
    			deleteStuData(ctxRecord);
            }
        },'-',{
            icon	: '${webroot}/resources/shared/images/table_refresh.png',
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
    	title.setText('<b>' + recordData.xm + '</b>');
	}
//]]>
</script>
<%@ include file="../../../common/onReady.jspf" %>
<%@ include file="../../../common/IncludeBottom.jspf" %>