var CommonWidget = function() {
	
	 const _componentJQuery = function() {
    	/** form 데이터들을 JSON 형식으로 변환 */
    	jQuery.fn.serializeObject = function() { 
    		let obj = null; 
    		try { 
    			if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) { 
				const arr = this.serializeArray(); 
				if (arr){ 
					obj = {}; 
					jQuery.each(arr, function() { 
						obj[this.name] = this.value; }); 
					} 
				} 
			} catch(e) { 
				alert(e.message); 
			} finally {} 
			return obj; 
		}
    };
	
	// Bootstrap file upload
    const _componentFileUpload = function() {
    	if (!$().fileinput) {
            console.warn('Warning - fileinput.min.js is not loaded.');
            return;
        }
        
        // Buttons inside zoom modal
    	const previewZoomButtonClasses = {
	        toggleheader: 'btn btn-sm btn-icon btn-default btn-outline-secondary btn-toggleheader',
	        fullscreen: 'btn btn-sm btn-icon btn-default btn-outline-secondary btn-fullscreen ml-1',
	        borderless: 'btn btn-sm btn-icon btn-default btn-outline-secondary btn-borderless ml-1',
	        close: 'btn btn-sm btn-icon btn-default btn-outline-secondary btn-close ml-1'
        };
        
     	// Icons inside zoom modal classes
    	const previewZoomButtonIcons = {
            prev: '<i class="fas fa-caret-left fa-lg"></i>',
            next: '<i class="fas fa-caret-right fa-lg"></i>',
            toggleheader: '<i class="fas fa-arrows-alt-v"></i>',
            fullscreen: '<i class="fas fa-arrows-alt"></i>',
            borderless: '<i class="fas fa-external-link-alt"></i>',
            close: '<i class="fas fa-times"></i>'
        };
     	
     	// File actions
    	const fileActionSettings = {
            zoomClass: 'btn btn-sm btn-icon btn-default btn-outline-secondary',
            zoomIcon: '<i class="fas fa-search-plus"></i>',
            removeClass: 'btn btn-sm btn-icon btn-default btn-outline-secondary',
            removeIcon: '<i class="fas fa-trash-alt"></i>',
        	removeErrorClass: 'text-danger',
        	uploadClass: 'd-none',
        };
    	
    	$('.file-input').fileinput({
    		uploadUrl: false, // server upload action
    		uploadAsync: true,
            showUpload: false,
            showCaption: true,
            showPreview: true,
            dropZoneEnabled: false,
//            initialPreview: [],
//            initialCaption: "파일이 선택되지 않았습니다.",
            browseLabel: '찾아보기',
            browseClass: 'btn btn-success',
            browseIcon: '<i class="flaticon2-image-file mr-2"></i>',
            uploadIcon: '<i class="fas fa-file-upload mr-2"></i>',
            removeLabel: 'Delete',
            removeClass: 'btn btn-danger',
            removeIcon: '<i class="fas fa-trash-alt mr-2"></i>',
            previewZoomButtonClasses: previewZoomButtonClasses,
            previewZoomButtonIcons: previewZoomButtonIcons,
            fileActionSettings: fileActionSettings,
        });
    };
    
    return {
        init: function() {
        	_componentJQuery();
        	_componentFileUpload();
        }
    }
}();

$(document).ready(function() {
	CommonWidget.init();
});
