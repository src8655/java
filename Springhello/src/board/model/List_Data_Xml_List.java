package board.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="board-list")
public class List_Data_Xml_List {
	private List<List_Data_Xml> list;

	public List<List_Data_Xml> getList() {
		return list;
	}

	public void setList(List<List_Data_Xml> list) {
		this.list = list;
	}
	
}
