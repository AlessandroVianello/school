<?php
require ("classes/UnAppuntamento.php");
require ( "classes/ListaAppuntamenti.php");
session_start();
if (isset($_GET['posVoce'])) {
    $posVoce = intval($_GET['posVoce'], 10);
    $_SESSION['posVoce'] = $posVoce;
    $lapp = $_SESSION['lista'];
    $appuntamento = $lapp->getAppuntamento($posVoce);
    $_SESSION['appuntamento'] = $appuntamento;
    header("Location:viewModifica.php");
    exit();
} else {
    header("Location:viewLista.php");
    exit();
}
?>
