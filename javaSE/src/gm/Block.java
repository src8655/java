package gm;

import java.awt.Image;
import java.awt.Toolkit;

class Block {
	boolean isStop = false;
	public Image img;
	public String url;
	
	//초기 이미지 주소 받기
	Block(String url) {
		this.url = url;
		setImage(url);
	}
	
	//이미지 불러오기
	void setImage(String url) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage(url);
	}
	///수정수정
}
