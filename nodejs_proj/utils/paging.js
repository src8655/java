var M = {
	'board_starts' : 110,
	'board_ends' : 0,
	'board_paging' : 0,
	'pstarts' : 0,
	'pends' : 0,
	
	'board_total' : 0,
	'board_lengths' : 0,
	'pages' : 0,
	
	setPaging:function(board_total, board_lengths, pages) {
		this.board_total = board_total;
		this.board_lengths = board_lengths;
		this.pages = pages;
		
		this.board_starts = (pages*board_lengths)-board_lengths+1;						//시작지점
		this.board_ends = this.board_starts+board_lengths-1;									//마지막지점
		this.board_paging = Math.ceil(board_total/board_lengths);	//페이지 링크 개수
		this.pstarts = pages-5;
		this.pends = pages+5;
		if(this.pstarts <= 0) this.pstarts = 1;
		if(this.pends > this.board_paging) this.pends = this.board_paging;
		
		return;
	}
};
module.exports = M;