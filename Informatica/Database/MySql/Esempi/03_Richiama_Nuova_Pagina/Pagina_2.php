<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
    <title>Somma di due numeri in PHP</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <?php
		if (isset($_POST['Add1']) and isset($_POST['Add2']) )
      {
       $num1 = $_POST['Add1'];
       $num2 = $_POST['Add2'];
       echo " Somma = ".($num1 + $num2);
      }
    ?>
</head>
    <body>
        <form name="form" method="post" action="Pagina_1.php">
		
            <BR>
            <input type="submit" value="Torna Indietro">
		
        </form>
    </body>
</html>






