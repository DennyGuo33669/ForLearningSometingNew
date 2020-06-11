<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .uptable{
            width: 600px;
            margin: 0 auto;
            border: 1px solid #000;
            text-align: center;
        }
        .uph1{
            margin-top: 20px;
        }
    </style>
</head>
<body>
<h1 class="uph1" align="center">学生信息修改页面</h1>
<form action="upServlet">
    <input type="hidden" name="number" value="<%=request.getParameter("number")%>">
    <table class="uptable" border="1">
        <tr>
            <td>学号： <input type="text" name="sid" value="<%=request.getParameter("sid")%>" readonly="readonly"></td>
        </tr>
        <tr>
            <td>姓名：<input type="text" name="sname" value="<%=request.getParameter("sname")%>"></td>
        </tr>
        <tr>
            <td>性别：<input type="radio" name="ssex" value="男">男
                <input type="radio" name="ssex" value="女">女</td>
        </tr>
        <tr>
            <td>出生日期:<input type="text" name="sbir" value="<%=request.getParameter("sbir")%>"></td>
        </tr>
        <tr>
            <td>系别：<select name="sxibie">
                <option value="信息系">信息系</option>
                <option value="外语系">外语系</option>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit"value="添加学生"><input type="reset" value="重置"></td>
        </tr>
    </table>

</form>
</body>
</html>
