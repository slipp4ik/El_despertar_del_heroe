import java.lang.annotation.Documented;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearRankingXML 
{
    public static void main(String[] args) 
    {
        try
        {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.newDocument();

            Element raiz = documento.createElement("ranking");
            documento.appendChild(raiz);

            Element jugador = documento.createElement("jugador");
            jugador.setAttribute("id", "1");
            raiz.appendChild(jugador);

            Element usuario = documento.createElement("usuario");
            usuario.setTextContent("Check");
            jugador.appendChild(usuario);

            Element puntos = documento.createElement("puntos");
            puntos.setTextContent("200");
            jugador.appendChild(puntos);

        
            TransformerFactory transformerFabrica = TransformerFactory.newInstance();
            Transformer transformer = transformerFabrica.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource origen = new DOMSource(documento);

            StreamResult destino = new StreamResult(new File("Ranking.xml"));

            transformer.transform(origen, destino);

            System.out.println("Ranking.xml generado correctamente");
        }
        catch(Exception e)
        {
            System.out.println("Error generando el XML: "+ e.getMessage());
        }
    }    
}
