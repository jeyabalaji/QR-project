<?php
$servername = "mysql.serversfree.com";
$username = "u215511637_tjas";
$password = "jass123";
$dbname = "u215511637_qrcod";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
$emp_id = $_POST['id'];
$emp_name = $_POST['name'];
$entry_locn = $_POST['entrylocn'];
$date = date("dS F Y \a\\t g:i:s A");

$sql = "INSERT INTO staff_tab (emp_id,emp_name,entry_locn,entry_time)
VALUES ($emp_id,$emp_name,$entry_locn,$date)";
	
if ($conn->query($sql) === TRUE) {
    echo "Entry Marked Sucessfully on ";
    
    echo $date; 
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>