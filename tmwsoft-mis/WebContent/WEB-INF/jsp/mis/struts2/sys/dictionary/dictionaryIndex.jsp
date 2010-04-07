<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../common/IncludeTop.jspf" %>
<link rel="stylesheet" type="text/css" href="${webroot}/resources/shared/css/docs.css" />
<%@ include file="dicTree.jspf" %>
<%@ include file="dicEntries.jspf" %>
<script type="text/javascript">
//<![CDATA[
	Ext.onReady(function(){
		Ext.QuickTips.init();
	    var viewport = new Ext.Viewport({
	        layout:'border',
	        items: [{
				layout: 'border',
		    	id: 'dic-browser',
		        region: 'west',
		        border: false,
		        split: true,
				margins: '5 0 5 5',
		        width: 275,
		        minSize: 100,
		        maxSize: 500,
		        collapseMode: 'mini',
				items: [dicPanel]
			},
				contentPanel
			]
	    });
	    viewport.doLayout();

	    setTimeout(function(){
	        Ext.get('loading').remove();
	        Ext.get('loading-mask').fadeOut({remove:true});
	    }, 250);
	});

    Ext.Ajax.on('requestcomplete', function(ajax, xhr, o){
        if(typeof urchinTracker == 'function' && o && o.url){
            urchinTracker(o.url);
        }
    });
//]]>
</script>

<div id="loading-mask" style=""></div>
<div id="loading">
<div class="loading-indicator">读取中...</div>
</div>
<%@ include file="../../common/IncludeBottom.jspf" %>