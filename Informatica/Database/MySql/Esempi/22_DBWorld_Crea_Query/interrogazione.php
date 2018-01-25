<html>
<head>
	<title>PHP</title>
</head>
<body>
	<h1>Ricerca dati...</h1>

<?php

	$conn=mysql_connect("serverMYSQL","u11","u11");
	if (!$conn) die('impossibile connettersi ');

	mysql_select_db("world",$conn) or die('impossibile aprire il database ');
	if($_GET['select'] =="")
		{
	$url="index.html";
	Header("Location:$url"); //reindirizza alla pagina iniziale
	}

	else
	  {
?>

<table border="1">
<tr><th>Nome Citta</th><th>Nome Nazione</th></tr>
<?php
   $s=$_GET['select'];
   $f=$_GET['from'];
   $w=$_GET['where'];
   $interr="SELECT ".$s." FROM ".$f." WHERE ".$w."";
   echo "$interr";
   $rs = mysql_query($interr,$conn);
   while($riga=mysql_fetch_array($rs))
             { print("<tr>");
  	           print("<td>".$riga["Name"]."</td>");
	           print("<td>".$riga["CountryCode"]."</td>");
                print("</tr>");
	         }
	  }
    mysql_close($conn);

?>
</table>
</body>
</html>