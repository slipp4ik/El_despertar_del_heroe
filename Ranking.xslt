<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <html>
      <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>Ranking</title>

        <style type="text/css"><![CDATA[
          @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap');

          * {
            box-sizing: border-box;
          }

          body {
            margin: 0;
            min-height: 100vh;
            padding: 65px 20px;
            background: linear-gradient(135deg, #0d1531 0%, #242057 55%, #152b59 100%);
            color: #eef2ff;
            font-family: 'Poppins', sans-serif;
          }

          .leaderboard {
            max-width: 650px;
            margin: 0 auto;
            padding: 30px;
            border: 1px solid #514b9b;
            border-radius: 20px;
            background: rgba(25, 30, 75, .93);
            box-shadow: 0 20px 55px rgba(4, 8, 35, .35);
          }

          h2 {
            margin: 0 0 22px;
            text-align: center;
            font-size: 1.65rem;
            color: #dcd7ff;
          }

          .leaderboard-table {
            width: 100%;
            border-collapse: collapse;
            table-layout: fixed;
          }

          .leaderboard-table th {
            padding: 12px 14px;
            text-align: left;
            text-transform: uppercase;
            letter-spacing: .06em;
            font-size: .78rem;
            color: #aebffb;
            border-bottom: 1px solid #56558f;
          }

          .leaderboard-table td {
            padding: 16px 14px;
            font-size: .95rem;
            border-bottom: 1px solid #3c447c;
          }

          .leaderboard-table tbody tr:last-child td {
            border-bottom: none;
          }

          .leaderboard-table .rank {
            width: 100px;
            text-align: center;
            font-weight: 700;
            color: #b8b5ff;
          }

          .leaderboard-table .username {
            font-weight: 600;
            color: #f0f2ff;
          }

          .leaderboard-table .score,
          .leaderboard-table .th-score {
            width: 125px;
            text-align: center;
          }

          .leaderboard-table .score {
            font-weight: 700;
            color: #8fcbff;
          }

          .leaderboard-table tbody tr {
            transition: background-color .2s ease;
          }

          .leaderboard-table tbody tr:hover {
            background: #343d81;
          }

          .leaderboard-table .rank-1 {
            background: rgba(115, 89, 218, .24);
          }

          .leaderboard-table .rank-2 {
            background: rgba(77, 112, 217, .18);
          }

          .leaderboard-table .rank-3 {
            background: rgba(67, 125, 189, .12);
          }

          @media (max-width: 480px) {
            .leaderboard {
              padding: 18px 10px;
            }

            .leaderboard-table th,
            .leaderboard-table td {
              padding: 12px 6px;
            }

            .leaderboard-table .rank {
              width: 78px;
            }

            .leaderboard-table .score,
            .leaderboard-table .th-score {
              width: 90px;
            }
          }
        ]]></style>
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
