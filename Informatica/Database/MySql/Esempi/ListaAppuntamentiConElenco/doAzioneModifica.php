<?php
require ("classes/UnAppuntamento.php");
require ( "classes/ListaAppuntamenti.php");
session_start();
$descrizione = $_POST['descrizione'];
$data = $_POST['data'];

$posVoce = $_SESSION['posVoce'];
$posVoce = intval($posVoce, 10);
$lapp = $_SESSION['lista'];
$appuntamento = new UnAppuntamento($descrizione, $data);

if ($appuntamento->datiOk()) {
    $lapp = $_SESSION['lista'];
    $lapp->setAppuntamento($appuntamento, $posVoce);
    unset($_SESSION['posVoce']);
    unset($_SESSION['appuntamento']);
    header("Location:viewLista.php");
    exit();    
} else {
    $_SESSION['appuntamento'] = $appuntamento;
    header("Location:viewModifica.php");
    exit();
}
/*
echo ("descrizione:" .$descrizione ."<br />");
echo ("data:" .$data."<br />");
echo ("pos Voce:" .$posVoce."<br />");
 * 
 */
?>
