<html>
<head>
	<title>PHP</title>
</head>
<body>
	<h1>Ricerca dati...</h1>

<?php

	$conn=mysql_connect("serverMYSQL","u10","u10");
	if (!$conn) die('impossibile connettersi ');

	mysql_select_db("world",$conn) or die('impossibile aprire il database ');

?>

<table border="1">
<tr><th>Nome Citta</th><th>Nome Nazione</th></tr>

<?php

   $interr="SELECT * FROM city";

   $rs = mysql_query($interr,$conn);
   while($riga=mysql_fetch_array($rs))
             { print("<tr>");
  	           print("<td>".$riga["Name"]."</td>");
	           print("<td>".$riga["CountryCode"]."</td>");
               print("</tr>");
	         }

    mysql_close($conn);

?>
</table>
</body>
</html>



