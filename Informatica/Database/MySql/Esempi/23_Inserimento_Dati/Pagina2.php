<?php

$conn= mysql_connect("serverMYSQL","u100","u100");   // connessione al server
if (!$conn) die('impossibile connettersi ');

mysql_select_db("DB100",$conn)                // selezione DataBase
                 or die('impossibile aprire il database ');  


$nome = $_GET['nome'];              // recupero i dati della pagina precedente
$provincia = $_GET['provincia'];



$query = "INSERT INTO casaeditrice (nome, provincia)
	       VALUES	('$nome', '$provincia')";

$result = mysql_query($query);	          // esegue il comando SQL

if($result)
	echo "<br> Inserimento avvenuto correttamente";
else
	echo "<br> Inserimento non eseguito";
  
mysql_close();

?>