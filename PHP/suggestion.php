<?php
	$host = "ap-cdbr-azure-east-c.cloudapp.net";
$user = "bf229ec23c741e";
$pass = "4050ee25";
$db = "drugnotification";

mysql_connect($host,$user,$pass);
mysql_query("SET NAMES UTF8");
mysql_query("USE $db");
//$_GET['name'] = "as";
	$myresult['results'] = array();
if (isset($_GET['name'])) {
	
    $country_name = $_GET['name'];
        $query3 = "SELECT *  FROM search where drug_name like'$country_name%'";
        $result3 = mysql_query($query3)or die(mysql_error());
        while ($row3 = mysql_fetch_assoc($result3)) {
            array_push($myresult['results'], $row3);
        }
    $myarray = array();
    echo json_encode($myresult);

}



	
	mysql_close();
	
	
?>
