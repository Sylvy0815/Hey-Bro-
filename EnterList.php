<?php
  $con = mysqli_connect("localhost", "hjune08", "tngkrtngkr06!", "hjune08");
  $result = mysqli_query($con, "SELECT * FROM Enter;");
  $response = array();

  while($row = mysqli_fetch_array($result)){
    array_push($response, array("enterNum"=>$row[0], "enterID"=>$row[1], "enterName"=>$row[2], "enterPosition"=>$row[3], "enterLocation"=>$row[4], "enterDate"=>$row[5]));
  }
  echo json_encode(array("response"=>$response));
  mysqli_close($con);
 ?>
