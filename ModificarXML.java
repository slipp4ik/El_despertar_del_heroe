
import java.io.File;

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
    public static void guardarJugador(String nombre, int puntos)
    {
        try
        {
            File archivo = new File("Ranking.xml");

            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            org.w3c.dom.Document documento = constructor.parse(archivo);

            // Buscar todos los jugadores existentes
            NodeList lista = documento.getElementsByTagName("jugador");

            int nuevoID = 1;

            // Calcular el siguiente ID disponible
            for(int i = 0; i < lista.getLength(); i++)
            {
                Element jugadorExistente = (Element) lista.item(i);

                int id = Integer.parseInt(jugadorExistente.getAttribute("id"));

                if(id >= nuevoID)
                {
                    nuevoID = id + 1;
                }
            }

            // Crear un nuevo jugador
            Element jugador = documento.createElement("jugador");
            jugador.setAttribute("id", String.valueOf(nuevoID));

            // Crear el usuario
            Element usuario = documento.createElement("usuario");
            usuario.setTextContent(nombre);
            jugador.appendChild(usuario);

            // Crear los puntos
            Element puntosXML = documento.createElement("puntos");
            puntosXML.setTextContent(String.valueOf(puntos));
            jugador.appendChild(puntosXML);

            // Añadir el jugador al ranking
            Element ranking = documento.getDocumentElement();
            ranking.appendChild(jugador);

            // Guardar los cambios en el XML
            TransformerFactory transformerFabrica = TransformerFactory.newInstance();
            Transformer transformer = transformerFabrica.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource origen = new DOMSource(documento);
            StreamResult destino = new StreamResult(archivo);

            transformer.transform(origen, destino);

            System.out.println("Jugador guardado correctamente con ID: " + nuevoID);
        }
        catch(Exception e)
        {
            System.out.println("Error al modificar el XML: " + e.getMessage());
        }
    }
}
