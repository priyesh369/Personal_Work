
<?php
   // Connect to database, and complain if it fails
   try {
      $dbhandle = new PDO('mysql:host=dragon.kent.ac.uk; dbname=co323',
                          'co323', 'ausa#te');
   } 
   catch (PDOException $e) {
      // The PDO constructor throws an exception if it fails
      die('Error Connecting to Database: ' . $e->getMessage());
   }

   // Run the SQL query, and print error message if it fails.
   $sql = "SELECT * FROM club";
	
   $query = $dbhandle->prepare($sql);

   if ( $query->execute() === FALSE ) {
      die('Error Running Query: ' . implode($query->errorInfo(),' ')); 
   }
		
   // Put the results into a nice big associative array
   $results = $query->fetchAll();
	
   // Printing out the club names and addresses in the array results
?>

   <h2>Details of all clubs</h2>
   <table border='1'>
      <tr>
         <th>Club ID</th><th>Name</th><th>Venue</th>
      </tr>
	  
<?php		
   foreach ($results as $row) {
      echo "<tr><td>".$row['cid']."</td><td>".$row['name'].
           "</td><td>".$row['venue']."</td></tr>";
   }   
?>		

   </table>
