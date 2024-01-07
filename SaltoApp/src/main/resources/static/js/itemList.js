/**
 * 商品一覧画面
 */
$(function() {
	// テーブルの行をクリックしたときの処理
	$('#itemList tbody tr').on('click', function() {
		// すべての行の選択状態を解除
		$('#itemList tbody tr').removeClass('table-row-active');
		// クリックされた行に選択状態のクラスを追加
		$(this).addClass('table-row-active');
		// 更新ボタン、削除ボタンを活性化
		$('#editBtn').removeAttr('disabled');
		$('#deleteDummyBtn').removeAttr('disabled');
		
		// 商品ID一時保管
		editSelectedItemId($(this));
	});
	
	$('#deleteOkBtn').click(function(){
		$('#deleteBtn').trigger('click');
	})
});

/**
 * テーブルで選択された行の商品IDを画面のhidden要素に保管します。
 * 
 * @param row 選択された行情報
 */
function editSelectedItemId(row) {
	row.find('td').each(function() {
		var columnId = $(this).attr('id');
		if (columnId.startsWith('itemId_')) {
			$('#selectedItemId').val($(this).text());
			return false;
		}
	});
}