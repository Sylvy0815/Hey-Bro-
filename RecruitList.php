<?php
  $con = mysqli_connect("localhost", "hjune08", "tngkrtngkr06!", "hjune08");
  $result = mysqli_query($con, "SELECT * FROM Recruit;");
  $response = array();

  while($row = mysqli_fetch_array($result)){
    array_push($response, array("recruitNum"=>$row[0], "recruitID"=>$row[1], "recruitName"=>$row[2], "recruitPosition"=>$row[3], "recruitLocation"=>$row[4], "recruitDate"=>$row[5]));
  }
  echo json_encode(array("response"=>$response));
  mysqli_close($con);
 ?>
