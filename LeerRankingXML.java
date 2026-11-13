
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LeerRankingXML
{
    public static void RankingLector()
    {
        try
        {
            File archivo = new File("Ranking.xml");

            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            org.w3c.dom.Document documento = constructor.parse(archivo);

            NodeList lista = documento.getElementsByTagName("jugador");


            if(lista.getLength() == 0)
            {
                System.out.println("Todavia no hay jugadores registrados.");
                return;
            }

            for(int i = 0; i < lista.getLength(); i++)
            {
                Element jugador = (Element) lista.item(i);

                String id = jugador.getAttribute("id");

                String usuario = jugador
                                .getElementsByTagName("usuario")
                                .item(0)
                                .getTextContent();

                String puntos = jugador
                                .getElementsByTagName("puntos")
                                .item(0)
                                .getTextContent();

                System.out.println("ID: " + id);
                System.out.println("Usuario: " + usuario);
                System.out.println("Puntos: " + puntos);
                System.out.println("-----------------------------");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al leer el XML: " + e.getMessage());
        }
    }
}
