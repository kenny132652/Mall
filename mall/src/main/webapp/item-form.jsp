<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品編輯</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

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
                  <a class="nav-link" href="#">
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
              <h1 class="h2">商品編輯</h1>
            </div>
            
            <div
              class="container-fluid"
              id="itemcontainer"
            >
				<div>
				 	<c:if test="${item != null}">
                        <form action="update" method="post">
                    </c:if>
                    <c:if test="${item == null}">
                        <form action="insert" method="post">
                    </c:if>
				
				    <caption>
                        <h2>
                            <c:if test="${item != null}">
                                編輯商品
                            </c:if>
                            <c:if test="${item == null}">
                                新增商品
                            </c:if>
                        </h2>
                    </caption>
					
					<c:if test="${item != null}">
                        <input type="hidden" name="itemId" value="<c:out value='${item.getItemId()}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Item Name</label> <input type="text" value="<c:out value='${item.getItemName()}' />" class="form-control" name="itemName" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Price</label> <input type="text" value="<c:out value='${item.getItemPrice()}' />" class="form-control" name="itemPrice">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Location</label> <input type="text" value="<c:out value='${item.getItemLocation()}' />" class="form-control" name="itemLocation">
                    </fieldset>
                    
                    <fieldset class="form-group">
                        <label>Brand</label> <input type="text" value="<c:out value='${item.getItemBrand()}' />" class="form-control" name="itemBrand">
                    </fieldset>
                    
                    <fieldset class="form-group">
                        <label>Category</label> <input type="text" value="<c:out value='${item.getItemCategory()}' />" class="form-control" name="itemCategory">
                    </fieldset>      
                    
                    <fieldset class="form-group">
                        <label>Info</label> <input type="text" value="<c:out value='${item.getItemInfo()}' />" class="form-control" name="itemInfo">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>itemCoupon</label> <input type="text" value="<c:out value='${item.getItemCoupon()}' />" class="form-control" name="itemCoupon">
                    </fieldset>      

                    <fieldset class="form-group">
                        <label>itemAd</label> <input type="text" value="<c:out value='${item.getItemAd()}' />" class="form-control" name="itemAd">
                    </fieldset>  

                    <button type="submit" class="btn btn-success">Save</button>
                    </form>
				
				
				
				
				
				
				</div>
            
            
            
            
            </div>


            <h3>&nbsp;</h3>
          </main>
        </div>
      </div>
    </main>



</body>
</html>