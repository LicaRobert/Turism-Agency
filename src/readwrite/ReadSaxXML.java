package readwrite;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import turist.Turist;

public class ReadSaxXML extends DefaultHandler{
	private boolean bId;
	private boolean bNume;
	private boolean bVarsta;
	private boolean bSex;
	private boolean bPsejur;
	private boolean bSsejur;
	private boolean bStatiune;
	
	private Turist turist;
	private List<Turist> turisti;
	
	public List<Turist> getTurist(){
		return turisti;
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName.equalsIgnoreCase("Turist")) {
			turist = new Turist();
			
			if (attributes.getValue("id") != null) {
				turist.setId(Integer.parseInt(attributes.getValue("id")));
			}
		
		} else if (qName.equalsIgnoreCase("nume")) {
			bNume = true;
		} else if (qName.equalsIgnoreCase("varsta")) {
			bVarsta = true;
		} else if (qName.equalsIgnoreCase("sex")) {
			bSex = true;
		} else if (qName.equalsIgnoreCase("psejur")) {
			bPsejur = true;
		}else if (qName.equalsIgnoreCase("ssejur")) {
			bSsejur = true;
		}
		else if (qName.equalsIgnoreCase("statiune")) {
			bStatiune = true;
		} 
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		
		 if(bNume) {
			turist.setNume(new String(ch, start, length));
		} else if(bVarsta) {
			turist.setVarsta(Integer.parseInt(new String(ch, start, length)));
		} else if(bSex) {
			turist.setSex(new String(ch, start, length));
		} else if(bPsejur) {
			turist.setPsejur(new String(ch, start, length));
		}  else if(bSsejur) {
			turist.setSsejur(new String(ch, start, length));
		}
		else if (bStatiune) {
			turist.setStatiune(new String(ch, start , length));
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(qName.equalsIgnoreCase("Turist")) {
			if(turisti == null) {
				turisti  = new ArrayList<Turist>();
			}
			turisti .add(turist);
			turist = null;
		}
			else if (qName.equalsIgnoreCase("nume")) {
			bNume = false;
		} else if (qName.equalsIgnoreCase("varsta")) {
			bVarsta = false;
		} else if (qName.equalsIgnoreCase("sex")) {
			bSex = false;
		} else if (qName.equalsIgnoreCase("psejur")) {
			bPsejur = false;
		} else if (qName.equalsIgnoreCase("ssejur")) {
			bSsejur = false;
		}
		else if (qName.equalsIgnoreCase("statiune"));{
			bStatiune = false;
		}
	}
   }

