<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
  <nav class="bg-gray-800">
    <div class="max-w-7xl mx-auto px-2 sm:px-6 lg:px-8">
      <div class="relative flex items-center justify-between h-16">
        <div class="flex-1 flex items-center justify-center sm:items-stretch sm:justify-start">
          <div class="flex-shrink-0 flex items-center">
            <img class="hidden lg:block h-8 w-auto"
              src="${pageContext.request.contextPath}/Icon/hotel-1880.png" alt="">
          </div>
          <div class="hidden sm:block sm:ml-6">
            <div class="flex space-x-4">
              <a href="<%=request.getContextPath()%>/" class="bg-gray-900 text-white px-3 py-2 rounded-md text-sm font-medium"
                aria-current="page">Trang chủ</a>

              <a href="<%=request.getContextPath()%>/list"
                class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Vật dụng</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </nav>