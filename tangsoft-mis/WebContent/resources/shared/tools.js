/**
 * 时间对象的格式化;
 * eg:format = "yyyy-MM-dd hh:mm:ss";
 *    format = "yyyy年MM月dd日hh小时mm分ss秒";b
 *    var testDate = new Date();
 *    var testStr = testDate.format(format);
 */
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"h+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S" : this.getMilliseconds()
	};

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}

	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};

function checkParseIdCard(val) {
    var msg = checkIdcard(val); 
    if (msg != "验证通过!") {
        alert(msg);
        return;
    } 
  
  
    var birthdayValue;
    var sexId;
    var sexText;
    var age;
    if (15 == val.length){ //15位身份证号码
        birthdayValue = val.charAt(6) + val.charAt(7);
        if (parseInt(birthdayValue) < 10) {
            birthdayValue = '20' + birthdayValue;
        }
        else {
            birthdayValue = '19' + birthdayValue;
        }
        birthdayValue = birthdayValue + '-' + val.charAt(8) + val.charAt(9) + '-' + val.charAt(10) + val.charAt(11);
        if (parseInt(val.charAt(14) / 2) * 2 != val.charAt(14)) {
            sexId = "1";
            sexText = "男";
        }
        else {
            sexId = "2";
            sexText = "女";
        }
    }
    if (18 == val.length) { //18位身份证号码
        birthdayValue = val.charAt(6) + val.charAt(7) + val.charAt(8) + val.charAt(9) + '-' + val.charAt(10) + val.charAt(11) + '-' + val.charAt(12) + val.charAt(13);
        if (parseInt(val.charAt(16) / 2) * 2 != val.charAt(16)) {
            sexId = "1";
            sexText = "男";
        }
        else {
            sexId = "2";
            sexText = "女";
        }
    }
     //年龄
    var dt1 = new Date(birthdayValue.replace("-", "/"));
    var dt2 = new Date();
    var age = dt2.getFullYear() - dt1.getFullYear();
    var m = dt2.getMonth() - dt1.getMonth();
    if (m < 0)
        age--; 
    alert(birthdayValue+sexId+sexText+age);
} 

function checkIdcard(idcard){     
  var Errors=new Array("验证通过","身份证号码位数不对","身份证号码出生日期超出范围或含有非法字符","身份证号码校验错误","身份证地区非法");     
  var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};
  var idcard,Y,JYM;     
  var S,M;     
  var idcard_array = new Array();     
  idcard_array = idcard.split("");     
  if(area[parseInt(idcard.substr(0,2))]==null) return Errors[4];     
  switch(idcard.length){     
    case 15:     
      if ((parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){     
        ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性     
      }     
      else{     
        ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性     
      }     
      if(ereg.test(idcard))     
        return Errors[0];     
      else    
        return Errors[2];     
    break;     
  case 18:     
    if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){     
      ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式     
    }     
    else{     
    ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式     
    }     
    if(ereg.test(idcard)){     
      S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7 + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9 + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10 + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5 + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8 + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4 + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2 + parseInt(idcard_array[7]) * 1 + parseInt(idcard_array[8]) * 6 + parseInt(idcard_array[9]) * 3 ;     
      Y = S % 11;     
      M = "F";     
      JYM = "10X98765432";     
      M = JYM.substr(Y,1);     
      if(M == idcard_array[17])     
        return Errors[0];     
      else    
        return Errors[3];     
    }     
    else    
      return Errors[2];     
    break;     
  default:     
    return Errors[1];     
    break;     
  }     
}     
//alert(checkIdcard("222426300207031")) 