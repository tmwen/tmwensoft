<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/IncludeTop.jspf" %>
<%@ include file="../../common/dictionary.jspf" %>
<%@ include file="formColumn.jspf" %>
<%@ include file="toolbar.jspf" %>
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
		url		 	: 'getLogList.${extension}'
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
            text: '查看',
            icon: '${webroot}/resources/shared/images/new_tab.gif',
            scale: 'small',
            handler: showViewWin
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
    	title.setText('<b>' + recordData.logid + '</b>');
	}
//]]>
</script>
<%@ include file="../../common/onReady.jspf" %>
<%@ include file="../../common/IncludeBottom.jspf" %>