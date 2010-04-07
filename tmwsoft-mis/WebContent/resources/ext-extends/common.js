Ext.Ajax.timeout = 20000;//设置超时20秒

function misPromptMessageBox(message){
	Ext.MessageBox.hide();
	Ext.example.msg('提示', message);
}

function misErrorMessageBox(message){
	misMsg('错误', Ext.Msg.ERROR, message);
}

function misAletrMessageBox(message){
	misMsg('提示', Ext.Msg.INFO, message);
}
// 私有
var misMsg = function(title, icon, msg){
    Ext.Msg.show({
        title: title,
        msg: msg,
        minWidth: 200,
        modal: true,
        icon: icon,
        buttons: Ext.Msg.OK
    });
};
// 私有
function misMessageBox(result) {
	try{
		if(result.success){
			if(typeof result.message == 'undefined' || result.message == '') return true;
			if(typeof result.messageboxtype != 'undefined' && result.messageboxtype == 'alert'){
				misAletrMessageBox(result.message);
			}else{
				misPromptMessageBox(result.message);
			}
			return true;
		}else{
			if(typeof result.verifyresult != 'undefined' && result.verifyresult == 'login'){
				top.ajax = true;
				top.loginWindow.show();
				return false;
			}
			if(typeof result.message == 'undefined' || result.message == '') return false;
			if(typeof result.messageboxtype != 'undefined' && result.messageboxtype == 'error'){
				misErrorMessageBox(result.message);
			}else{
				misAletrMessageBox(result.message);
			}
		}
	}catch(e){
		misErrorMessageBox('脚本错误<br>' + e);
	}
	return false;
}

Ext.override(Ext.data.Connection, {
	handleResponse : Ext.data.Connection.prototype.handleResponse.createSequence(   
		function(response) {
    		return misMessageBox(Ext.decode(response.responseText));
		}
	)
});

Ext.Ajax.on('requestcomplete',checkResponseResult, this);
// 私有
function checkResponseResult(conn,response,options){
	initFormData(conn,response,options);
}
function initFormData(conn,response,options){}
