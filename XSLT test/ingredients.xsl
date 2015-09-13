<?xml version="1.0" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	

<html>
<body>

	<xsl:for-each select="ingredients/ingredient">
	
	<xsl:value-of select="name" /> :
	<xsl:value-of select="amount" /> 



	<table border="1">
		<tr bgcolor="yellow">
			<th style="text-align:left">Name</th>
			<th style="text-align:left">Energy</th>
			<th style="text-align:left">Production</th>
			<th style="text-align:left">Protein</th>
			<th style="text-align:left">Fat</th>
			<th style="text-align:left">Carbohydrates</th>
		</tr>


			<xsl:for-each select="candies/candy">
					<tr>
						<td>
							<xsl:value-of select="name" />
						</td>
						
						<td>
							<xsl:value-of select="energy" />
						</td>
								
						<td>
							<xsl:value-of select="production" />
						</td>
								
							<xsl:for-each select="value">

								<td>
									<xsl:value-of select="protein" />
								</td>
								
								<td>
									<xsl:value-of select="fat" />
								</td>
									
								<td>
									<xsl:value-of select="carbohydrates" />
								</td>
							</xsl:for-each>
					</tr>
			</xsl:for-each>

		</table>
	</xsl:for-each>
</body>
</html>

</xsl:template>

</xsl:stylesheet>