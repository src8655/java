package gm;

import java.awt.Image;
import java.awt.Toolkit;

class Block {
	boolean isStop = false;
	public Image img;
	public String url;
	
	//�ʱ� �̹��� �ּ� �ޱ�
	Block(String url) {
		this.url = url;
		setImage(url);
	}
	
	//�̹��� �ҷ�����
	void setImage(String url) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage(url);
	}
	///��������
}
