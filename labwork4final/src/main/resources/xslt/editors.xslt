<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <head>
                <title>Editors</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
                      integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous"/>
            </head>
            <body>
                <a href="/editors" style="position: absolute; top: 15px; right: 15px">Back to Thymeleaf version</a>
                <div class="container">
                    <ul class="nav justify-content-center">
                        <li class="nav-item">
                            <a class="nav-link" href="/xslt/editors">Show editors</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/xslt/games">Show games</a>
                        </li>
                    </ul>
                    <xsl:apply-templates />
                </div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="List">
        <table class="table table-striped table-dark table-hover">
            <caption style="caption-side: top">Editors</caption>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name Editor</th>
                    <th>Games</th>
                </tr>
            </thead>
            <xsl:for-each select="item">
                <tr>
                    <td>
                        <xsl:value-of select="id" />
                    </td>
                    <td>
                        <xsl:value-of select="nameEditor" />
                    </td>
                    <td>
                        <xsl:apply-templates select="games"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
    <xsl:template match="games">
        <table class="table table-striped table-dark table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name Game</th>
                    <th>Genre</th>
                    <th>Price</th>
                </tr>
            </thead>
            <xsl:for-each select="games">
                <tr>
                    <td>
                        <xsl:value-of select="id" />
                    </td>
                    <td>
                        <xsl:value-of select="nameGame" />
                    </td>
                    <td>
                        <xsl:value-of select="genre" />
                    </td>
                    <td>
                        <xsl:value-of select="price" />
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>