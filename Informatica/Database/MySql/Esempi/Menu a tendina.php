
<html>
<head>
<title>Menu dinmico in PHP</title>
<style type="text/css">
a:link {text-decoration:none;color:black}
a:visited {text-decoration:none;color:black}
a:hover {text-decoration:none;color:red}
</style>
</head>
<body>
<table border="1" width="150" cellpadding="3" cellspacing="0" bordercolor="black">
<?
$php=array("Free PHP"=>"http://freephp.html.it","Zio Budda"=>"http://www.ziobudda.net");
$javascript=array("JsDir"=>"http://www.jsdir.it","HTML Point"=>"http://www.html.it");
$java=array("Mokabyte"=>"http://www.mokabyte.it","Programmazione.it"=>"http://www.programmazione.it");
?>
<tr><td bgcolor="silver"><font face="arial" size="3"><b><a href="menu.php?idmenu=php">PHP</a></b></font></td></tr>
<?
if($idmenu=="all" or $idmenu=="php")
{
foreach($php as $key=>$val)
{
echo "<tr><td bgcolor=\"aqua\"><font face=\"arial\" size=\"2\"><a target=\"_blank\"  href=\"$val\">$key</a></font></td></tr>";
}
}
?>
<tr><td bgcolor="silver"><font face="arial" size="3"><b><a href="menu.php?idmenu=javascript">Javascript</a></b></font></td></tr>
<?
if($idmenu=="all" or $idmenu=="javascript")
{
foreach($javascript as $key=>$val)
{
echo "<tr><td bgcolor=\"aqua\"><font face=\"arial\" size=\"2\"><a target=\"_blank\"  href=\"$val\">$key</a></font></td></tr>";
}
}
?>
<tr><td bgcolor="silver"><font face="arial" size="3"><b><a href="menu.php?idmenu=java">Java</a></b></font></td></tr>
<?
if($idmenu=="all" or $idmenu=="java")
{
foreach($java as $key=>$val)
{
echo "<tr><td bgcolor=\"aqua\"><font face=\"arial\" size=\"2\"><a target=\"_blank\"  href=\"$val\">$key</a></font></td></tr>";
}
}
?>
<tr><td bgcolor="silver"><font face="arial" size="1"><a href="menu.php?idmenu=all">Mostra tutti</a></font></td></tr>
<tr><td bgcolor="silver"><font face="arial" size="1"><a href="menu.php">Nascondi tutti</a></font></td></tr>
</table>
</body>
</html>