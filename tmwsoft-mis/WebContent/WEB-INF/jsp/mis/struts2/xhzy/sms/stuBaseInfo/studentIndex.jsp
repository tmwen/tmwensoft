<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../common/IncludeTop.jspf" %>
<%@ include file="../../../common/dictionary.jspf" %>
<%@ include file="formColumn.jspf" %>
<%@ include file="toolbar.jspf" %>
<script type="text/javascript">
//<![CDATA[
	var title = new Ext.Action({
        text: '',
        disabled: false
    });
    
    var indexProxy =  new Ext.data.HttpProxy({ 
		autoLoad 	: true, 
		method		: 'post',
       	params		: '',
		url		 	: 'getStudentsBaseInfoList.${extension}'
	});

	var indexTbar = [{
        xtype:'buttongroup',
        items: [{
        	text: '查询',
        	icon: '${webroot}/resources/shared/images/user/user.png',
        	tooltip: {text:'简单的查询'},
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
            text: '删除',
            icon: '${webroot}/resources/shared/images/delete.gif',
            scale: 'small',
            handler: onDeleteInfo
        }]
    }, {
        xtype:'buttongroup',
        items: [{
            text: '查看',
            icon: '${webroot}/resources/shared/images/new_tab.gif',
            scale: 'small',
            handler: showViewWin
        }]
    }, '->', title
    ];

    var indexMenu = new Ext.menu.Menu({
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
        },{
            text	: '删除',
            icon	: '${webroot}/resources/shared/images/delete.gif',
            handler	: function(){
        		clickRecord(ctxRecord);
        		onDeleteInfo(ctxRecord);
            }
        },'-',{
			icon : '${webroot}/resources/shared/images/refresh.gif',
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