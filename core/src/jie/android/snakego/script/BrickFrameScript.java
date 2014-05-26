package jie.android.snakego.script;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import jie.android.snakego.screen.snake.BrickFrame;

public class BrickFrameScript extends BaseScript {

	private final BrickFrame frame;
	
	public BrickFrameScript(final BrickFrame frame) {
		this.frame = frame;
	}
	
	@Override
	protected boolean load(final InputStream is) {
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(is);
			
			NodeList sf = doc.getElementsByTagName("Snake-Frame");
			if (sf == null) {
				return false;
			}
			
			Node f = sf.item(0);
			NamedNodeMap attr = f.getAttributes();
			boolean def = (attr.getNamedItem("hasDefault").getNodeValue().compareTo("true") == 0);
			if (def) {
				frame.loadDefault();
			}
			
			if (f.hasChildNodes()) {
				loadFrameData((NodeList) f);
			}
			
			return true;
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	private void loadFrameData(final NodeList f) {
		for (int i = 0; i < f.getLength(); ++ i) {
			Node item = f.item(i);
			if (item.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			NamedNodeMap attr = item.getAttributes();
			frame.addBrick(Integer.valueOf(attr.getNamedItem("x").getNodeValue()).intValue(),
					Integer.valueOf(attr.getNamedItem("y").getNodeValue()).intValue(),
					Integer.valueOf(attr.getNamedItem("type").getNodeValue()).intValue(),
					Integer.valueOf(attr.getNamedItem("code").getNodeValue()).intValue());
		}		
	}

}
