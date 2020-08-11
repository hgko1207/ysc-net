var NoticeManager = function() {
	const dataTable = {
		ele: "#noticeTable",
		table: null,
		option: {
			columns: [
				{
					data: null,
					width: "8%",
			    	render: function(data, type, row, meta) {
			    		return meta.row + 1;
			    	}
			    },
			    {
			    	data: "title",
			    	render: function(data, type, row, meta) {
			    		return `<a href="${contextPath}/notice/detail/${row.id}" ` +
			    		 `class="text-dark text-hover-success font-weight-bolder">${row.title}</a>`;
			    	}
			    },
				{ data: "userId" },
				{
					data: "createDate",
			    	render: function(data, type, row, meta) {
			    		return moment(new Date(row.createDate)).format("YYYY-MM-DD HH:mm:ss");
			    	}
			    },
			    { 
			    	width: "10%",
			    	data: "hit" 
	    		},
			]
		},
		init: function() {
			this.table = Datatables.order(this.ele, this.option, 3);
			this.search();
		},
		search: function() {
			const param = new Object();
			Datatables.rowsAdd(this.table, contextPath + "/notice/search", param);
		}
	}
	
	return {
		list: function() {
			dataTable.init();
		},
		regist: function() {
			registCommon("공지사항", NoticeManager);
		},
		update: function() {
			
		},
		_delete: function(id) {
			deleteCommon(contextPath + "/notice/delete", id, "공지사항", dataTable);
		},
		success: function() {
			location.replace(contextPath + "/notice/list");
		}
	}
}();

$(document).ready(function() {
	autosize($('#content_autosize'));
});
