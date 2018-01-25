<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
    <title>Somma di due numeri in PHP</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

</head>
    <body>
        <form name="form" method="post" action="Somma.php">
		  <pre>
            Primo Addendo <input type="text" name="Add1" value="0" maxlength="5">
            <br>
            Secondo Addendo <input type="text" name="Add2" value="0" maxlength="5">
            <br>

				<?php
              if (isset($_POST['Add1']) and isset($_POST['Add2']) )
             {
               $num1 = $_POST['Add1'];
               $num2 = $_POST['Add2'];
               echo " Somma = ".($num1 + $num2)."<br/>";	// concatena la somma
              }
            ?>

            Calcola il Totale: <input type="submit" value="Somma">
			</pre>
        </form>
    </body>
</html>






