<?php

include('db.php');
$myresult['results'] = array();
if (isset($_GET['name'])) {
	$_GET['name'] = "as";
    $country_name = $_GET['name'];
        $query3 = "SELECT *  FROM search where drug_name like'$country_name%'";
        $result3 = mysql_query($query3)or die(mysql_error());
        while ($row3 = mysql_fetch_assoc($result3)) {
            array_push($myresult['results'], $row3);
        }
    $myarray = array();
    echo json_encode($myresult);

}
?>