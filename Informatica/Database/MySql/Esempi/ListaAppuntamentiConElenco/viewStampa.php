<?php
require ("classes/UnAppuntamento.php");
require ( "classes/ListaAppuntamenti.php");
session_start();
?>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stampa Lista Appuntamenti</title>
    </head>
    <body>
        <h1>Stampa Lista appuntamenti</h1>
        <?php
            if (isset($_SESSION['lista'])) {
                $lapp = $_SESSION['lista'];
                $vettAppuntamenti = $lapp->getLista();
            } else
                $vettAppuntamenti = array();
            //echo("NumeroVoci: " . count($vettAppuntamenti) );     

            for ($i = 0; $i < count($vettAppuntamenti); $i++) {
                $value = $vettAppuntamenti[$i];

                echo($value->getDescrizione(). "-" . $value->getData())."<br />\n" ;

                
            }
        
        
        
        ?>
    </body>
</html>