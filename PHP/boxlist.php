<?php
	$objConnect = mysql_connect("ap-cdbr-azure-east-c.cloudapp.net","bf229ec23c741e","4050ee25");
	mysql_query("SET NAMES 'utf8'");
	$objDB = mysql_select_db("drugnotification");
	
	// $_POST["txtKeyword"] = "a"; // for Sample

	$strKeyword = $_POST["txtKeyword"];
	$strSQL = "SELECT * FROM drug_box";

	$objQuery = mysql_query($strSQL);
	$intNumField = mysql_num_fields($objQuery);
	$resultArray = array();
	while($obResult = mysql_fetch_array($objQuery))
	{
		$arrCol = array();
		for($i=0;$i<$intNumField;$i++)
		{
			$arrCol[mysql_field_name($objQuery,$i)] = $obResult[$i];
		}
		array_push($resultArray,$arrCol);
	}
	
	mysql_close($objConnect);
	
	echo json_encode($resultArray);
?>
