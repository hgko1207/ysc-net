var FamilyManager = function() {
	const dataTable = {
		ele: "#familyTable",
		table: null,
		option: {
			columns: [
				{
					data: null,
			    	render: function(data, type, row, meta) {
			    		return meta.row + 1;
			    	}
			    },
				{ data: "name" },
				{ data: "dept" },
				{ data: "tel" },
				{ data: "email" },
				{
					data: "updateDate",
			    	render: function(data, type, row, meta) {
			    		return moment(new Date(row.updateDate)).format("YYYY-MM-DD HH:mm:ss");
			    	}
			    },
				{ 
			    	data: null,
			    	responsivePriority: -1,
				    render: function(data, type, row, meta) {
					    return `<a href="${contextPath}/family/update?id=${row.id}" class="btn btn-sm btn-light-primary btn-icon mr-2">` + 
					    `<i class="far fa-edit"></i></a>` + 
					    `<button type="button" class="btn btn-sm btn-light-danger btn-icon"` +
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
			Datatables.rowsAdd(this.table, contextPath + "/family/search", param);
		}
	}
	
	return {
		list: function() {
			dataTable.init();
		},
		regist: function() {
			registCommon("임직원", FamilyManager);
		},
		update: function() {
			updateCommon("임직원", FamilyManager);
		},
		_delete: function(id) {
			deleteCommon(contextPath + "/family/delete", id, "임직원", dataTable);
		},
		success: function() {
			location.replace(contextPath + "/family/list");
		}
	}
}();

$(document).ready(function() { 
	autosize($('#content_autosize'));
	
	$('input[name="tel"]').inputmask({
		mask: "999-9999-9999",
		placeholder: ""
	});
});
