<?php
	$objConnect = mysql_connect("ap-cdbr-azure-east-c.cloudapp.net","bf229ec23c741e","4050ee25");
	mysql_query("SET NAMES 'utf8'");
	$objDB = mysql_select_db("drugnotification");
	
	// $_POST["txtKeyword"] = "a"; // for Sample

	$strKeyword = $_POST["txtKeyword"];
	$strSQL = "SELECT Drug_name ,Drug_amount, Drug_type, time_hour, time_min , message_warn,day,mount,year,time,mount2,yearr FROM drug, time_drug, notification WHERE notification.drug_id = drug.drug_id and notification.time_id = time_drug.time_id " ;

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


	/*$strKeyword = $_POST["time"];
	$strSQL2 = "SELECT time_warn FROM time_drug";

	$objQuery2 = mysql_query($strSQL2);
	$intNumField = mysql_num_fields($objQuery2);
	$resultArray = array();
	while($obResult = mysql_fetch_array($objQuery2))
	{
		$arrCol = array();
		for($i=0;$i<$intNumField;$i++)
		{
			$arrCol[mysql_field_name($objQuery2,$i)] = $obResult[$i];
		}
		array_push($resultArray,$arrCol);
	}*/
	
	//mysql_close($objConnect);
	
	//echo json_encode($resultArray);

?>
