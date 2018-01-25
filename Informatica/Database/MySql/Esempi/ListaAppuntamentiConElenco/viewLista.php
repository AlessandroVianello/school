<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Appuntamenti</title>
    </head>
    <body>
        <h1>Lista appuntamenti</h1> 
        <?php
            require ("classes/UnAppuntamento.php");
            require ( "classes/ListaAppuntamenti.php");
            session_start();
            if (isset($_SESSION['lista'])) {
                $lapp = $_SESSION['lista'];
                $vettAppuntamenti = $lapp->getLista();
            } else
                $vettAppuntamenti = array();
            //echo("NumeroVoci: " . count($vettAppuntamenti) );     
            echo("<table>");
            for ($i = 0; $i < count($vettAppuntamenti); $i++) {
                $value = $vettAppuntamenti[$i];
                echo ("<tr><td>");
                echo($value->getDescrizione());
                echo("</td><td>" . $value->getData() . "</td><td>\n");
                echo("<a href=\"doElimina.php?posVoce=" . $i . "\">Elimina</a> \n");
                echo("<a href=\"doModifica.php?posVoce=" . $i . "\">Modifica</a> \n");
                if ($i != 0)  {
                    echo("<a href=\"doSuGiu.php?dir=su&posVoce=" . $i . "\">Su</a>\n ");                    
                }       
                if ($i < count($vettAppuntamenti)-1)  {
                    echo("<a href=\"doSuGiu.php?dir=giu&posVoce=" . $i . "\">Giu</a>\n ");                    
                }  
                echo("</td></tr>");
            }
            if (isset($_SESSION['appuntamento'])){
                $appuntamento = $_SESSION['appuntamento'];
                $data= $appuntamento->getData();
                $descrizione= $appuntamento->getDescrizione();
              
            } else {
                $data= "";
                $descrizione= "";                
            }
            ?>
            <form action="doAggiungi.php" method="post">
                <tr>
                    <td><input type="text" name ="descrizione"  id="descrizione" 
                    value="<?php echo($descrizione);?>"/> </td>
                    <td><input type="text" name ="data"  id="data" 
                      value="<?php echo($data);?>"/> </td>
                    <td><input type="submit" name ="submit"  id="submit"  value ="Aggiungi"/> </td>
                </tr>
            </form>
        </table>
        <a href="doCancellaTutto.php">Cancella tutto</a>   
        <a href="viewStampa.php" target=”_blank” title=”stampa”>Stampa</a>  
    </body>
</html>
