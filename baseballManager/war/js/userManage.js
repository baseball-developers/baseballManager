
/** 新規登録画面へ遷移 */
function moveRegist() {
	move('edit');
}

/** 編集画面へ遷移 */
function moveEdit(userId) {
	$('[name="selectUserId"]').val(userId);
	move('edit');
}