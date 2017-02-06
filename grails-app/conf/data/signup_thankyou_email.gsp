<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<body>
	<p>Hi <b>${firstName}</b>,</p>
	<p>This email is to notify that your Bookstore account has been created. Please following the link below to activate your account.</p>
	<p><a href="${serverURL}/accountActivate?id=${aat}">${serverURL}/accountActivate?id=${aat}</a></p>
	<p>Best wishes,</p>
	<p>Bookstore Team</p>
</body>
</html>