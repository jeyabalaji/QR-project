<html>
 <head>
  <title>MONITOR TimeStamp API</title>
 </head>
 <body>
 <?php 
 date_default_timezone_set('Asia/Kolkata');
 $Id = $_POST['id']; 
 $Name = $_POST['name']; 
 echo "You have marked your entry ";
 $date = date("\o\\n dS F Y \a\\t g:i:s A");
 echo $date; 
 ?> 
 </body>
</html>