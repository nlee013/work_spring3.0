<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Contact | Muse-Market</title>
    <link href=" css/bootstrap.min.css" rel="stylesheet">
    <link href=" css/font-awesome.min.css" rel="stylesheet">
    <link href=" css/prettyPhoto.css" rel="stylesheet">
    <link href=" css/price-range.css" rel="stylesheet">
    <link href=" css/animate.css" rel="stylesheet">
	<link href=" css/main.css" rel="stylesheet">
	<link href=" css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href=" images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1 : 1</title>

<link rel="stylesheet" type="text/css" href=" css/style.css"/>
<link rel="stylesheet" type="text/css" href=" css/created.css"/>

<script type="text/javascript">

function sendIt(){
	
	var f = document.myForm;
	
	str = f.cSubject.value;
	str = str.trim();
	
	if(!str){
		alert("\n제목을 입력하세요.");
		f.cSubject.focus();
		return;
	}
	f.cSubject.value = str;
	
	str = f.userId.value;
	str = str.trim();
	
	if(!str){
		alert("\n아이디를 입력하세요.");
		f.userId.focus();
		return;
	}		
	
	/* if(!isValidKorean(str)){
		alert("\n이름을 정확히 입력하세요.");
		f.name.focus()
		return;
	}		 */
	f.userId.value = str;
	
	str = f.message.value;
	str = str.trim();
	
	if(!str){
		alert("\n내용을 입력하세요.");
		f.message.focus();
		return;
	}
	f.message.value = str;
	
	str = f.userEmail.value;
	str = str.trim();
	
	if(!str){
		alert("\n이메일을 입력하세요.");
		f.userEmail.focus();
		return;
	}
	f.userEmail.value = str;
	
	str = f.userPwd.value;
	str = str.trim();
	if(!str){
		alert("\n비밀번호를 입력하세요.");
		f.userPwd.focus();
		return;
	}
	f.userPwd.value = str;
	
	f.action = "/qa_contact_ok.action";
	f.submit();
	
}
</script>


</head>
<body>

<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +82 123 1234</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> info@muse.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.html"><img src=" images/home/muse.png" alt=""  style="width:60px"/></a>
						</div>
						<div class="btn-group pull-right">
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									Korea
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">USA</a></li>
									<li><a href="#">UK</a></li>
								</ul>
							</div>
							
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									Won
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Dollar</a></li>
									<li><a href="#">Pound</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-user"></i> Account</a></li>
								<li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>
								<li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
								<li><a href="cart.html"><i class="fa fa-shopping-cart"></i> Cart</a></li>
								<li><a href="login.html"><i class="fa fa-lock"></i> Login</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.action" class="active">Home</a></li>
								<li class="dropdown"><a href="#">Sale<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="shop.html">Art(Whole)</a></li>
                                        <li><a href="shop.html">Art- Poster</a></li>                                        
                                        <li><a href="shop.html">Art - Figure</a></li>
										<li><a href="product-details.html">Art - Exhibition goods</a></li> 
										<li><a href="checkout.html">Art - Extra</a></li> 
										
										<li><a href="/list.action">Community</a></li>
                                        <li><a href="shop.html">Music(Whole)</a></li>
                                        <li><a href="shop.html">Music - LP</a></li>
                                        
                                        <li><a href="shop.html">Music - Video/DVD</a></li>
										<li><a href="product-details.html">Music - Tape</a></li> 
										<li><a href="checkout.html">Music - Instruments</a></li>
										<li><a href="checkout.html">Music - Extra</a></li> 
                                    </ul>
                                </li>
                               
								<li class="dropdown"><a th:href="@{list.action}">Purchase<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">                                                                       
                                        <li><a href="shop.html">Art(Whole)</a></li>
                                        <li><a href="shop.html">Art- Poster</a></li>                                  
                                        <li><a href="shop.html">Art - Figure</a></li>
										<li><a href="product-details.html">Art - Exhibition goods</a></li> 
										<li><a href="checkout.html">Art - Extra</a></li> 
										
                                        <li><a href="shop.html">Music(Whole)</a>
                                        <li><a href="shop.html">Music - LP</a></li>
                                        <li><a href="shop.html">Music - Video/DVD</a></li>
										<li><a href="product-details.html">Music - Tape</a></li> 
										<li><a href="checkout.html">Music - Instruments</a></li>
										<li><a href="checkout.html">Music - Extra</a></li> 
                                    </ul>
                                </li> 
								<li><a th:href="@{list.action}">Community</a></li>
								
								<li class="dropdown"><a th:href="@{qa_contact.action}">Contact<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
										<li><a th:href="@{qa_list.action}">Q & A</a></li>
										<li><a th:href="@{qa_contact.action}">Contact 1:1</a></li>
									</ul>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	 
	 <div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12">    			   			
					<h2 class="title text-center">Contact <strong>1:1</strong></h2>    			    				    				
					<div id="gmap" class="contact-map">
					
					<div id="bbsList">	


