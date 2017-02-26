var homevm = new HomeViewModel();

function HomeViewModel(){
	var self = this;
	
	self.ourBookTable = null;

	self.initializeSellBooks = function(){
		self.sellBookTable = $("#ourbook_table").dataTable({
			"bFilter": true,
			'bInfo' : true,
			"bProcessing": true,
	        "bServerSide": true,
	        "iDisplayLength": 25,
	        "sAjaxSource": "/ourBooks/books",
	        "aoColumns" : [{ "mData": "title" },
	                       { "mData": "isbn" },
	                       { "mData": "major" },
	                       { "mData": "course" },
	                       { "mData": "postedDate" },
	                       { "mData": "postedBy" },
	                       { "mData": "status" }
	                   ]
		            });
	}
}

$(document).ready(function(){
	homevm.initializeSellBooks();
	ko.applyBindings(homevm,$('.home')[0]);
});
