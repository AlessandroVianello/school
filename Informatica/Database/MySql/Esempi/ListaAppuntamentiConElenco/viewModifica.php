<?php
require ("classes/UnAppuntamento.php");
require ( "classes/ListaAppuntamenti.php");
session_start();
$appuntamento = $_SESSION['appuntamento'];
?>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifica Appuntamento</title>
    </head>
    <body>
        <h1>Modifica Appuntamento</h1>

        <form action="doAzioneModifica.php" method="post">
            <tr>
                <td><input type="text" name ="descrizione"  id="descrizione" 
                           value=" <?php echo($appuntamento->getDescrizione());?> "/> </td>
                <td><input type="text" name ="data"  id="data" 
                           value=" <?php echo($appuntamento->getData());?> "/> </td>
              </tr>
              <tr>
                <td><input type="submit" name ="submit"  id="submit"  value ="Modifica"/> </td>
                <td><input type="submit" name ="submitAnnulla"  id="submitAnnulla"  
                           value ="Annulla" onclick="this.form.action='doAnnullaModifica.php'" /> </td> 
              </tr>  
        </form>
        <?php
        if (! $appuntamento->datiOk()) {
           echo ("<h2>ERRORI: ".$appuntamento->getStrErrori(). "</h2>");
        }
   
        ?>
    </body>
</html>
