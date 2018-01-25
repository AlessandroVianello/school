<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
    <title>Somma di due numeri in PHP</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"

</head>
    <body>
      <form name="form" method="post" action="Somma.php">
       <pre>
         Primo Addendo <input type="text" name="Add1"  maxlength="5"
         <?php if (isset($_POST['Add1'])) echo "value=".$_POST['Add1'];  ?>  >
         <br>
         Secondo Addendo <input type="text" name="Add2"  maxlength="5"
		   <?php if (isset($_POST['Add2'])) echo "value=".$_POST['Add2'];  ?>  >
         <br>
         <input type="submit" value="Somma">

        <?php
          if (isset($_POST['Add1']) and isset($_POST['Add2']) )
           {
              $num1 = $_POST['Add1'];
              $num2 = $_POST['Add2'];
              echo "<br> Somma = ".($num1 + $num2);
           }
         ?>
		 </pre>
      </form>
    </body>
</html>






