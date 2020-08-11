var BusinessManager = function() {
	const dataTable = {
		ele: "#businessTable",
		table: null,
		option: {
			columns: [
				{
					data: null,
			    	render: function(data, type, row, meta) {
			    		return meta.row + 1;
			    	}
			    },
			    {
			    	data: null,
			    	render: function(data, type, row, meta) {
			    		return `<img src="data:${row.imageType};base64,${row.image}" class="img-fluid"/>`;
			    	}
			    },
				{ data: "name" },
				{ data: "userName" },
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
					    return `<button type="button" class="btn btn-sm btn-light-primary btn-icon mr-2"` + 
					    `onClick="BusinessManager.modal(${row.id})"><i class="far fa-edit"></i></button>` + 
					    `<button type="button" class="btn btn-sm btn-light-danger btn-icon"` +
					    `onClick="BusinessManager._delete(${row.id})"><i class="far fa-trash-alt"></i></button>`;
				    }
				}
			]
		},
		init: function() {
			this.table = Datatables.order(this.ele, this.option, 2);
			this.search();
		},
		search: function() {
			const param = new Object();
			Datatables.rowsAdd(this.table, contextPath + "/business/search", param);
		}
	}
	
	const initUpdate = () => {
		$('#updateForm').submit(function(e) {
			e.preventDefault();
			var form = $(this);
			var url = form.attr('action');
			var formData = new FormData($("#updateForm")[0]);

		    $.ajax({
				type: "PUT",
		       	url: url,
		       	data: formData,
		       	processData: false,
		       	contentType: false,
		       	success: function(response) {
		       		$("#updateBusinessModal").modal('hide');
		       		
		       		Swal.fire({
		   				title: "사업 수정 되었습니다.", 
		   				icon: "success"
		   			}).then(function(e) {
		   				dataTable.search();
		   			});
		       	},
		        error: function(response) {
		        	Swal.fire({title: "사업 수정을 실패하였습니다.", icon: "error"})
		        }
			});
		});
	}
	
	return {
		list: function() {
			dataTable.init();
			initUpdate();
		},
		regist: function() {
			registCommon("사업", BusinessManager);
		},
		modal: function(id) {
			$.ajax({
	    		url: contextPath + "/business/get",
	    		type: "GET",
	    		data: {"id": id},
	    		success: function(response) {
	    			$('#updateForm input[name="id"]').val(response.id);
	    			$('#updateForm input[name="name"]').val(response.name);
	    			$('#updateForm textarea[name="content"]').val(response.content);
	    			$("#updateBusinessModal").modal();
	           	}
	    	});
		},
		_delete: function(id) {
			deleteCommon(contextPath + "/business/delete", id, "사업", dataTable);
		},
		success: function() {
			location.replace(contextPath + "/business/list");
		}
	}
}();

$(document).ready(function() {
	BusinessManager.init();
	autosize($('#content_autosize'));
});
