var BusinessTable = function() {
	var dataTable = {
		ele: "#businessTable",
		table: null,
		option: {
			columns: [
				{ data: "" },
				{ data: "" },
				{ data: "" },
				{ data: "" },
				{ data: "" },
			]
		},
		init: function() {
			this.table = Datatables.order(this.ele, this.option, 1);
			this.search();
		},
		search: function() {
			var param = new Object();
			Datatables.rowsAdd(this.table, contextPath + "/business/search", param);
		}
	}
	
	return {
		init: function() {
			dataTable.init();
		}
	}
}();

$(document).ready(function() { 
	BusinessTable.init();
});
