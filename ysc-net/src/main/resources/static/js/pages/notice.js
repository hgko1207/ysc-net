const NoticeManager = function() {
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
//			    	className: "text-left",
			    	render: function(data, type, row, meta) {
			    		return `<a href="${contextPath}/notice/detail/${row.id}" ` +
			    		 `class="text-dark text-hover-success font-weight-bolder">${row.title}</a>`;
			    	}
			    },
				{ data: "userName" },
				{
					data: "createDate",
			    	render: function(data, type, row, meta) {
			    		return moment(new Date(row.createDate)).format("YYYY-MM-DD");
			    	}
			    },
			    { 
			    	width: "10%",
			    	data: "hit" 
	    		},
			]
		},
		init: function() {
			this.table = Datatables.noOrder(this.ele, this.option);
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
			updateCommon("공지사항", NoticeManager);
		},
		_delete: function(id) {
			deletePageCommon(contextPath + "/notice/delete", id, "공지사항", NoticeManager);
		},
		success: function() {
			location.replace(contextPath + "/notice/list");
		}
	}
}();

$(document).ready(function() {
	autosize($('#content_autosize'));
});
