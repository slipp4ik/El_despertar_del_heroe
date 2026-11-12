
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

            // Obtener todos los jugadores
            NodeList lista = documento.getElementsByTagName("jugador");

            System.out.println("========== RANKING ==========");

            // Comprobar si hay jugadores
            if(lista.getLength() == 0)
            {
                System.out.println("Todavia no hay jugadores registrados.");
                return;
            }

            // Recorrer todos los jugadores
            for(int i = 0; i < lista.getLength(); i++)
            {
                Element jugador = (Element) lista.item(i);

                // Obtener ID
                String id = jugador.getAttribute("id");

                // Obtener usuario
                String usuario = jugador
                                .getElementsByTagName("usuario")
                                .item(0)
                                .getTextContent();

                // Obtener puntos
                String puntos = jugador
                                .getElementsByTagName("puntos")
                                .item(0)
                                .getTextContent();

                // Mostrar datos del jugador
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
