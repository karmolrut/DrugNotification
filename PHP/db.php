<?php
error_reporting(E_ALL ^ E_DEPRECATED);
mysql_query("SET NAMES 'utf8'");
$host = 'ap-cdbr-azure-east-c.cloudapp.net';
$user = 'bf229ec23c741e';
$password = '4050ee25';
$database = 'drugnotification';
$conn = mysql_connect($host,$user,$password) or die('Server Information is not Correct');
mysql_select_db($database,$conn) or die('Database Information is not correct');
?>