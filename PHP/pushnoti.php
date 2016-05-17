
<?php
	$objConnect = mysql_connect("ap-cdbr-azure-east-c.cloudapp.net","bf229ec23c741e","4050ee25");
	mysql_query("SET NAMES 'utf8'");
	$objDB = mysql_select_db("drugnotification");

    
	$drugn = $_POST["drugn"]; // pk
	$drugt = $_POST["drugt"];
	$druga = $_POST["druga"];
	$sd = $_POST["sd"];
	$ed = $_POST["ed"];
	$tw = $_POST["tw"];  
    $ms = $_POST["ms"];
    $pic = $_POST["pic"];
    $sou = $_POST["sou"];


	$pushnoti = "SELECT time_warn FROM time_drug WHERE time_warn = '".$tw."'";

		$pushn = mysql_query($pushnoti);
	       $push = mysql_fetch_array($pushn);
	       $push = $push["time_warn"]; 
	        echo "time_warn".$push["time_warn"]; 

	        $arr['tw'] = $objResult["time_warn"]; 

	$startd = "SELECT start_date FROM time_drug WHERE start_date = '".$sd."'";

		$startdate = mysql_query($startd);
	       $startda = mysql_fetch_array($startdate);
	       $startda = $startda["start_date"]; 
	        echo "start_date".$startda["start_date"]; 



	$enddate = "SELECT end_date FROM time_drug WHERE end_date = '".$ed."'";

		$endda = mysql_query($enddate);
	       $enddatee = mysql_fetch_array($endda);
	       $enddatee = $enddatee["end_date"]; 
	        echo "start_date".$enddatee["end_date"]; 

	
    $arr['result'] = "gg"; 

	
	mysql_close($objConnect);
	
	echo json_encode($arr);

?>