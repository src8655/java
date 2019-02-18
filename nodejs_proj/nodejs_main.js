var http = require('http');
var fs = require('fs');
var url = require('url');
var qs = require('querystring');	//post방식받기

//oracle
var oracledb = require('./node_modules/oracledb');
var dbConfig = require('./dbConfig.js');
//////////////////////////////////////////////////////

var view_board = require('./view/board.js');

var app = http.createServer(function(request, response) {
  var _url = request.url;  //주소
  var queryData = url.parse(_url, true).query;
  var pathname = url.parse(_url, true).pathname;
  
  if(_url == '/favicon.ico'){
    return response.writeHead(404);
  }
  
  
  if(pathname == "/board") {
	  var pages = queryData.pages;
	  if(pages == "" || pages == null) pages = 1;
	  
	  
	  
	  oracledb.getConnection(dbConfig, function(err, connection) {
		  connection.execute(
				  "SELECT count(*) FROM MIN_TEST_BOARD",
				  function(err, count_data) {
					  if(err) {
						  console.log(err.message);
						  connection.release(function(err) {});
						  return;
					  }
					  //총 개수
					  var count = count_data.rows;
					  
					  //페이징 만들기
					  var paging = require('./utils/paging.js');
					  paging.setPaging(count,5,pages);
					  
					  var query = "select NO,SUBJECT,NAME,HIT,DATES" +
					  		" from (select rownum as rnum,a.* from (select * from MIN_TEST_BOARD" +
					  		" order by NO desc) a) where rnum between :STARTS and :ENDS";
					  var binddata = [
						  Number(paging.board_starts),
						  Number(paging.board_ends)
					  ];
					  
					  connection.execute(
							  query,
							  binddata,
							  function(err, list_data) {

								  var getdata = require('./utils/getdata.js');
								  var list = getdata.getDatas(list_data);
								  
								  var data = {
										  'count' : count,
								  		  'list' : list,
								  		  'paging' : paging,
								  		  'pages' : pages
								  };
								  var template = view_board.getBoard("게시판",data);
								  response.writeHead(200);
								  response.end(template);
					  
								  connection.release(function(err) {});
							  }
					  );
					  
				  }
		  );
		  

		  
	  });

	  
  }
  
  
  
  
  
  
  if(pathname == "/board_view") {
	  var pages = queryData.pages;
	  if(pages == "" || pages == null) pages = 1;
	  
	  var no = queryData.no;
	  
	  

	  oracledb.getConnection(dbConfig, function(err, connection) {
			var query = "select NO,SUBJECT,NAME,HIT,DATES,MEMO,FILE1,FILE2" +
				" from MIN_TEST_BOARD where NO=:NO";
			var binddata = [
				  Number(no)
			];
			
			connection.execute(
				query,
				binddata,
				function(err, ldata_data) {
					
					//게시판 상세정보 가져오기
					var getdata = require('./utils/getdata.js');
					var ldata = getdata.getData(ldata_data);
					
					
					
					query = "select NO,NAME,MEMO,BOARD_NO,DATES,RT_NO,PASSWORD,LEVELS"
								+" from MIN_TEST_COMMENT where BOARD_NO=:NO order by NO asc";
					binddata = [
						  Number(no)
					];
					connection.execute(
						query,
						binddata,
						function(err, cdata_data) {
							
							//댓글 상세정보 가져오기
							var cdatas = getdata.getDatas(cdata_data);
							
							var data = {
								'cdatas' : cdatas,
								'ldata' : ldata,
								'pages' : pages,
								'no' : no
							};
							var template = view_board.getBoardView("게시판 보기",data);
							response.writeHead(200);
							response.end(template);
					
							connection.release(function(err) {});
						}
					);
				}
			);
	  });
	  
  }
  
  
  
  
  
  
  
  
  
  
  /*
  if(pathname == "/formtest") {
	  var template = tpl.getTemplate("폼전송",`
	      <form action="formtest_post" method="post">
            <p><input type="text" name="title" placeholder="title"></p>
            <p>
              <textarea name="description" placeholder="description"></textarea>
            </p>
            <p>
              <input type="submit">
            </p>
          </form>
	  `);
	  response.writeHead(200);
	  response.end(template);
  } 
  
  if(pathname == "/formtest_post") {
	  var body = '';
      request.on('data', function(data){
          body = body + data;
      });
      request.on('end', function(){
          var post = qs.parse(body);
          var title = post.title;
          var description = post.description
    	  var template = tpl.getTemplate("폼전송 완료",title+" "+description);
    	  response.writeHead(200);
    	  response.end(template);
      });
	  
  } 
  */
  
  
  //response.end(fs.readFileSync(__dirname + url));
});
app.listen(3001);