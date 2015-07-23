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
	$('#form').attr('method', 'post');
	$('#form').submit();
}

function saveItem() {
	alert($('#form').attr('method'));
	$('#form').attr('method', 'put');
	$('#form').submit();
}

function removeItem() {
	$('#form').attr('method', 'delete');
	$('#form').submit();
}
