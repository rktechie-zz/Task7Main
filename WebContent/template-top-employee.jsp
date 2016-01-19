<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Carnegie Financial Services</title>
</head>
<body>
<body>

    <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="login.do">CFS</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="login.do">HOME</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">CUSTOMER ACCOUNT
                 <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="createCustomer.do">CREATE CUSTOMER ACCOUNT</a></li>
                    <li><a href="changePassword.do">RESET CUSTOMER PASSWORD</a></li>
                    <li><a href="viewCustomerAccount.do">VIEW CUSTOMER ACCOUNT</a></li>
                </ul></li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">EMPLOYEE OPERATION
                 <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="depositCheck.do">DEPOSIT CHECK</a></li>
                    <li><a href="createFund.do">CREATE FUND</a></li>
                    <li><a href="transitionDay.do">TRANSITION DAY</a></li>
                </ul></li>
            <li><a href="createEmployee.do">CREATE EMPLOYEE ACCOUNT</a></li>
             <li><a href="logOut.jsp">LOG OUT</a></li>
        </ul>
    </div>
    </nav>
