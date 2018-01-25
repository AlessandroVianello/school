<?php
    require ("classes/UnAppuntamento.php");
    require ( "classes/ListaAppuntamenti.php");
    session_start();

    unset($_SESSION['posVoce']);
    unset($_SESSION['appuntamento']);
    header("Location:viewLista.php");
    exit();
?>
