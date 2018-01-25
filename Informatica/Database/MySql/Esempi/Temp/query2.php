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
<tr><th>Nome Nazione</th><th>Aspettativa di vita</th></tr>

<?php

   $interr="select Name, LifeExpectancy from Country where Continent = 'Africa' and LifeExpectancy < 50";

   $rs = mysql_query($interr,$conn);
   while($riga=mysql_fetch_array($rs))
             { print("<tr>");
  	            print("<td>".$riga["Name"]."</td>");
  	            print("<td>".$riga["LifeExpectancy"]."</td>");
	            print("</tr>");
	         }

    mysql_close($conn);

?>
</table>
</body>
</html>



