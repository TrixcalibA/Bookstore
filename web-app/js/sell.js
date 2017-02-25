var homevm = new HomeViewModel();

function HomeViewModel(){
	var self = this;
	
	self.title = ko.observable(null);
	
	self.isbn = ko.observable(null);
	
	self.major = ko.observable(null);
	
	self.course = ko.observable(null);
	
	self.sellBookTable = null;
	
	self.sellBook = function(){
		$("#sell-form").validate({
			rules:{
				bookTitle:{
					required: true
				},
				isbn:{
					required: true
				}
			}
		})
		var valid = $("#sell-form").valid();
		if(!valid)
			return;
		var formData = {
			title: self.title(),
			isbn: self.isbn(),
			major: self.major(),
			course: self.course()
		}
		showSpinner();
		$.post('/sellBooks/sell',formData,function(data){
			if(data['success']){
				self.title(null);
				self.isbn(null);
				self.major(null);
				self.course(null);
				notyMessage('You book was posted successfully','success');
				self.sellBookTable.fnReloadAjax();
			}
			else{
				notyMessage(data['message'],'warning');
			}
			hideSpinner();
		});
	}
	
	self.initializeSellBooks = function(){
		self.sellBookTable = $("#sellbook_table").dataTable({
			"bFilter": true,
			'bInfo' : true,
			"bProcessing": true,
	        "bServerSide": true,
	        "iDisplayLength": 25,
	        "sAjaxSource": "/sellBooks/books",
	        "aoColumns" : [{ "mData": "title" },
	                       { "mData": "isbn" },
	                       { "mData": "major" },
	                       { "mData": "course" },
	                       { "mData": "postedDate" },
	                       { "mData": "status" }
	                   ]
		            });
	}
}

$(document).ready(function(){
	homevm.initializeSellBooks();
	ko.applyBindings(homevm,$('.home')[0]);
});
