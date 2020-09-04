<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>부모창입니다</title>
<head>
</head>
<script language="javascript">
	function setCookie(name, value, expiredays) {
		var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + expiredays);
		document.cookie = name + "=" + escape(value) + "; path=/; expires="
				+ todayDate.toGMTString() + ";"
	}
	function closeModal() {
		if (document.myform.event.checked)// 폼네임 myform 은 동일해야 합니다.
			setCookie("memo", "no", 1); // 1일 간 쿠키적용 // 부모창에서 지정한 쿠키네임과 일치 해야 합니다.
	}
</script>
<style>
/* The Modal (background) */
.searchModal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 10; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}
/* Modal Content/Box */
.search-modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 70%; /* Could be more or less, depending on screen size */
}
</style>
</head>
<body>
	<div id="modal" class="searchModal">
		<div class="search-modal-content">

			<div class="page-header">

				<h1>MODAL</h1>

			</div>

			<div class="row">

				<div class="col-sm-12">

					<div class="row">

						<div class="col-sm-12">

							<h2>Modal창 테스트입니다.</h2>

						</div>

					</div>

				</div>

			</div>

			<hr>
			<form name="myform">
			<div
				style="cursor: pointer; background-color: #DDDDDD; text-align: center; padding-bottom: 10px; padding-top: 10px;"
				onClick="closeModal();">
				<input type=button value="닫기" onclick="self.close()">
			</div>
			</form>
		</div>
	</div>

</body>
<script>

	/*function closeModal() {
		$('.searchModal').hide();

	};*/
</script>

</html>