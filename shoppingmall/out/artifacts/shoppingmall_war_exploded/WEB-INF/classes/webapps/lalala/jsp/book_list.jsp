<%@ page import="java.util.List" %>
<%@ page import="com.nf.bookstore1.entity.Book" %>
<%@ page import="util.WebUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>图书列表</title>
</head>
<body>

<%= WebUtil.popSessionMsg(request) %>

<form action="/book/del" method="post">
    <table class="table table-striped">
        <tr>
            <th><input type="checkbox" onclick="alls(this)"></th>
            <th>id</th>
            <th>书名</th>
            <th>价格</th>
            <th>作者</th>
            <th>出版社</th>
            <th>其他</th>
        </tr>
        <%
            List<Book> books = (List<Book>) request.getAttribute("books");

            for (Book book : books) {
        %>
        <tr>
            <td><input name="id" value="<%= book.getId()%>" type="checkbox"></td>
            <td><%= book.getId() %>
            </td>
            <td><a href="/book/detail?id=<%= book.getId()%>"><%= book.getName() %>
            </a></td>
            <td><%= book.getPrice() %>
            </td>
            <td><%= book.getAuthor() %>
            </td>
            <td><%= book.getPress() %>
            </td>
            <td>
                <a href="/book/del?id=<%= book.getId() %>">删除</a>
                <a href="/book/update?id=<%= book.getId() %>">更新</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>


    <div style="margin-top: 2em;">
        <input type="submit" value="删除" class="btn btn-success">
        <a href="/book/add">增加新的书籍</a>
    </div>
</form>

<script>
    function alls(e) {
        var checkboxs = document.getElementsByName("id");
        for (var i = 0; i < checkboxs.length; i++) {
            checkboxs[i].checked = e.checked
        }
    }

    document.querySelector("#booklist").classList.add("active");
</script>
</body>
</html>
