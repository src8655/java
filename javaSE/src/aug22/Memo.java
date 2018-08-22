package aug22;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.*;

import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Memo extends Frame implements ActionListener {
	MenuBar mb;
	
	Menu mnufile;
	Menu mnuedit;
	Menu mnuhelp;
	
	MenuItem mnunew;
	MenuItem mnuopen;
	MenuItem mnusave;
	MenuItem mnuexit;

	MenuItem mnucopy;
	MenuItem mnucut;
	MenuItem mnupaste;
	MenuItem mnuall;
	MenuItem mnudelete;
	
	MenuItem mnuhelpinfo;
	
	TextArea ta;
	
	FileDialog openfile;
	FileDialog savefile;
	
	Dialog messagebox;
	Button yes, no;
	
	Dialog d1;
	Button bu1;
	
	Clipboard cb;
	
	String str = "";
	
	boolean bModify = false, bSaveas = true;
	
	public Memo() {
		super("메모장 - 제목없음");
		
		mb = new MenuBar();

		mnufile = new Menu("파일");
		mnuedit = new Menu("편집");
		mnuhelp = new Menu("도움말");

		mnunew = new MenuItem("새파일", new MenuShortcut('N'));
		mnuopen = new MenuItem("열기", new MenuShortcut('O'));
		mnusave = new MenuItem("저장", new MenuShortcut('S'));
		mnuexit = new MenuItem("종료");

		mnucopy = new MenuItem("복사하기", new MenuShortcut('C'));
		mnucut = new MenuItem("잘라내기", new MenuShortcut('X'));
		mnupaste = new MenuItem("붙여넣기", new MenuShortcut('V'));
		mnuall = new MenuItem("전체선택", new MenuShortcut('A'));
		mnudelete = new MenuItem("삭제");

		mnuhelpinfo = new MenuItem("메모장 정보...");

		mnufile.add(mnunew);
		mnufile.add(mnuopen);
		mnufile.add(mnusave);
		mnufile.addSeparator();
		mnufile.add(mnuexit);

		//커밋
		
		mnuedit.add(mnucut);
		mnuedit.add(mnucopy);
		mnuedit.add(mnupaste);
		mnuedit.addSeparator();
		mnuedit.add(mnuall);
		mnuedit.addSeparator();
		mnuedit.add(mnudelete);
		
		mnuhelp.add(mnuhelpinfo);
		
		
		mb.add(mnufile);
		mb.add(mnuedit);
		mb.add(mnuhelp);
		
		setMenuBar(mb);
		
		ta = new TextArea(20,40);
		add(ta);
		
		setBounds(300,200,700,500);
		setVisible(true);
		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if(bModify)
					saveFile();
				System.exit(0);
			}
			
		});

		mnunew.addActionListener(this);
		mnuopen.addActionListener(this);
		mnusave.addActionListener(this);
		mnuexit.addActionListener(this);
		mnucopy.addActionListener(this);
		mnucut.addActionListener(this);
		mnupaste.addActionListener(this);
		mnuall.addActionListener(this);
		mnudelete.addActionListener(this);
		mnuhelpinfo.addActionListener(this);
		
		
		
		ta.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				
				bModify = true;
			}
			
		});
		
		cb = getToolkit().getSystemClipboard();
	}

	public static void main(String[] args) {
		Memo memo = new Memo();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = arg0.getActionCommand();
		
		if(name.equals("새파일")) {
			if(bModify) {
				MessageBox();
				if(bSaveas) saveFile();
			}
			ta.setText("");
			ta.requestFocus();
		}
		if(name.equals("열기")) {
			openfile = new FileDialog(this,"Open",FileDialog.LOAD);
			openfile.show();

			//파일경로및 이름 받기
			String file_dir = openfile.getDirectory();
			String file_name = openfile.getFile();
			
			FileInputStream fis = null;
			InputStreamReader bis = null;
			
			try {
				fis = new FileInputStream(file_dir+file_name);
				bis = new InputStreamReader(fis, "euc-kr");
				
				ta.setText("");
				
				StringBuilder builder = new StringBuilder();
				
				int readbyte=0;
				while((readbyte = bis.read()) != -1) {
					builder.append((char)readbyte);
				}
				ta.setText(builder.toString());
				
				bis.close();
				fis.close();
			} catch (Exception e) {e.printStackTrace();}
			
			
			ta.requestFocus();
		}
		if(name.equals("저장")) {
			bSaveas = true;
			saveFile();
			ta.requestFocus();
		}
		if(name.equals("종료")) {
			if(bModify) {
				MessageBox();
				if(bSaveas) saveFile();
			}
			System.exit(0);
		}
		if(name.equals("복사하기")) {
			String data = ta.getSelectedText();
			StringSelection ss= new StringSelection(data);
			cb.setContents(ss,  ss);
		}
		if(name.equals("잘라내기")) {
			String data = ta.getSelectedText();
			StringSelection ss = new StringSelection(data);
			cb.setContents(ss, ss);
			ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());
		}
		if(name.equals("붙여넣기")) {
			try {
				Transferable content = cb.getContents(DataFlavor.stringFlavor);
				String data = (String)content.getTransferData(DataFlavor.stringFlavor);
				ta.insert(data, ta.getCaretPosition());
			} catch (UnsupportedFlavorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(name.equals("전체선택")) {
			ta.selectAll();
		}
		if(name.equals("삭제")) {
			ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());
		}
		if(name.equals("예")) {
			bSaveas = true;
			messagebox.hide();
		}
		if(name.equals("아니오")) {
			bSaveas = false;
			messagebox.hide();
		}
		if(name.equals("메모장 정보...")) {
			d1 = new Dialog(this,"메모 정보");
			d1.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					d1.setVisible(false);
				}
				
			});
			Panel pa = new Panel();
			pa.setLayout(new FlowLayout());
			bu1 = new Button("확인");
			bu1.addActionListener(this);
			pa.add(bu1);
			
			Label la1 = new Label("Copyright (c) : 2006-02-01");
			Label la2 = new Label("메모장 테스트 버전입니다...");
			
			d1.setLayout(new GridLayout(3,1));
			
			d1.add(la1);
			d1.add(la2);
			d1.add("South",pa);
			
			d1.pack();
			d1.setSize(300, 120);
			d1.show();
		}
		if(name.equals("확인")) {
			d1.hide();
		}
	}
	public void MessageBox() {
		messagebox = new Dialog(this, "저장 확인", true);
		
		Label l = new Label("저장하시겠습니까?");
		yes = new Button("예");
		no = new Button("아니오");
		Panel p = new Panel();
		
		p.add(yes);
		p.add(no);
		
		messagebox.add(l);
		messagebox.add("South", p);
		messagebox.pack();
		
		yes.addActionListener(this);
		no.addActionListener(this);
		messagebox.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				messagebox.hide();
			}
			
		});
		messagebox.show();
	}
	public void saveFile() {
		FileDialog saveFile;
		if(bSaveas) {
			saveFile = new FileDialog(this,"저장",FileDialog.SAVE);
			
			saveFile.show();
			
			//파일경로및 이름 받기
			String file_dir = saveFile.getDirectory();
			String file_name = saveFile.getFile();
			
			//파일 저장
			FileOutputStream fos = null;
			BufferedOutputStream bos = null;
			
			try {
				fos = new FileOutputStream(file_dir+file_name);
				bos = new BufferedOutputStream(fos);
				
				//dos.writeBytes(ta.getText());
				bos.write(ta.getText().getBytes());
				bos.flush();
				
				fos.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bSaveas = false;
		bModify = false;
	}
}
