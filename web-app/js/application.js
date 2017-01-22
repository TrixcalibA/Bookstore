//allow only numbers to be entered in a textbox
function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}

//customize data-type sorting for DataTables
jQuery.fn.dataTableExt.oSort['expire-date-asc'] = function(a,b) {
	var x_month = a.split('/')[0];
	var x_year = a.split('/')[1];
	var y_month = b.split('/')[0];
	var y_year = b.split('/')[1];
	if(x_year < y_year) return -1;
	if(x_year > y_year) return 1;
	if(x_month < y_month) return -1;
	if(x_month > y_month) return 1;
	return 0;
};

jQuery.fn.dataTableExt.oSort['expire-date-desc']  = function(a,b) {
	var x_month = a.split('/')[0];
	var x_year = a.split('/')[1];
	var y_month = b.split('/')[0];
	var y_year = b.split('/')[1];
	if(x_year < y_year) return 1;
	if(x_year > y_year) return -1;
	if(x_month < y_month) return 1;
	if(x_month > y_month) return -1;
	return 0;
};

jQuery.fn.dataTableExt.oSort['dollar-format-asc'] = function(a,b) {
	var x = parseFloat(a.replace(/\$/g,'').replace(/,/g,''));
	var y = parseFloat(b.replace(/\$/g,'').replace(/,/g,''));
	if(x<y) return -1;
	if(x>y) return 1;
	return 0;
};

jQuery.fn.dataTableExt.oSort['dollar-format-desc'] = function(a,b) {
	var x = parseFloat(a.replace(/\$/g,'').replace(/,/g,''));
	var y = parseFloat(b.replace(/\$/g,'').replace(/,/g,''));
	if(x<y) return 1;
	if(x>y) return -1;
	return 0;
};

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		}).ajaxError(function(){
			$(this).fadeOut();
		});
	})(jQuery);
}

function showSpinner(){
	$('#spinner').show();
}

function hideSpinner(){
	$('#spinner').hide();
}

function notyMessage(text,type){
	noty({
		text: text,
		type: type,
		timeout: 5000,
		maxVisible: 5,
		animation: {
			open: {
				height:'toggle'
			},
			close: {
				height:'toggle'
			},
			easing: 'swing',
			speed: 200
		}
	});
}

function formatDate(millis){
	var monthNames = {0: 'Jan', 1: 'Feb', 2: 'Mar', 3: 'Apr', 4: 'May', 5: 'Jun',
					  6: 'Jul', 7: 'Aug', 8: 'Sep', 9: 'Oct', 10: 'Nov', 11: 'Dec'};
	var date = new Date(millis);
	var fdate = date.getDate()>9 ? date.getDate() : '0' + date.getDate();
	var date_str = monthNames[date.getMonth()] + " " + fdate + ", " + date.getFullYear();
    return date_str;
}

function enableTab(id) {
    var el = document.getElementById(id);
    el.onkeydown = function(e) {
        if (e.keyCode === 9) { // tab was pressed

            // get caret position/selection
            var val = this.value,
                start = this.selectionStart,
                end = this.selectionEnd;

            // set textarea value to: text before caret + tab + text after caret
            this.value = val.substring(0, start) + '\t' + val.substring(end);

            // put caret at right position again
            this.selectionStart = this.selectionEnd = start + 1;
            
            $(this).trigger("change");
            // prevent the focus lose
            return false;

        }
    };
}

$(document).ready(function(){
	$('.scaffold-list table:first').addClass('table').addClass('table-striped').addClass('table-hover');
	$.extend( $.fn.dataTable.defaults, {
		'sPaginationType': 'ellipses',
	    "bFilter": false,
	    "bInfo": false,
	    "bLengthChange": false,
	    "bAutoWidth": false,
	} );
});