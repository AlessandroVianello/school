<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
	<title>Untitled</title>
</head>

<body>
<table>
<form action="lunghezzaStringa.php" method="get">
   <tr>
       <th>Immettere la stringa</th>
       <td><input name="str" type="text"
	   			    <?php if (isset($_GET['str']))
				  	 	              echo "value=" . $_GET['str'];
					    ?> ></td>
   </tr>
   <tr>
       <td>Lunghezza</td>
       <td><input name="lung" type="text"
	   	<?php if (isset($_GET['str'])) {echo "value=" . strlen($_GET['str']);}
                 ?>  /input>
       </td>
  </tr>
  <tr>
       <td></td>
       <td><input type="submit"  value="Calcola la lunghezza"></td>
  </tr>
</form>
</table>



</body>
</html>
