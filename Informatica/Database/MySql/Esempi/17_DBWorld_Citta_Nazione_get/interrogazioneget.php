<html>
<head>
	<title>Elenco Citta'</title>
</head>
<body>
	<h1>Ricerca dati...</h1>

<?php

    $Cod_Nazione=$_GET['Cod_Nazione'];

    if(is_null(  $Cod_Nazione) || ( $Cod_Nazione=="") )
    {

             $url="indice.html";
	         Header("Location:$url"); //reindirizza alla pagina iniziale
	 }


	$connessione=mysql_connect("serverMYSQL","u10","u10");
	if (!$connessione) die('impossibile connettersi ');

	mysql_select_db("world",$connessione) or die('impossibile aprire il database ');


?>

<table border="1">
<tr><th>Nome Citta</th><th>Nome Nazione</th></tr>

<?php

   $interrogazione= "SELECT * FROM city WHERE countrycode='".$Cod_Nazione."'";
   $risultato = mysql_query($interrogazione, $connessione);
   while($riga=mysql_fetch_array($risultato))
             { print("<tr>");
  	           print("<td>".$riga["Name"]."</td>");
	           print("<td>".$riga["CountryCode"]."</td>");
                print("</tr>");
	         }

    mysql_close($connessione);

?>
</table>
</body>
</html>



