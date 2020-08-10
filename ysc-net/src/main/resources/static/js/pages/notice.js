var NoticeManager = function() {
	const dataTable = {
		ele: "#noticeTable",
		table: null,
		option: {
			columns: [
				{
			    	width: "5%",
			    	render: function(data, type, row, meta) {
			    		return meta.row + 1;
			    	}
			    },
			    { data: "title" },
				{ data: "userId" },
				{
					width: "15%",
			    	render: function(data, type, row, meta) {
			    		return moment(new Date(row.updateDate)).format("YYYY-MM-DD HH:mm:ss");
			    	}
			    },
			    { 
			    	width: "8%",
			    	data: "hit" 
	    		},
			]
		},
		init: function() {
			this.table = Datatables.order(this.ele, this.option, 1);
			this.search();
		},
		search: function() {
			const param = new Object();
			Datatables.rowsAdd(this.table, contextPath + "/notice/search", param);
		}
	}
	const initActions = function() {
		
	}
	
	return {
		init: function() {
			dataTable.init();
			initActions();
		},
		_delete: function(id) {
			deleteCommon(contextPath + "/notice/delete", id, "공지사항", dataTable);
		}
	}
}();

$(document).ready(function() { 
	NoticeManager.init();
	autosize($('#content_autosize'));
});
