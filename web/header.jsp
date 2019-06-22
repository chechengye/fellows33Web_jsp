<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<li><a href="login.jsp">登录</a></li>
			<li><a href="register.jsp">注册</a></li>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group" style="position: relative;">
						<input id="search" type="text" class="form-control" placeholder="Search" onkeyup="searchWord(this)">
						<div id="searchStr" style="z-index:1000 ; display:none;position:absolute ; width: 174px ; height: 240px; background: white"></div>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
	<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		function searchWord(obj) {
			var word = $(obj).val();
			var contentStr = "";
			if(word != ""){
                $.ajax({
                    url:${pageContext.request.contextPath}"/searchWord",
                    type:"POST",
                    success:function (data) {
                        if(data.length>0){
                            for(var i = 0 ; i < data.length ; i++){
                                contentStr += "<div style='font-size: 12px;padding: 5px;' onmouseover='fn1(this);' onmouseout='fn2(this);' onclick='fn3(this);'>" + data[i].pname +"</div>";
                            }
                            $("#searchStr").html(contentStr);
                            $("#searchStr").css("display","block");
                        }

                    },
                    dataType:"json",
                    data:{"word":word}
                });
			}else{
                $("#searchStr").css("display","none");
            }

        }
        function fn1(obj) {
			$(obj).css("background" , "#1E6BAE");
        }

        function fn2(obj) {
            $(obj).css("background" , "#fff");
        }

        function fn3(obj) {
            var pname = $(obj).html();
			$("#search").val(pname);
            $("#searchStr").css("display","none");
        }
	</script>
</div>