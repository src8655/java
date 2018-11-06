	function alditor_PlayNow(obj, w, h, url)
	{
		try
		{
			if (url)
			{	var el = obj;
				var sURL = url;
				var sID = url;
			} else {
				var el = obj.previousSibling;
				while (el.tagName!="A")
				el = el.previousSibling;
				var sURL = el.href;
				var sID = el.href;
			}
			var sExt = sID.substring(sID.lastIndexOf("."));
			var sComp = sExt.toUpperCase();

			if (document.getElementById(sID)==null)
			{
				var embedHolder = document.createElement("div");
				var embed = document.createElement("EMBED");
				if (w) { embed.width = w;	}
				if (h) 	{ embed.height = h;	}
				if (sComp==".SWF")
				{
					embed.quality = "high";
					embed.wmode = "transparent";
				} else {
					embed.autostart = true;
				}
				embed.className = 'nopatch';
				embed.id = sID;
				embed.src = sURL;
				embedHolder.appendChild(embed);
				el.parentNode.insertBefore(embedHolder,el);
			} else {
				document.getElementById(sID).parentNode.parentNode.removeChild(document.getElementById(sID).parentNode);
			}
		}
		catch(e){}
	}

	function alditor_ShowHide(obj)
	{
		try
		{
			var targetDiv = document.getElementById(obj.id + 'sh');
			if (targetDiv.className == 'showhideDiv') {
				obj.title = obj.innerHTML;
			}
			obj.innerHTML = (targetDiv.className == 'showhideDiv')? '가리기' : obj.title ;
			targetDiv.className = (targetDiv.className == 'showhideDiv')? 'showhideDivShow' : 'showhideDiv' ;
		}
		catch(e) {}
	}
