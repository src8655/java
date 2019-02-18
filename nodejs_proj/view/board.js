var tpl = require("../template.js");

var M = {
		dc:function (data) {
			return decodeURIComponent(data);
		},
		getBoard:function (title, data) {

			var view = `
				  


					<table cellpadding="7" cellspacing="0" class="boards">
					<col width="60" />
					<col width="1" />
					<col width="240" />
					<col width="1" />
					<col width="70" />
					<col width="1" />
					<col width="70" />
					<col width="1" />
					<col width="60" />
						<tr>
							<th>번호</th>
							<th><span style="font-weight:normal;">|</span></th>
							<th>제목</th>
							<th><span style="font-weight:normal;">|</span></th>
							<th>이름</th>
							<th><span style="font-weight:normal;">|</span></th>
							<th>날짜</th>
							<th><span style="font-weight:normal;">|</span></th>
							<th>조회수</th>
						</tr>
					`;

			var i = 0;
			//0NO,1SUBJECT,2NAME,3HIT,4DATES
			for(i=0;i<data.list.length;i++) {
				var ldata = data.list[i];
				
				var no = data.paging.board_total-i-(data.pages*data.paging.board_lengths-data.paging.board_lengths);

				view += `
							<tr>
								<td align="center">${no}</td>
								<td></td>
								<td>
								  <a href="board_view?pages=${data.pages}&amp;no=${this.dc(ldata.no)}">
								    ${this.dc(ldata.subject)}
								  </a></td>
								<td></td>
								<td align="center">${this.dc(ldata.name)}</td>
								<td></td>
								<td align="center">${this.dc(ldata.dates)}</td>
								<td></td>
								<td align="center">${this.dc(ldata.hit)}</td>
							</tr>
							`;
			}
						
				view += `</table>
					
					<div class="boards_b">
						<div class="boards_bl">
							&nbsp;
						</div>
						<div class="boards_bc">
							<a href="board?pages=1" class="list_page_a">◀</a>
						`;
				for(i=data.paging.pstarts;i<=data.paging.pends;i++) {
					view += `<a href="board?pages=${i}" `;
					if(data.pages == i) view += ` style="color:red;font-weight:bold;"`;
					view += ` >${i}</a>`;
				}
				view += `
							<a href="board?pages=${data.paging.board_paging}" class="list_page_a">▶</a>
						</div>
						<div class="boards_br">
							<a href="board_write?pages=${data.pages}" class="btn_st" style="float:right;margin:0 10px 0 0;">작성하기</a>
						</div>
					</div>
					



				  `;
			
			var template = tpl.getTemplate(title, view);
			
			return template;
		},
		

		getBoardView:function (title, data) {
			var ldata = data.ldata;
			var cdatas = data.cdatas;
			var no = data.no;
			var pages = data.pages;

			var view = `
				  
				  <table cellpadding="7" cellspacing="0" class="boards">
					<col width="100" />
					<col width="380" />
					<col width="100" />
					<col width="120" />
						<tr class="boards_t">
							<th style="background:#d5e9ff;">제목</th>
							<th align="left" style="padding:0 0 0 10px;">${this.dc(ldata.subject)}</th>
							<th style="background:#d5e9ff;">조회수</th>
							<th align="right" style="padding:0 10px 0 0;">${this.dc(ldata.hit)}</th>
						</tr>
						<tr>
							<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">이름</th>
						  <td style="padding:0 0 0 10px;font-weight:bold;">${this.dc(ldata.name)}</td>
							<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">날짜</th>
						  <td align="right" style="padding:0 10px 0 0;font-weight:bold;">${this.dc(ldata.dates)}</td>
						</tr>
						<tr>
							<td colspan="4" style="padding:30px 7px 30px 7px;" class="b_memos">${this.dc(ldata.memo)}</td>
						</tr>
						`;
			if(ldata.file1 != "null") {
				view += `
				<tr>
					<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;border-top:1px solid #A0A0A0;">첨부파일1</th>
					<td style="padding:0 0 0 3px;border-top:1px solid #A0A0A0;" colspan="3">
						<a href="download.do?filename=${this.dc(ldata.file1)}">${this.dc(ldata.file1)}</a>
					</td>
				</tr>
				`;
			}
			if(ldata.file2 != "null") {
				view += `
				<tr>
					<th style="background:#d5e9ff;border:none;border-bottom:1px solid #A0A0A0;">첨부파일2</th>
					<td style="padding:0 0 0 3px;" colspan="3">
						<a href="download.do?filename=${this.dc(ldata.file2)}">${this.dc(ldata.file2)}</a>
					</td>
				</tr>
				`;
			}
			view += `
					</table>
					
					
					<div id="comment_list">
			`;
			var i=0;
			for(i=0;i<cdatas.length;i++) {
				var cdata = cdatas[i];
				var width_tmp = Number(this.dc(cdata.levels)) * 20;
				view += `
				
				<table cellpadding="7" cellspacing="0" class="comments">
						<tr>
							<td style="width:${width_tmp}px;border:0px;padding:0px;overflow:hidden;"></td>
							<th style="width:100px;background:#d5e9ff;border:none;border:1px solid #A0A0A0;">${this.dc(cdata.name)}
								<span style="font-weight:normal;">
									<br />${this.dc(cdata.dates)}<br />
									<a href="board_comment_del?no=${this.dc(cdata.no)}&amp;board_no=${no}&amp;pages=${pages}">[삭제]</a>
									<a href="#100" onclick="showhide('cmm${this.dc(cdata.no)}')">[답글]</a>
								</span>
							</th>
							<td valign="top">
								${this.dc(cdata.memo)}
								
								<form action="#100" id="cmm${this.dc(cdata.no)}" style="display:none;">
								<input type="hidden" name="rt_no" value="${this.dc(cdata.no)}" />
								<input type="hidden" name="board_no" value="${no}" />
								<input type="hidden" name="pages" value="${pages}" />
								<table cellpadding="7" cellspacing="0" class="comments">
								<col width="20%" />
								<col width="30%" />
								<col width="20%" />
								<col width="20%" />
									<tr>
										<th style="background:#d5e9ff;border-left:1px solid #bbbbbb;">이름</th>
										<td style="border-top:1px solid #122942;"><input type="text" name="name" /></td>
										<th style="background:#d5e9ff;">비밀번호</th>
										<td style="border-top:1px solid #122942;" colspan="2"><input type="password" name="password" /></td>
									</tr>
									<tr>
										<td style="border-left:none;border-right:none;" colspan="4"><textarea name="memo" rows="100" cols="100" editable="0" style="border:1px solid #b8c0cc;width:98%;height:40px;"></textarea></td>
										<td style="text-align:center;width:80px;border-left:none;border-right:none;"><input type="button" value="등록" onclick="comment_btn('cmm${cdata.no}')" style="background:#d5e9ff;border:1px solid #122942;width:98%;height:45px;font-size:12px;font-weight:bold;" /></td>
									</tr>
								</table>
								</form>
								
								
							</td>
						</tr>
					</table>
				
				
				`;
			}
			
			view += `
					</div>
					
					
					
					<form name="cm_b" action="#100" id="comment_write">
					<input type="hidden" name="rt_no" value="-1" />
					<input type="hidden" name="board_no" value="${no}" />
					<input type="hidden" name="pages" value="${pages}" />
					<table cellpadding="7" cellspacing="0" class="comments">
					<col width="20%" />
					<col width="30%" />
					<col width="20%" />
					<col width="20%" />
						<tr>
							<th style="background:#d5e9ff;border-left:1px solid #bbbbbb;">이름</th>
							<td style=""><input type="text" name="name" /></td>
							<th style="background:#d5e9ff;">비밀번호</th>
							<td style="" colspan="2"><input type="password" name="password" /></td>
						</tr>
						<tr>
							<td style="border-left:none;border-right:none;" colspan="4"><textarea name="memo" rows="100" cols="100" editable="0" style="border:1px solid #b8c0cc;width:98%;height:40px;"></textarea></td>
							<td style="text-align:center;width:80px;border-left:none;border-right:none;"><input type="button" value="등록" onclick="comment_btn('comment_write')" style="background:#d5e9ff;border:1px solid #122942;width:98%;height:45px;font-size:12px;font-weight:bold;" /></td>
						</tr>
					</table>
					</form>
					
					<div class="boards_b">
						<div class="boards_bl">
							<a href="board?pages=${pages}" class="btn_st"  style="margin:0 0 0 10px;">목록보기</a>
						</div>
						<div class="boards_br" style="width:70%;">
							<a href="board_edit?pages=${pages}&no=${no}" class="btn_st"  style="float:right;margin:0 10px 0 0;">수정하기</a>
							<a href="board_del?pages=${pages}&no=${no}" class="btn_st"  style="float:right;margin:0 10px 0 0;">삭제하기</a>
						</div>
					</div>
				  
				  
				  
				  
				  
				  
				  `;
			
			var template = tpl.getTemplate(title, view);
			
			return template;
		}
}
module.exports = M;