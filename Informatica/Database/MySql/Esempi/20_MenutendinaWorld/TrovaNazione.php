<?php

  $idStato = $_GET["stato"];
  $genere   = $_GET["parametro_nascosto"];

  $conn = mysql_connect("servermysql:3306","u01","u01");
  if(!$conn){exit("errore durante l'accesso al server MySQL");}
  else{mysql_select_db("world") or exit("errore nell'apertura del database");}

  $query = "SELECT * FROM world.city WHERE  CountryCode = '$idStato'";
  $risultato = mysql_query($query);
  if(!$risultato) exit("l'errore e' nella query: $query");


?>



<html>
  <head>

   <title>  Elenco Citta' </title>
  </head>

  <body link="#0000FF" vlink="#0000FF" alink="#0000FF">


  <table align="center" style="font-family: Verdana; font-size: 10pt">
	       <td width="690" height="15" bgcolor="#FFCC00">
           <center>
	       <b><font size="4">Elenco Citta'</font></b>
	       </center>
	       </td>
  </table>
 <br>


	   <?php
	        if(mysql_num_rows($risultato) == 0)
	        {
	             echo "Non sono stati trovati risultati per <b>".$idgenere." </b><br>\n";
	         }
	        else
	       {
	          echo "Per <b>".$genere."</b> sono state trovate le seguenti città:<br>\n";
	       ?>

	    <h1>Citta': </h1>
		 <blockquote>
	      <?php

	       while($riga = mysql_fetch_array($risultato))
	       {
	          $titolo = $riga["Name"];
	          $durata = $riga["Population"];


	   echo " <input name=\"Domanda\" type=\"radio\" value=\"1\" >".$riga["Name"];;
		echo "<BR>";



	        }//while
	     }//else
        ?>

 </blockquote>


    </body>
</html>

