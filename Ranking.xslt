<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <html>
      <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>Ranking</title>
        <link rel="stylesheet" href="styles.css"/>
      </head>

      <body>
        <div class="leaderboard">
          <h2>Jugador Ranking</h2>

          <table class="leaderboard-table">
            <thead>
              <tr>
                <th class="rank">Posición</th>
                <th>Usuario</th>
                <th class="th-score">Puntos</th>
              </tr>
            </thead>

            <tbody>
              <xsl:for-each select="ranking/jugador">
                <xsl:sort select="puntos"
                          data-type="number"
                          order="descending"/>

                <tr>
                  <xsl:if test="position() &lt;= 3">
                    <xsl:attribute name="class">rank-<xsl:value-of select="position()"/></xsl:attribute>
                  </xsl:if>

                  <td class="rank">
                    <xsl:value-of select="position()"/>
                  </td>

                  <td>
                    <span class="username">
                      <xsl:value-of select="usuario"/>
                    </span>
                  </td>

                  <td class="score">
                    <xsl:value-of select="puntos"/>
                  </td>
                </tr>
              </xsl:for-each>
            </tbody>
          </table>
        </div>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
