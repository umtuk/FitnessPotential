<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitness Potential</title>
</head>
<body>
    Index
    <a href="/oauth2/authorization/kakao"><h1>kakao login</h1></a>
    ${user.nickname}
    <img src="${user.profileImageUrl}" alt="">
    <a href="/community"><h1>community</h1></a>
</body>
</html>