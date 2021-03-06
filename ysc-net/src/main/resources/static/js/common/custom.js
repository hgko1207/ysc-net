/**
 * 등록 공통 기능
 * @returns
 */
function registCommon(name, SettingManager) {
	$('#registForm').submit(function(e) {
		e.preventDefault();

		var form = $(this);
	    var url = form.attr('action');
	    var formData = new FormData($(this)[0]);
		
	    $.ajax({
			type: "POST",
	       	url: url,
	       	data: formData,
	       	processData: false,
	       	contentType: false,
	       	success: function(response) {
	       		Swal.fire({
	       			title: name + " 등록이 되었습니다.", 
	   				icon: "success"
	   			}).then(function(e) {
	   				SettingManager.success();
	   			});
	       	},
	        error: function(response) {
	        	Swal.fire({title: name + " 등록을 실패하였습니다.", icon: "error"})
	        }
		});
	});
}

/**
 * 수정 공통 기능
 * @returns
 */
function updateCommon(name, SettingManager) {
	$('#updateForm').submit(function(e) {
		e.preventDefault();

		var form = $(this);
	    var url = form.attr('action');
	    var formData = new FormData($(this)[0]);
		
	    $.ajax({
			type: "PUT",
	       	url: url,
	       	data: formData,
	       	processData: false,
	       	contentType: false,
	       	success: function(response) {
	       		Swal.fire({
	       			title: name + " 수정 되었습니다.", 
	   				icon: "success"
	   			}).then(function(e) {
	   				SettingManager.success();
	   			});
	       	},
	        error: function(response) {
	        	Swal.fire({title: name + " 수정을 실패하였습니다.", icon: "error"})
	        }
		});
	});
}

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
 * 테이블에서 삭제 공통 기능
 * @returns
 */
function deleteCommon(url, id, name, Datatable, title) {
	Swal.fire({
        title: title ? title : "선택된 " + name + "을 삭제하시겠습니까?",
		icon: "warning",
		buttonsStyling: false,
        showCancelButton: true, 
        confirmButtonText: "<i class='la la-check'></i> 삭제",
        cancelButtonText: "<i class='la la-close'></i> 취소",
        customClass: {
    		confirmButton: "btn btn-danger",
    		cancelButton: "btn btn-default btn-outline-secondary"
        }
    }).then(function(e) {
    	if (e.value) {
    		$.ajax({
	    		url: url,
	    		type: "DELETE",
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

/**
 * 삭제 공통 기능
 * @returns
 */
function deletePageCommon(url, id, name, SettingManager, title) {
	Swal.fire({
        title: title ? title : "선택된 " + name + "을 삭제하시겠습니까?",
		icon: "warning",
		buttonsStyling: false,
        showCancelButton: true, 
        confirmButtonText: "<i class='la la-check'></i> 삭제",
        cancelButtonText: "<i class='la la-close'></i> 취소",
        customClass: {
    		confirmButton: "btn btn-danger",
    		cancelButton: "btn btn-default btn-outline-secondary"
        }
    }).then(function(e) {
    	if (e.value) {
    		$.ajax({
	    		url: url,
	    		type: "DELETE",
	    		data: {"id": id},
	    		success: function(response) {
	    			SettingManager.success();
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

function isEmpty(str) {
    return (!str || 0 === str.length);
}