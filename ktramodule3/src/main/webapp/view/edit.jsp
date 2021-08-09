<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Edit</h2>
    <form method="post">
        <table class="table table-bordered table-sm">

            <tbody>
            <tr>
                <td><input type="text" name="id" value="${editsp.id}" readonly></td>
            </tr>
            <tr>
                <td><input type="text" name="name" value="${editsp.name}"></td>
            </tr>
            <tr>
                <td><input type="text" name="price" value="${editsp.price}"></td>
            </tr>
            <tr>
                <td><input type="text" name="amount" value="${editsp.amount}"></td>
            </tr>
            <tr>
                <td><input type="text" name="color" value="${editsp.color}"></td>
            </tr>
            <tr>
                <td><input type="text" name="description" value="${editsp.description}"></td>
            </tr>
            <tr>
                <td><select name="categoryId">
                    <c:forEach items="${listCategory}" var="c">
                        <c:if test="${editsp.categoryId == c.id}">
                            <option value="${c.id}" selected="selected">${c.name}</option>
                        </c:if>
                        <c:if test="${editsp.categoryId != c.id}">
                            <option value="${c.id}">${c.name}</option>
                        </c:if>
                    </c:forEach>

                </select></td>
            </tr>
            <tr>
                <td>
                    <button type="submit" class="btn btn-success">Edit</button>
                    |<a href="/sanpham" class="btn btn-secondary">Back</a>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

</body>
</html>


