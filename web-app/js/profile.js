var homevm = new homeViewModel();

function homeViewModel() {
	var self = this;
	
	self.mode = ko.observable('view');
	
	self.isProfileLoading = ko.observable(true);
	
	self.firstName = ko.observable(null);
	
	self.lastName = ko.observable(null);
	
	self.username = ko.observable(null);

	self.major = ko.observable(null);
	
	self.degree = ko.observable(null);
	
	self.yearOfGraduation = ko.observable(null);
	
	self._firstName = ko.observable(null);
	
	self._lastName = ko.observable(null);
	
	self._major = ko.observable(null);
	
	self._degree = ko.observable(null);
	
	self._yearOfGraduation = ko.observable(null);

	self.edit = function(){
		self.mode('edit');
	}
	
	self.cancel = function(){
		self.mode('view');
	}
	
	self.save = function(){
		$("#edit-profile-form").validate({
			rules:{
				firstName:{
					required: true
				},
				lastName:{
					required: true
				},
				yearOfGraduation:{
					number: true
				}
			}
		})
		var valid = $("#edit-profile-form").valid();
		if(!valid)
			return;
		showSpinner();
		var formData = {
			firstName: self._firstName(),
			lastName: self._lastName(),
			major: self._major(),
			degree: self._degree(),
			yearOfGraduation: self._yearOfGraduation()
		}
		$.post('/profile/updateProfile', formData, function(data) {
			if(!data['success'])
				notyMessage(data['message'],'warning');
			else{
				self.mode('view');
				self.getProfileSummary();
			}
			hideSpinner();
		});
	}
	
	self.getProfileSummary = function(){
		self.isProfileLoading(true);
		$.post('/profile/getProfileSummary', {userId:userId}, function(data) {
			if(data['success']){
				self.firstName(data['firstName']);
				self.lastName(data['lastName']);
				self.username(data['username']);
				self.major(data['major']);
				self.degree(data['degree']);
				self.yearOfGraduation(data['yearOfGraduation']);
				self._firstName(data['firstName']);
				self._lastName(data['lastName']);
				self._major(data['major']);
				self._degree(data['degree']);
				self._yearOfGraduation(data['yearOfGraduation']);
			}
			else{
				notyMessage(data['message'],'warning');
			}
			self.isProfileLoading(false);
		});
	}
}

$(document).ready(function() {
	homevm.getProfileSummary();
	ko.applyBindings(homevm, $('.home')[0]);
});