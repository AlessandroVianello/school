<?php	require('db_open_inc.php'); ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<title>Untitled</title>
	<link rel="stylesheet" href="stile.css" type="text/css">
</head>

<body>
<h2>Risultato della query</h2>
<?php
// Esecuzione di un comando SQL
$query=strtolower(stripslashes($query));
echo "<p class=\"esercizio\">" . $query . "</p><p>";
$rs = mysql_query($query,$conn) or
die("<p>C'è un errore nella query:<br>".mysql_errno().": -->". mysql_error(). "<BR>");

$cond = strstr($query,'delete');
$cond .=strstr($query,'update');
$cond .=strstr($query,'insert');
$cond .=strstr($query,'drop');
$cond .=strstr($query,'alter');
// print $query . " - " . $cond;
//print "--->" . $rs . "<---";

if (strlen($cond)==0) {
	$nrows = mysql_num_rows($rs);
	// Display intestazione e prima riga
	if ($nrows > 0) {
		echo "<table align=\"center\">";
		echo "<tr>";
		$i=0;
		foreach ( ($riga = mysql_fetch_array($rs)) as $chiave => $valore) {
			// estrazione delle chiavi delle tabelle
			if (!is_int($chiave)) {
				print "<th>" . $chiave ."</th>";
			} else {
				$primo[$i++]=$valore;
			}

		}
		print "\n</tr>\n<tr>\n";
		for ($k=0; $k<$i; $k++) {
			print "<td>" . $primo[$k] ."</td>";
		}
		print "\n</tr>";
	}

	// Display dei risultati come array
	// Display righe successive alla prima
	if ($nrows > 0) {
		reset($riga);
		while ($riga = mysql_fetch_row($rs)) {
			echo "<tr>";
			for ($i=0; $i<count($riga); $i++) {
				echo "<td>" . $riga[$i] . "</td>\n";
			}
			echo "</tr>\n";
		}
		echo "</table>";
	} else {
		print "Nessun record soddisfacente la richiesta.";
	}
}
?>

<?php  require('db_close_inc.php');  ?>
</body>
</html>