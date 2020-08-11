$.extend( $.fn.dataTable.defaults, {
//	autoWidth: false,
    //dom: '<"datatable-header"fl><"datatable-scroll-wrap"t><"datatable-footer"ip>',
    dom: `<'row'<'col-sm-12'tr>><'row'<'col-sm-12 col-md-5'i><'col-sm-12 col-md-7 dataTables_pager'lp>>`,
    language: {
		emptyTable: '데이터가 없습니다.',
		infoEmpty: "",
		info: " _TOTAL_ 개의 데이터가 있습니다.",
	    search: '<span>검색 :</span> _INPUT_',
	    searchPlaceholder: '내용 입력...',
	    lengthMenu: 'Display _MENU_',
	    paginate: { 'first': 'First', 'last': 'Last', 
	    	'next': $('html').attr('dir') == 'rtl' ? '&larr;' : '&rarr;', 'previous': $('html').attr('dir') == 'rtl' ? '&rarr;' : '&larr;' }
	},
	searching: false,
	lengthChange: false,
	pageLength: 10,
});

var Datatables = {
	basic: function(id, tableOption, info) {
		var table = $(id).DataTable({
			responsive: true,
			language: {
				info: info ? info : " _TOTAL_ 개의 데이터가 있습니다." 
			},
			columns: tableOption.columns,
			order: [[0, 'asc']],
		});
		
		return table;
	},
	order: function(id, tableOption, num, info) {
		var table = $(id).DataTable({
			responsive: true,
			processing: true,
			language: {
				info: info ? info : " _TOTAL_ 개의 데이터가 있습니다." 
			},
			columns: tableOption ? tableOption.columns : null,
			columnDefs: [
		    	{ orderable: true, className: 'reorder', targets: 0 },
		    	{ orderable: true, className: 'reorder', targets: num },
		    	{ orderable: false, targets: '_all' }
		    ],
			order: [[num, 'desc']],
		});
		
		return table;
	},
	rowsAdd: function(table, url, param) {
		table.clear();
		
		$.ajax({
			url: url,
			type: "POST",
			data: JSON.stringify(param),
			contentType: "application/json",
			success: function(data) {
				table.rows.add(data).draw();
				table.responsive.recalc();
				console.log(table.responsive);
		   	}
		});
	},
	refresh: function(table, data) {
		table.clear();
		table.rows.add(data).draw();
	}
}
