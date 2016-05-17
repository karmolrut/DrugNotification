<?php
	
$host = "ap-cdbr-azure-east-c.cloudapp.net";
$user = "bf229ec23c741e";
$pass = "4050ee25";
$db = "drugnotification";

mysql_connect($host,$user,$pass);
mysql_query("SET NAMES UTF8");
mysql_query("USE $db");

	//$_POST["strUser"] = "aspirin"; // for Sample
	//$_POST["strUser"] = "weerachai@1";  // for Sample

	$strUsername = $_POST["strUser"];
	
	$strSQL = "SELECT * FROM search WHERE 1 
		AND drug_name = '".$strUsername."'  
		 
		";

	$objQuery = mysql_query($strSQL);
	$objResult = mysql_fetch_array($objQuery);
	$intNumRows = mysql_num_rows($objQuery);
	if($intNumRows==0)
	{
		$arr['StatusID'] = "0"; 
		$arr['name'] = "ไม่พบข้อมูล"; 
		$arr['com'] = ""; 
		$arr['types'] = ""; 
		$arr['prop'] = ""; 
		$arr['inst'] = "";
		$arr['side'] = ""; 
        $arr['sto'] = "";
		$arr['Error'] = "Incorrect Username and Password";	
	}
	else
	{
		$arr['StatusID'] = "1"; 
		$arr['name'] = $objResult["drug_name"]; 
		$arr['com'] = $objResult["drug_commonname"]; 
		$arr['types'] = $objResult["drug_type"]; 
		$arr['prop'] = $objResult["drug_properties"]; 
		$arr['inst'] = $objResult["drug_instruction"]; 
		$arr['side'] = $objResult["drug_side_effect"]; 
		$arr['sto'] = $objResult["drug_storage"];
		$arr['pic'] = $objResult["pic"];

		$arr['Error'] = "";	
	}



	
	mysql_close($objConnect);
	
	echo json_encode($arr);
?>
