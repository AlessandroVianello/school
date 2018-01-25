<?php
require ("classes/UnAppuntamento.php");
require ( "classes/ListaAppuntamenti.php");
session_start();
$posVoce = $_GET['posVoce'];
$direzione = $_GET['dir'];
$lapp = $_SESSION['lista'];
$lapp->sposta($posVoce, $direzione);
$_SESSION['lista'] = $lapp;
header("Location:viewLista.php");
exit();
?>
