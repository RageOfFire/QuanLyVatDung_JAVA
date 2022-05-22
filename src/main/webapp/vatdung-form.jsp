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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body class="bg-slate-600">
<jsp:include page="header.jsp" />
		<caption>
		<h1 class="text-center text-lime-600 text-5xl my-5">
			<c:if test="${ks != null}">Sửa thông tin vật dụng</c:if>
			<c:if test="${ks == null}">Thêm vật dụng mới</c:if>
		</h1>
		</caption>
		<div
		class="box-content h-100 w-100 p-4 border-lime-600 border-dashed border-2 m-5">
		<c:if test="${ks != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${ks == null}">
			<form action="insert" method="post">
		</c:if>
		<c:if test="${ks != null}">
			<input type="hidden" name="MaVatDung"
				value="<c:out value='${ks.maVatDung}'/>" />
		</c:if>
		<div class="mb-6">
			<label for="TVD"
				class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Tên
				vật dụng</label> <input type="text" id="TVD"
				class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
				required name="TenVatDung" value="<c:out value='${ks.tenVatDung}'/>">
		</div>
		<div class="mb-6">
			<label for="SL"
				class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Số
				lượng</label> <input type="number" id="SL"
				class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
				name="SoLuong" value="<c:out value='${ks.soLuong}'/>">
		</div>
		<div class="mb-6">
			<label for="TT"
				class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Tình
				trạng</label> <input type="text" id="TT"
				class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
				name="TinhTrang" value="<c:out value='${ks.tinhTrang}'/>">
		</div>
		<div class="mb-6">
			<label for="GC"
				class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Ghi
				chú</label> <input type="text" id="GC"
				class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
				name="GhiChu" value="<c:out value='${ks.ghiChu}'/>">
		</div>
		<button type="submit"
			class="text-white bg-gradient-to-r from-cyan-500 to-blue-500 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-cyan-300 dark:focus:ring-cyan-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2">Nhập</button>
		</form>
	</div>
</body>
</html>