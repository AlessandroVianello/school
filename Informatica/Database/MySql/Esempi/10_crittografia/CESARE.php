<?php
	function cesare($str,$b) {
		$c=$str;
		for ($i=0; $i<strlen($str); $i++) {
			$k=ord($str[$i]);
			if ($k>96) {		// maiuscole e minuscole vengono mappate
				$delta=97;		// secondo lo stesso schema
			} else {
				$delta=65;
			}

			if ($k==32) {		// lo spazio resta uguale
				$new_k=32;
			} else {
				$new_k=(($k-$delta)+$b) % 26 + $delta;
	                        //echo "<br> k=". $k ."; new_k=" . $new_k;

			}
			$c[$i]=chr($new_k);
		}
		return $c;
	}
?>

<HTML>
<HEAD>
<TITLE> Crittografia di Cesare</TITLE>
	<link type="text/css" rel="stylesheet" href="stile.css">
</HEAD>
<BODY BGCOLOR="#FFFFFF" TEXT="#000000" LINK="#0000FF" VLINK="#800080">
	<h1>Esempio di crittografia di Cesare</h1>

	<p><tt>Stringa di partenza: </tt>= <?php   echo $_GET['frase'];  ?>

	<p>Shiftando tutto di <?php echo $_GET['scorrimento']  ?>
         ( applicando la mappa <tt>b = (a + <?php echo $_GET['scorrimento']  ?>) mod 26</tt>):

	<h3>Stringa modificata: <?php echo cesare($_GET['frase'],$_GET['scorrimento']); ?></h3>
</BODY>
</HTML>
