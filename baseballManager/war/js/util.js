function move(url) {
	$('#form').attr('method', 'get');
	$('#form').attr('action', url);
	$('#form').submit();
}

function getItem() {
	$('#form').attr('method', 'get');
	$('#form').submit();
}

function registItem() {
	$.ajax({
	  url: "",
	  cache: false,
	  type: "post",
	  data: getData(),
	  success: function(msg){
		  alertDialog(msg);
	  },
	  error: function(html){
		  alert("不明なエラーが発生しました。");
	  }
	});
}

function saveItem() {
	$.ajax({
		  url: "",
		  cache: false,
		  type: "put",
		  data: getData(),
		  success: function(msg){
		    alertDialog(msg);
		  },
		  error: function(html){
			  alert("不明なエラーが発生しました。");
		  }
		});
}

function removeItem() {
	$.ajax({
		  url: "",
		  cache: false,
		  type: "delete",
		  data: getData(),
		  success: function(msg){
			  alertDialog(msg);
		  },
		  error: function(html){
			  alert("不明なエラーが発生しました。");
		  }
		});
}

function getData() {
	var data = ""

	$.each($('#form input[type="text"]'), function() {
		data += this.name + "=" + this.value +"&"
    });

	$.each($('#form input[type="password"]'), function() {
		data += this.name + "=" + this.value +"&"
    });

	$.each($('#form input[type="hidden"]'), function() {
		data += this.name + "=" + this.value +"&"
    });
	$.each($('#form input[type="checkbox"]:checked'), function() {
		data += this.name + "=" + this.value +"&"
    });

	return data;
}

function alertDialog(msg, callBack) {
	$("#dialog").html(msg);
	// ダイアログを作成
	$("#dialog").dialog({
		modal: true,
		title: "警告",
		height: 200,
        width: 300,
		buttons: {
			"OK": function() {
				if(callBack != undefined) callBack();
				$( this ).dialog( "close" );
			}
		}
	});
}

function comfirmDialog(msg, callBack) {
	$("#dialog").html(msg);
	// ダイアログを作成
	$("#dialog").dialog({
		modal: true,
		title: "確認",
		height: 200,
        width: 300,
		buttons: {
			"OK": function() {
				if(callBack != undefined) callBack();
				$( this ).dialog( "close" );
			},
			"キャンセル": function() {
				$( this ).dialog( "close" );
			}
		}
	});
}
