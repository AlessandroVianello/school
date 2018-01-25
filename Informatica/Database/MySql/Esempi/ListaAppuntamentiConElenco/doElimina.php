<?php
require ("classes/UnAppuntamento.php");
require ( "classes/ListaAppuntamenti.php");
session_start();
$posVoce = $_GET['posVoce'];
$lapp = $_SESSION['lista'];
$lapp->elimina($posVoce);
$_SESSION['lista'] = $lapp;
header("Location:viewLista.php");
exit();
?>
