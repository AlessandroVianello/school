<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
	<title>  Calcola la lunghezza di una stringa </title>
</head>

<body>

<form action="lunghezzaStringa.php" method="get">
<pre>
    immettere la stringa
    <input name="str" type="text"
	     <?php if (isset($_GET['str'])) echo "value=" . $_GET['str'];  ?>  >

    Lunghezza
    <input name="lung" type="text"
	    <?php if (isset($_GET['str'])) echo "value=" . strlen($_GET['str']); ?>  >

    <input type="submit"  value="Calcola la lunghezza"></td>
</pre>
</form>


</body>
</html>
