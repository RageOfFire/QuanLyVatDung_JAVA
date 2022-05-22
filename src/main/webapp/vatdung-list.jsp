<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vật dụng</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body class="bg-slate-600">
<jsp:include page="header.jsp" />
  <div class="bg-white border-gray-200 px-2 sm:px-4 py-2.5 rounded dark:bg-slate-600 m-5">
    <div class="container flex flex-wrap justify-between items-center mx-auto">
      <div class="flex md:order-2">
        <div class="hidden relative md:block">
          <div class="flex absolute inset-y-0 left-0 items-center pl-3 pointer-events-none">
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>
          <form action="search" method="get">
          <input type="text" id="search-navbar" name="Search" class="block p-2 pl-10 w-full text-gray-900 bg-gray-50 rounded-lg border border-gray-300 sm:text-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Tìm kiếm..." required>
          <button id="search-btn" type="submit" style="display: none;">Tìm kiếm</button>
          </form>
        </div>
      </div>
        <ul class="flex flex-col mt-4 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium">
          <li>
          <a href="<%=request.getContextPath()%>/new">
          	<button type="button" class="text-gray-900 bg-gradient-to-r from-red-200 via-red-300 to-yellow-200 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-red-100 dark:focus:ring-red-400 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2"><i class="fa-solid fa-plus"></i></button>
          </a>
          </li>
        </ul>
    </div>
  </div>
  <div class="relative overflow-x-auto shadow-md sm:rounded-lg m-5">
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3 text-center">
                    Mã vật dụng
                </th>
                <th scope="col" class="px-6 py-3 text-center">
                    Tên vật dụng
                </th>
                <th scope="col" class="px-6 py-3 text-center">
                    Số lượng
                </th>
                <th scope="col" class="px-6 py-3 text-center">
                    Tình trạng
                </th>
                <th scope="col" class="px-6 py-3 text-center">
                  Ghi chú
                </th>
                <th scope="col" colspan="2" class="px-6 py-3 text-center">
                    Chỉnh sửa
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKS}" var="ks">
            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 dark:text-white whitespace-nowrap text-center">
                    <c:out value="${ks.maVatDung}" />
                </th>
                <td class="px-6 py-4 text-center">
                    <c:out value="${ks.tenVatDung}" />
                </td>
                <td class="px-6 py-4 text-center">
                    <c:out value="${ks.soLuong}" />
                </td>
                <td class="px-6 py-4 text-center">
                    <c:out value="${ks.tinhTrang}" />
                </td>
                <td class="px-6 py-4 text-center">
                  <c:out value="${ks.ghiChu}" />
                </td>
                <td class="px-3 py-4 text-center">
                <a href="edit?MaVatDung=<c:out value="${ks.maVatDung}" />">
                	<button type="button" class="text-gray-900 bg-gradient-to-r from-lime-200 via-lime-400 to-lime-500 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-lime-300 dark:focus:ring-lime-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2"><i class="fa-solid fa-pen-to-square"></i></button>
                </a>
                </td>
                <td class="px-3 py-4 text-center">
                <a href="delete?MaVatDung=<c:out value="${ks.maVatDung}" />">
                	<button type="button" class="text-white bg-gradient-to-r from-red-400 via-red-500 to-red-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2"><i class="fa-solid fa-trash"></i></button>
                </a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>