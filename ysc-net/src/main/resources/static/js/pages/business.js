var BusinessTable = function() {
	var dataTable = {
		ele: "#businessTable",
		table: null,
		option: {
			columns: [
				{
			    	width: "6%",
			    	render: function(data, type, row, meta) {
			    		return meta.row + 1;
			    	}
			    },
			    {
			    	width: "15%",
			    	render: function(data, type, row, meta) {
			    		return `<img src="data:${row.imageType};base64,${row.image}" class="img-fluid"/>`;
			    	}
			    },
				{ data: "name" },
				{ data: "userName" },
				{
					width: "15%",
			    	render: function(data, type, row, meta) {
			    		return moment(new Date(row.createDate)).format("YYYY-MM-DD HH:mm:ss");
			    	}
			    },
				{ 
			    	width: "10%",
				    render: function(data, type, row, meta) {
					    return '<button type="button" class="btn btn-sm btn-light-twitter btn-icon mr-2"><i class="far fa-edit"></i></button>' + 
					    '<button type="button" class="btn btn-sm btn-light-youtube btn-icon"><i class="far fa-trash-alt"></i></button>';
				    }
				}
			]
		},
		init: function() {
			this.table = Datatables.order(this.ele, this.option, 2);
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
