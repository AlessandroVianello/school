<?php
require ("classes/UnAppuntamento.php");
require ( "classes/ListaAppuntamenti.php");
session_start();
$lapp = $_SESSION['lista'];
$lapp->eliminaTutti();
$_SESSION['lista'] = $lapp;
header("Location:viewLista.php");
exit();
?>
