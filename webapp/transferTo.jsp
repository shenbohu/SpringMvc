<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/quick22" enctype="multipart/form-data" method="post">
    <input type="text" name="username">
    <input type="file" name="multipartFile" value="选择">
    <input type="file" name="multipartFile" value="选择">
    <input type="file" name="multipartFile" value="选择">
    <input type="submit" value="提交">

</form>


</body>
</html>
