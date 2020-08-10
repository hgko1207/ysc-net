var UserManager = function() {
	const dataTable = {
		ele: "#userTable",
		table: null,
		option: {
			columns: [
				{
			    	width: "6%",
			    	render: function(data, type, row, meta) {
			    		return meta.row + 1;
			    	}
			    },
			    { data: "userId" },
				{ data: "name" },
				{ data: "tel" },
				{ data: "email" },
				{
					width: "15%",
			    	render: function(data, type, row, meta) {
			    		return moment(new Date(row.updateDate)).format("YYYY-MM-DD HH:mm:ss");
			    	}
			    },
				{ 
			    	width: "10%",
				    render: function(data, type, row, meta) {
					    return `<button type="button" class="btn btn-sm btn-light-danger btn-icon"` +
					    `onClick="FamilyManager._delete(${row.id})"><i class="far fa-trash-alt"></i></button>`;
				    }
				}
			]
		},
		init: function() {
			this.table = Datatables.order(this.ele, this.option, 1);
			this.search();
		},
		search: function() {
			const param = new Object();
			Datatables.rowsAdd(this.table, contextPath + "/user/search", param);
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
			deleteCommon(contextPath + "/user/delete", id, "사용자", dataTable);
		}
	}
}();

$(document).ready(function() { 
	UserManager.init();
});
