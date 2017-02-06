<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<body>
	<p>Hi <b>${firstName}</b>,</p>
	<p>Please follow the following link to activate your Bookstore account.</p>
	<p><a href="${serverURL}/accountActivate?id=${aat}">${serverURL}/accountActivate?id=${aat}</a></p>
	<p>Best wishes,</p>
	<p>Bookstore Team</p>
</body>
</html>