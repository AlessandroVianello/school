<html>
   <head>
     <title> Genere Musicale</title>
	  <SCRIPT LANGUAGE="JavaScript">
	    function Imposta_parametro()
		 {
	        document.form1.parametro_nascosto.value=
	                      document.form1.stato.value;
			return true;
		 }
	  </SCRIPT>
   </head>

   <body>
        <?php
	  $conn =mysql_connect("ServerMysql:3306", "u01", "u01");
          if( ! $conn ) exit ("errore durante la connesione al mysql");

	  mysql_select_db("world") or exit("l'errore adesso e'nella connessione al mio database");



          $query = "SELECT DISTINCT Code, Name FROM world.country ORDER BY name";

	  $nazioni = mysql_query ($query);

	  if (! $nazioni) exit("errore nella query:  $query ");

	  if (mysql_num_rows($nazioni)==0) exit("query vuota");

       ?>

        <center>
        <h1>Elenco delle nazioni </h1>
        <br>



<form name="form1" id="form1" action="TrovaNazione.php" method="GET">
    <input name="parametro_nascosto" type="hidden"  value="USA" >
    		Seleziona una Nazione:
  	
   <select name="stato" id="stato"  onchange="Imposta_parametro(this);">
  					<?php
	  $d=0;
   	  while($riga = mysql_fetch_array($nazioni))
   	  {
   			$Nome =   $riga["Name"];
			   $Codice = $riga["Code"];

   			echo "<option value=\"".$Codice."\">".$Nome."</option>\n";

			$d++;
   	  }

   	?>




	</select>

	<br>

		   	su <b><?php echo $d;?></b> nel database.

	<br>	<br>


      </center>
	<div>

				  	<blockquote>  	<blockquote>  <blockquote>  <blockquote>
  				<input type="submit" value="Ricerca per nazione!"  >

    	         </blockquote>
    </div>
</form>


</body>

</html>
