var homevm = new HomeViewModel();

function HomeViewModel(){
	var self = this;
	
	self.title = ko.observable(null);
	
	self.isbn = ko.observable(null);
	
	self.major = ko.observable(null);
	
	self.course = ko.observable(null);
	
	self.loadBooks = function(){
//		$.post('/sellBooks/books',formData,function(data){
//			if(data['success']){
//				
//			}
//			else{
//				
//			}
//		});
	}
	
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
		$.post('/sellBooks/sell',formData,function(data){
			if(data['success']){
				//
			}
			else{
				
			}
		});
	}
}

$(document).ready(function(){
	homevm.loadBooks();
	ko.applyBindings(homevm,$('.home')[0]);
});
