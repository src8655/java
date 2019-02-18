var M = {
	getData:function(data) {
		var ldata = data.rows;
		var metadata = data.metaData;
		
		ldata = ldata[0];
		
		var str = "var tmp = {";
		
		var i=0;
		for(i=0;i<ldata.length;i++) {
			if(i != 0) str += ",";
			str += "'"+metadata[i].name.toLowerCase()+"' : '"+encodeURIComponent(ldata[i])+"'";
		}
		str += "};"
		eval(str);
		
		
		return tmp;
	},

	getDatas:function(lists) {
		var list = lists.rows;
		var metadata = lists.metaData;
		
		var k=0;
		var str = "";

		str += "var tmp = [";
		for(k=0;k<list.length;k++) {
			var ldata = list[k];
			
			if(k != 0) str += ",";
			
			
			str += "{";
			var i=0;
			for(i=0;i<ldata.length;i++) {
				if(i != 0) str += ",";
				str += "'"+metadata[i].name.toLowerCase()+"' : '"+encodeURIComponent(ldata[i])+"'";
			}
			str += "}"
			
		}
		str += "];";
		
		
		eval(str);
		return tmp;
	}
};
module.exports = M;