<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>Ranking</title>
      </head>
      <body>
        <h2>Jugador Ranking</h2>
        <table>
          <tr>
            <th>Usuario</th>
            <th>Puntos</th>
          </tr>
          <xsl:for-each select="ranking/jugador">
            <tr>
              <td><xsl:value-of select="usuario"/></td>
              <td><xsl:value-of select="puntos"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>