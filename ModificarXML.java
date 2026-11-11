  import java.io.File;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ModificarXML 
{
    public static void main(String[] args) 
    {
        try
        {
            File archivo = new File("Ranking.xml");
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            org.w3c.dom.Document documento = constructor.parse(archivo);

            NodeList lista = documento.getElementsByTagName("ranking");
            
            boolean encontrado = false;

           for(int i = 0; i<lista.getLength(); i++)
            {
                Element ranking = (Element) lista.item(i);
                //Aqui poner lo que quiero modificar
                
                //if(ranking.getAttribute("id").equals("1"))
                //{
               //     Element atributo = (Element) ranking.getElementsByTagName("atributo").item(0);
               //     atributo.setTextContent("");
               //     encontrado = true;
               //     break;
               // }        
            }
            
            TransformerFactory transformerFabrica = TransformerFactory.newInstance();
            Transformer transformer = transformerFabrica.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource origen = new DOMSource(documento);

            StreamResult destino = new StreamResult(archivo);

            transformer.transform(origen, destino);

            System.out.println("Fichero XML modificado correctamente");
            
        }
        catch(Exception e)
        {
            System.out.println("Error al leer el XML: "+e.getMessage());
        }    
    }    
}


