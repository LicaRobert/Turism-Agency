package readwrite;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import turist.Turist;



public class WriteDomXML {
	public void createXMLFrom(List<Turist> turisti, String outputFile) throws ParserConfigurationException, TransformerException
	{
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		Element root = doc.createElement("Turisti");
		doc.appendChild(root);
		for (Turist turist : turisti) {
			Element elem = doc.createElement("Turisti");
		     
			elem.setAttribute("id", Integer.toString(turist.getId()));
			
			elem.setAttribute("nume", turist.getNume());
			
			elem.setAttribute("sex", turist.getSex());
			
			elem.setAttribute("varsta", Integer.toString(turist.getVarsta()));
			 
			elem.setAttribute("psejur", turist.getPsejur());
			
			elem.setAttribute("ssejur", turist.getSsejur());
			 
			elem.setAttribute("statiune", turist.getStatiune());
		     
			root.appendChild(elem);
		
	}
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer t = tFactory.newTransformer();
		Result result = new StreamResult(new File(outputFile));
		Source source = new DOMSource(doc);
		t.transform(source, result);
	}
}