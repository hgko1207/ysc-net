/**
 * 모달에서 수정 공통 기능
 * @returns
 */
function updateModalCommon(url, object, name, Datatable, modalId) {
	$.ajax({
       	url: url,
		type: "PUT",
       	data: object,
       	success: function(response) {
       		$("#" + modalId).modal('hide');
       		
       		Swal.fire({
   				title: name + " 수정 되었습니다.", 
   				icon: "success"
   			}).then(function(e) {
   				Datatable.search();
   			});
       	},
        error: function(response) {
        	Swal.fire({title: name + " 수정을 실패하였습니다.", icon: "error"})
        }
	});
}

/**
 * 삭제 공통 기능
 * @returns
 */
function deleteCommon(url, id, name, Datatable, title) {
	Swal.fire({
        title: title ? title : "선택된 " + name + "을 삭제하시겠습니까?",
		icon: "warning",
        confirmButtonText: "삭제",
        confirmButtonClass: "btn btn-danger",
        showCancelButton: true, 
        cancelButtonText: "취소",
    }).then(function(e) {
    	if (e.value) {
    		$.ajax({
	    		url: url,
	    		icon: "DELETE",
	    		data: {"id": id},
	    		success: function(response) {
	    			Datatable.search();
	           	},
	            error: function(response) {
	            	if (isEmpty(response.responseText)) {
	            		Swal.fire({title: name + " 삭제를 실패하였습니다.", icon: "error"});
	            	} else {
	            		Swal.fire({title: response.responseText, icon: "error"});
	            	}
	            	
	            }
	    	}); 
    	}
    });
}