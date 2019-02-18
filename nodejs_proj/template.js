var M = {
	getTemplate:function (title, data) {
		var template = `
			  
			  	<!DOCTYPE html>
				<html>
				<head>
					<meta charset="UTF-8">
					<title>${title}</title>
					<style type="text/css">
					body {
					font-family:'돋움';
					margin:0px;
					padding:0px;
					font-size:12px;
					}
					.comments {
					width:100%;
					padding:10px;
					margin:10px 0 0 0;
					border-collapse:collapse;
					}
					.comments tr th {
					border-top:1px solid #122942;
					}
					.comments tr td {
					border:1px solid #bbbbbb;
					}
					.comments input {
					background:#ffffff;
					width:98%;
					height:20px;
					line-height:20px;
					border:1px solid #cccccc;
					font-size:15px;
					}
					.comments textarea {
					width:99%;
					font-size:15px;
					}
					.comments a {
					font-size:12px;
					color:#676767;
					text-decoration:none;
					}
					.boards {
					font-size:12px;
					width:100%;
					margin:0px;
					border-collapse:collapse;
					}
					.boards th {
					border-top:2px solid #122942;
					border-bottom:1px solid #A0A0A0;
					height:35px;
					line-height:35px;
					margin:0px;
					padding:0px;
					}
					.boards td {
					border-bottom:1px solid #A0A0A0;
					padding:10px 3px 10px 3px;
					}
					.boards td a {
					text-decoration:none;
					color:#000000;
					}
					.boards_b {
					width:100%;
					height:26px;
					margin:10px 0 0 0;
					padding:0px;
					overflow:hidden;
					}
					.boards_bl {
					width:30%;
					float:left;
					text-align:left;
					overflow:hidden;
					}
					.boards_br {
					width:30%;
					float:right;
					text-align:right;
					overflow:hidden;
					}
					.boards_bc {
					width:40%;
					height:26px;
					line-height:26px;
					float:left;
					text-align:center;
					overflow:hidden;
					}
					.boards_bc a {
					text-decoration:none;
					color:#000000;
					margin:0 3px 0 0;
					}
					.boards input {
					border:1px solid #cccccc;
					width:150px;
					height:25px;
					line-height:25px;
					font-size:15px;
					margin:0px;
					padding:0px;
					overflow:hidden;
					}
					.btn_st {
					border:0px;
					border-radius:5px;
					background:#666666;
					color:#ffffff;
					padding:0px;
					width:83px;
					height:24px;
					line-height:24px;
					text-decoration:none;
					display:block;
					font-size:12px;
					text-align:center;
					font-weight:bold;
					overflow:hidden;
					}
					.b_memo {
					border:1px solid #cccccc;
					width:99%;
					height:200px;
					font-size:15px;
					margin:0px;
					padding:0px;
					}
					</style>
					
					<script type="text/javascript">
						function showhide(var1) {
							if(document.getElementById(var1).style.display == "none")
								document.getElementById(var1).style.display = "";
							else
								document.getElementById(var1).style.display = "none";
						}
					</script>
				</head>
				<body>
				
				<div style="width:700px;margin:0 auto;overflow:hidden;">
					<h1 style="width:400px;margin:0 auto;margin-top:30px;margin-bottom:10px;font-size:35px;font-weight:bold;overflow:hidden;text-align:center;border-top:1px solid #cccccc;border-bottom:1px solid #cccccc;padding:20px 0 20px 0;">
						게시판
					</h1>
					${data}
					<div style="margin:20px 0 20px 0;overflow:hidden;text-align:center;border-top:1px solid #cccccc;border-bottom:1px solid #cccccc;padding:15px 0 15px 0;">
						Copyright ⓒ 2018 Minho All Right reserved.
					</div>
				</div>
				
				</body>
				</html>
			  `;
		return template;
	}
}
module.exports = M;