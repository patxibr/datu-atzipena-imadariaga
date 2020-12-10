<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:foo="http://www.foo.org/" xmlns:bar="http://www.bar.org">
<xsl:template match="/">
<html>
  <body>
    <h2>Nire liburu kolekzioa</h2>
      <table border="1">
      <tr bgcolor="#9acd32">
        <th>Izenburua</th>
        <th>Egilea</th>
      </tr>
      <xsl:for-each select="liburutegia/liburu">
      <tr>
        <td><xsl:value-of select="izenburua"/></td>
        <td><xsl:value-of select="egilea"/></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
</html>