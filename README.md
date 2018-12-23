# oereb-xml2pdf


java -cp ../../../build/libs/pdf4oereb.jar;/Users/stefan/apps/saxonHE990/saxon9he.jar net.sf.saxon.Transform -TJ -xsl:../../main/resources/oereb_extract.xslt -s:bl/CH567107399166_geometry_images.xml


java -cp "/Users/stefan/apps/saxonHE990/saxon9he.jar:../../../build/libs/pdf4oereb.jar" net.sf.saxon.Transform -TJ -xsl:../../main/resources/oereb_extract.xslt -s:bl/CH567107399166_geometry_images.xml
java -cp "/Users/stefan/apps/saxonHE990/saxon9he.jar:/Users/stefan/apps/saxonHE990/pdf4oereb.jar" net.sf.saxon.Transform -TJ -xsl:../../main/resources/oereb_extract.xslt -s:bl/CH567107399166_geometry_images.xml -o:fubar.fo

java -cp "saxon9he.jar:pdf4oereb.jar" net.sf.saxon.Transform -TJ -xsl:oereb_extract.xslt -s:CH567107399166_geometry_images.xml -o:fubar.fo
java -cp "saxon9he.jar:pdf4oereb.jar:URLDecoder.class" net.sf.saxon.Transform -TJ -xsl:oereb_extract.xslt -s:CH567107399166_geometry_images.xml -o:fubar.fo
java -cp "saxon9he.jar:pdf4oereb.jar:URLDecoder.class" net.sf.saxon.Transform -t -TJ -xsl:oereb_extract.xslt -s:CH567107399166_geometry_images.xml -o:fubar.fo -config:config.xml
java -cp "saxon9he.jar:ch/so/agi/oereb/pdf4oereb/saxon/ext/URLDecoder.class" net.sf.saxon.Transform -t -TJ -xsl:oereb_extract.xslt -s:CH567107399166_geometry_images.xml -o:fubar.fo -config:config.xml
java -cp "saxon9he.jar:pdf4oereb.jar" net.sf.saxon.Transform -t -TJ -xsl:oereb_extract.xslt -s:CH567107399166_geometry_images.xml -o:fubar.fo -config:config.xml



## TODO:
- Haftungsausschluss ist unbekannt, ob es sich sauber verhält wenn es mehrere davon gibt (oder sehr lange).
- Images from Ref.
- Scalebar und Nordpfeil.
- Nach was genau gruppieren? Da braucht es wohl Absprache, da die Maschinen nicht alles wissen kann. 
 * Gruppieren nach den 17 ÖREB-Themen (tendenziell nach ROL/Theme/Text/Text) und irgendwie auch nach Subthema, falls vorhanden und ungleich Theme/Text/Text. Ist aber auch Heuristik.
 * siehe PDF-Weisung: Thema/Text muss ja der Codeliste entsprechen, wäre also spezifiert.
- Unit-Tests für die Extension-Functions von Saxon.
- Multilanguage

## Bugs?
- BL: 
 - interior ring == exterior ring of real estate geometry
 - not 300 dpi images
 - LengthShare nur im extensions-Element
- NW:
 - information text of restriction on landownership is wrong
 - symbols for restriction on landownership appear also in other legend
 - naming / grouping of theme ?
 - URL encoding
 - legend symbols size?