
<?php
	$objConnect = mysql_connect("ap-cdbr-azure-east-c.cloudapp.net","bf229ec23c741e","4050ee25");
	mysql_query("SET NAMES 'utf8'");
	$objDB = mysql_select_db("drugnotification");

	//$_POST["strUser"] = "aspirin"; // for Sample
	//$_POST["strUser"] = "weerachai@1";  // for Sample

	///$strSQL = "SELECT max(Drug_box_ID)  FROM drug_box ";

	//$objQuery = mysql_query($strSQL);
	//$objResult = mysql_fetch_array($objQuery);

	//echo $objResult["max(Drug_box_ID)"];


	$strUsername = $_POST["strUser"];
	
	$strSQL = "INSERT INTO  `drugnotification`.`drug_box` (
							
							`drug_box_name`
							)
							VALUES (
							  '$strUsername'
							);
		";

	$objQuery = mysql_query($strSQL);
	$arr['result'] = "gg"; 



	
	mysql_close($objConnect);
	
	echo json_encode($arr);
?>