<?php
require ("classes/UnAppuntamento.php");
require ( "classes/ListaAppuntamenti.php");
session_start();
$descrizione = $_POST['descrizione'];
$data = $_POST['data'];
$appuntamento = new UnAppuntamento($descrizione, $data);
if ($appuntamento->datiOk()) {
    if (isset($_SESSION['lista']))
        $lapp = $_SESSION['lista'];
    else
        $lapp = new ListaAppuntamenti();
    $lapp->aggiungi($appuntamento);
    $_SESSION['lista'] = $lapp;
    unset($_SESSION['appuntamento']);
} else {
   $_SESSION['appuntamento'] =  $appuntamento;
}
    header("Location:viewLista.php");
    exit();
?>
