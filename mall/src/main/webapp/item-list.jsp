<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理後台</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <style>
        #table-container {
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 1500px;
            margin: auto;
        }

        .table th {
            background-color: #0d6efd;
            color: white;
            text-transform: uppercase;
            letter-spacing: 0.05em;
        }

        .table tbody tr:hover {
            background-color: #e9f2ff;
        }

        .table td, .table th {
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>
   <header>
      <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Home</a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
            <form class="d-flex">
              <input
                class="form-control me-2"
                type="search"
                placeholder="Search"
                aria-label="Search"
              />
              <button class="btn btn-outline-success" type="submit">
                Search
              </button>
            </form>
          </div>
        </div>
      </nav>
    </header>

    <main>
      <div class="container-fluid" style="background-color: lightgrey">
        <div class="row">
          <nav
            id="sidebarMenu"
            class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse"
          >
            <div class="position-sticky pt-3">
              <ul class="nav flex-column">
                <h6
                  class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted"
                >
                  <span>我的商品</span>
                  <a
                    class="link-secondary"
                    href="#"
                    aria-label="Add a new report"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="feather feather-plus-circle"
                      aria-hidden="true"
                    >
                      <circle cx="12" cy="12" r="10"></circle>
                      <line x1="12" y1="8" x2="12" y2="16"></line>
                      <line x1="8" y1="12" x2="16" y2="12"></line>
                    </svg>
                  </a>
                </h6>
                <li class="nav-item">
                  <a class="nav-link" href="<%=request.getContextPath()%>/list">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="feather feather-file"
                      aria-hidden="true"
                    >
                      <path
                        d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"
                      ></path>
                      <polyline points="13 2 13 9 20 9"></polyline>
                    </svg>
                    我的商品
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="<%=request.getContextPath()%>/new">
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="24"
                      height="24"
                      viewBox="0 0 24 24"
                      fill="none"
                      stroke="currentColor"
                      stroke-width="2"
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      class="feather feather-shopping-cart"
                      aria-hidden="true"
                    >
                      <circle cx="9" cy="21" r="1"></circle>
                      <circle cx="20" cy="21" r="1"></circle>
                      <path
                        d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"
                      ></path>
                    </svg>
                    新增商品
                  </a>
                </li>
              </ul>
            </div>
          </nav>

          <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="chartjs-size-monitor">
              <div class="chartjs-size-monitor-expand">
                <div class=""></div>
              </div>
              <div class="chartjs-size-monitor-shrink">
                <div class=""></div>
              </div>
            </div>
            <div
              class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom"
            >
              <h1 class="h2">我的商品</h1>
              <form class="d-flex">
                <input
                  class="form-control me-2"
                  type="search"
                  placeholder="商品名稱"
                  aria-label="Search"
                />
                <button
                  type="button"
                  class="btn btn-secondary dropdown-toggle"
                  id="dropdownMenuOffset"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                  data-bs-offset="10,20"
                >
                  分類
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">Another action</a></li>
                  <li>
                    <a class="dropdown-item" href="#">Something else here</a>
                  </li>
                </ul>
                <button class="btn btn-outline-success" type="submit">
                  搜尋
                </button>
              </form>
            </div>

            <div
              class="container-fluid"
              id="table-container"
              style="background-color: white"
            >

				<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>商品ID</th>
						<th>商品名稱</th>
						<th>商品價格</th>
						<th>商品地址</th>
						<th>商品資訊</th>
						<th>動作</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="item" items="${Items}">

						<tr>
							<td><c:out value="${item.getItemId()}" /></td>
							<td><c:out value="${item.getItemName()}" /></td>
							<td><c:out value="${item.getItemPrice()}" /></td>
							<td><c:out value="${item.getItemLocation()}" /></td>
							<td><c:out value="${item.getItemInfo()}" /></td>
							<td><a href="edit?itemId=<c:out value='${item.getItemId()}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?itemId=<c:out value='${item.getItemId()}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
				</table>
            </div>
            <h3>&nbsp;</h3>
          </main>
        </div>
      </div>
    </main>
</body>
</html>