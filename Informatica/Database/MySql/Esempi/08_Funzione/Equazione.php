<?php

function equazione( $a, $b, $c) {         // soluzione di una equazione di 2°

		$delta= $b * $b  - ( 4* $a * $c);
      $risultato = array();
		if ($delta > 0) {
				$delta= sqrt($delta);
				$r1= ( $b + $delta ) / (2 * $a);
				$r2= ( $b - $delta ) / (2 * $a);
				$risultato = array(1.0, $r1, $r2);	//  soluzioni reali
			}
		else 	$risultato = array(-1.0, 0.0, 0.0);	//  soluzioni impossibili

		return $risultato;						// restituisce un array
	}
?>

<HTML>
<HEAD>
<TITLE> Equazione di secondo grado</TITLE>
	<link type="text/css" rel="stylesheet" href="stile.css">
</HEAD>
<BODY BGCOLOR="#FFFFFF" TEXT="#000000" LINK="#0000FF" VLINK="#800080">
	Esempio di soluzione di una Equazione di secondo grado
   <h1>
	<p><tt>Equazione:  <?php   echo $_GET['a']; echo "X^2+   ";
							         echo $_GET['b']; echo "X+  ";
									   echo $_GET['c'];
							 ?>
   <BR><BR>
	Risultato: <?php
						  $ris = equazione( $_GET['a'], $_GET['b'], $_GET['c']);
						  if ($ris[0]>0)
								 printf("%6.2f &nbsp  %6.2f", $ris[1], $ris[2]);
						  else echo "soluzioni impossibili";
	                ?>

</BODY>
</HTML>
