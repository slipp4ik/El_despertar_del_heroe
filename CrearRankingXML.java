
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
    public static void crearArchivo()
    {
        try
        {
            File archivo = new File("Ranking.xml");
            if(archivo.exists())
            {
                return;
            }

            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.newDocument();
            
            Element raiz = documento.createElement("ranking");
            documento.appendChild(raiz);

            TransformerFactory transformerFabrica = TransformerFactory.newInstance();
            Transformer transformer = transformerFabrica.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource origen = new DOMSource(documento);
            StreamResult destino = new StreamResult(archivo);

            transformer.transform(origen, destino);

            System.out.println("Ranking.xml generado correctamente");
        }
        catch(Exception e)
        {
            System.out.println("Error generando el XML: " + e.getMessage());
        }
    }
}