<div id="bbs">
	
	<!-- form 시작 -->
	<form action="" method="post" name="myForm" id="main-contact-form" class="contact-form row">
	
	<div class="row">  	
	    		<div class="col-sm-8">
	    			<div class="contact-form">
	    				
	    				<div class="status alert alert-success" style="display: none"></div>
				    	
				            <div class="form-group col-md-6">
				                <input type="text" name="userId" class="form-control" required="required" placeholder="Id">
				            </div>
				            <div class="form-group col-md-6">
				                <input type="email" name="userEmail" class="form-control" required="required" placeholder="Email">
				            </div>
				            <div class="form-group col-md-12">
				                <input type="text" name="cSubject" class="form-control" required="required" placeholder="Subject">
				            </div>
				            <div class="form-group col-md-12">
				                <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Your Message Here"></textarea>
				            </div>
				             <div class="form-group col-md-6">
				                <input type="password" name="userPwd" class="form-control" required="required" placeholder="Pwd">
				            </div>                     
				          	
						    </div><!--/#contact-page-->   
										                	
							<!-- 버튼 -->
							<div id="bbsCreated_footer">
								<input type="button" value=" 등록하기 " class="btn2"
								onclick="javascript:location.href='/qa_contact_ok.action';"/>
								<input type="reset" value=" 다시입력 " class="btn2" 
								onclick="document.myForm.subject.focus();"/>
								<input type="button" value=" 작성취소 " class="btn2"
								onclick="javascript:location.href='/contact_list.action';"/>	
							</div>				   
				        </div>			 		
					</div>   
				</form>	    		
	    	</div>
	    </div>
	    		<div class="col-sm-4">
	    			<div class="contact-info">
	    				<h2 class="title text-center">Contact Info</h2>
	    				<address>
	    					<p>Muse-Market Inc.</p>
							<p>935 W. Webster Ave New Streets Seoul, IL 60614, NY</p>
							<p>Seoul Republic of Korea</p>
							<p>Tel: +82 123 1234</p>
							<p>Fax: 1-714-252-0026</p>
							<p>Email: info@muse-market.com</p>
	    				</address>
	    				<div class="social-networks">
	    					<h2 class="title text-center">Social Networking</h2>
							<ul>
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-google-plus"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-youtube"></i></a>
								</li>
							</ul>
	    				</div>
	    			</div>
    			</div>    			
	    	</div>

</div>

	    	</div>
	
</div>
					</div>
				
	
	<footer id="footer"><!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="companyinfo">
							<h2><span>Muse</span>-Market</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor</p>
						</div>
					</div>
					<div class="col-sm-7">
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe1.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 MAY 2022</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe2.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe3.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe4.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="address">
							<img src="images/home/map.png" alt="" />
							<p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Service</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Online Help</a></li>
								<li><a href="">Contact Us</a></li>
								<li><a href="">Order Status</a></li>
								<li><a href="">Change Location</a></li>
								<li><a href="">FAQ’s</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Quock Shop</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">T-Shirt</a></li>
								<li><a href="">Mens</a></li>
								<li><a href="">Womens</a></li>
								<li><a href="">Gift Cards</a></li>
								<li><a href="">Shoes</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Policies</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Terms of Use</a></li>
								<li><a href="">Privecy Policy</a></li>
								<li><a href="">Refund Policy</a></li>
								<li><a href="">Billing System</a></li>
								<li><a href="">Ticket System</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Company Information</a></li>
								<li><a href="">Careers</a></li>
								<li><a href="">Store Location</a></li>
								<li><a href="">Affillate Program</a></li>
								<li><a href="">Copyright</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Your email address" />
								<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
								<p>Get the most recent updates from <br />our site and be updated your self...</p>
							</form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
					<p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->
	

  
    <script src=" js/jquery.js"></script>
	<script src=" js/bootstrap.min.js"></script>
	<script type=" text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script type="text/javascript" src="js/gmaps.js"></script>
	<script src=" js/contact.js"></script>
	<script src=" js/price-range.js"></script>
    <script src=" js/jquery.scrollUp.min.js"></script>
    <script src=" js/jquery.prettyPhoto.js"></script>
    <script src=" js/main.js"></script>
</html>