<html>
<head>
<title> New Document </title>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv=content-type content=text/html;charset=utf-8>
<base target="_self">
<style type=text/css>
	<!--

	html {
		height:100%;
		border:0;
	}

	body {
		height:100%;
		font-size:9pt;
	}

	form {
		margin: 0px;
		padding: 0px;
		display:inline;
	}

	-->
</style>
<script>
	function getQueryVariable(variable) {
		var query = window.location.search.substring(1);
		var vars = query.split("&");
		for (var i=0;i<vars.length;i++) {
			var pair = vars[i].split("=");
			if (pair[0] == variable) {
				return pair[1];
			}
		}
		return '';
	}
</script>
<?PHP
if($_POST['source']) {
function saveRemoteImage($str) {

	$rootPath = '/home/public_html/'; // 서버 root 의 절대경로 (게시판의 절대경로가 아님!!!!!!!!!!!!!) (끝에 / 필수!)
	$myDomain = 'alik.info'; // 본인 도메인  (자기도메인에서 삽입된 이미지는 저장하지 않기 위하여)
	$saveDir = 'remoteImages'; // 저장될 폴더의 이름 (루트에 생성하고 권한은 777 로 준다)

	$email = "aaa@aaa.com"; //싸이월드 로그인용 이메일주소
	$pass = 'aaaa'; // 싸이월드 로그인용 비밀번호

	include "Snoopy.class.php";
	$content = '';

	$str = stripslashes($str);

	$imgPattern = "/<img.+?src=(.[^\s\>]+)/si";

	preg_match_all($imgPattern,$str,$match, PREG_SET_ORDER);
	
	if(count($match) > 0) {
		$match = multi_unique($match);		
	}

	foreach($match as $value) {

	    $url =$value[1];
	    $url = preg_replace("/(\"|\'|\\\)/","",$url);

		if((strpos(strtolower($url), "http") === false) || (strpos(strtolower($url), strtolower($myDomain)) !== false)) {
			continue;
		}

		if( strpos($url, "cyimg") !== false )
		{
			$snoopy = new Snoopy;
			$snoopy ->referer = "http://cyworld.nate.com";
			$submit_url = "http://cyxso.cyworld.nate.com/login.jsp";

			$vars['email'] = $email;
			$vars['passwd'] = $pass;
			$vars['return_domain'] = 'minihp.cyworld.nate.com';
			$vars['pop'] = 'ok';
			$vars['dest'] = 'http://cyworld.nate.com';

			if ($snoopy -> submit($submit_url, $vars))
			{
				if (!strstr($snoopy -> results, "opener")) 
				{ 
					continue;
				} else {
					if ($snoopy -> fetch($url)) {
						$content = $snoopy -> results;			
					} else {
						continue;										
					}
				}
			} else {
				continue;
			}
		}
		else
		{
			$parsedUrl = parse_url($url);
			$snoopy = new Snoopy;
			$snoopy ->referer = $parsedUrl['scheme'].$parsedUrl['host'];
			if($snoopy -> fetch($url)) {
				$content =  $snoopy -> results;
			} else {
				continue;
			}
		}

		$savePath = $rootPath.$saveDir."/";

		$savePath .= date("Y_m")."/";
		if(!is_dir($savePath)) {
			mkdir($savePath, 0777);
			chmod($savePath, 0777);
		}

		(strrchr($url, "."))? 
			$file_ext = ".".strtolower(substr(strrchr(urldecode($url), "."),1)) : 
			$file_ext = '';

		$filename = $savePath.date("d_H_i_").mt_rand() .$file_ext;

		$newFile = fopen($filename,"wb");
		fwrite($newFile,$content);
		fclose($newFile);

		$newUrl = str_replace($rootPath, '/', $filename);
		$newTag = str_replace($value[1], "'".$newUrl."'", $value[0]);
		$str = str_replace($value[0], $newTag, $str);
	}

	//$str = addslashes($str);

	Return $str;
}

function multi_unique($array) {
	foreach ($array as $k=>$na)
		$new[$k] = serialize($na);
	$uniq = array_unique($new);
	foreach($uniq as $k=>$ser)
		$new1[$k] = unserialize($ser);
	return ($new1);
}
?>
</head>
<body>
<div align=center>
이미지 저장중......<br /><br /><font color='red'>닫지 마시오!</font>
</div>
<?PHP
		$str = rawurlencode(saveRemoteImage($_POST['source']));
?>
<script language=javascript type=text/javascript>
if (window.dialogArguments)
{
	window.dialogArguments.value = "<?=$str?>";
	window.close();
} else {
	var _iframe = opener.document.getElementById('<?=$_POST['id']?>');
	_iframe.nextSibling.value =  "<?=$str?>";
	opener.saved = true;
	self.close();
}
</script>
</body>
<?PHP
} else {
?>
<script language=javascript type=text/javascript>
window.name = "modal";

if (window.dialogArguments)
{
	window.onload = function () {
		document.getElementById('txt').value = window.dialogArguments.value;
		document.forms['temp'].submit();
	}
} else {
	window.onload = function () {
		var _iframe = opener.document.getElementById(getQueryVariable('id'));
		document.getElementById('txt').value = _iframe.nextSibling.value;
		document.getElementById('id').value = getQueryVariable('id');
		document.forms['temp'].submit();
	}
}
</script>
</head>
<body>
<form name="temp" method="post" action="<?=$_SERVER['PHP_SELF']?>" target="modal">
<textarea id="txt" style="display:none;" name="source"></textarea>
<input type="hidden" name="id" id="id">
</form>
<div align=center>
이미지 저장중......<br /><br /><font color='red'>닫지 마시오!</font>
</div>
</body>

<?}?>
</html>
