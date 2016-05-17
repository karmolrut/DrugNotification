
<?php
	

$host = "ap-cdbr-azure-east-c.cloudapp.net";
$user = "bf229ec23c741e";
$pass = "4050ee25";
$db = "drugnotification";


mysql_connect($host,$user,$pass);
mysql_query("SET NAMES UTF8");
mysql_query("USE $db");



	$drugn = $_POST["drugn"]; // pk
	$drugt = $_POST["drugt"];
	$druga = $_POST["druga"];
	//$drugbi = $_POST["drugbi"];
	$day = $_POST["day"];
	$mount = $_POST["mount"];
	$year = $_POST["year"];
	$th = $_POST["th"];
	$tm = $_POST["tm"];  // pk
    $ms = $_POST["ms"];
    $dmta = $_POST["dmta"];
    $mou = $_POST["mou"];
    $yearr = $_POST["yearr"];
  


 //    $myfile = fopen("newfile.txt", "w") or die("Unable to open file!");
	// $txt = "drugn:".$drugn." drugt:".$drugt." druga:".$druga." sd:".$sd." ed:".$ed." tw:".$tw." ms:".$ms." pic:".$pic." sou:".$sou;
	// fwrite($myfile, $txt);
	// fclose($myfile);



	$strSQL = "INSERT INTO `drugnotification`.`drug` (`Drug_ID`, `Drug_name`, `Drug_type`, `Drug_amount`)
	 VALUES (NULL, '$drugn', '$drugt', '$druga');
		";

	$objQuery = mysql_query($strSQL);

	$strSQL2 = "INSERT INTO  `drugnotification`.`time_drug` (
`time_ID` ,
`time_hour` ,
`time_min` ,
`day` ,
`mount`,
`year`,
`time`,
`mount2`,
`yearr`

)
VALUES (NULL ,  '$th', '$tm', '$day',  '$mount',  '$year',  '$dmta',  '$mou',  '$yearr');
		";

	$objQuery2 = mysql_query($strSQL2);





	$drugidd = "SELECT Drug_ID FROM drug WHERE Drug_name = '".$drugn."'	";

	$addid = mysql_query($drugidd);
	$addidr = mysql_fetch_array($addid);
	$addidr = $addidr["Drug_ID"];
	echo "drug_id".$addidr["Drug_ID"];



		/*$addbid = "SELECT Drug_box_ID FROM drug_box WHERE Drug_box_name = '".$drugbi."' ";

	     	$bid = mysql_query($addbid);
	       $addbidd = mysql_fetch_array($bid);
	       $addbidd = $addbidd["Drug_box_ID"];
	        echo $addbidd["Drug_box_ID"]; */


		$timed = "SELECT Time_ID FROM time_drug WHERE time_hour = '".$th."' AND time_min = '".$tm."'";

		$timedr = mysql_query($timed);
	       $time = mysql_fetch_array($timedr);
	       $time = $time["Time_ID"];
	        echo "time_id".$time["Time_ID"];


 //    $myfile = fopen("newfile.txt", "w") or die("Unable to open file!");
	// $txt = "drug_id:".$addidr." time_id:".$time;
	// fwrite($myfile, $txt);
	// fclose($myfile);





	$strSQL = "INSERT INTO  `drugnotification`.`notification` (
`drug_ID` ,
`time_ID` ,
`message_warn`
)
VALUES ($addidr, $time, '$ms')
		";

	$objQuery3 = mysql_query($strSQL);






    $arr['result'] = "gg";


	mysql_close($objConnect);

	echo json_encode($arr);

?>
