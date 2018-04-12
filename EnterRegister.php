<?php
  $con = mysqli_connect("localhost", "hjune08", "tngkrtngkr06!", "hjune08");

  $enterNum = $_POST["enterNum"];
  $enterID = $_POST["enterID"];
  $enterName = $_POST["enterName"];
  $enterPosition = $_POST["enterPosition"];
  $enterLocation = $_POST["enterLocation"];
  $enterDate = $_POST["enterDate"];

  $statement = mysqli_prepare($con, "INSERT INTO Enter VALUES (?, ?, ?, ?, ?, ?)");
  mysqli_stmt_bind_param($statement, "isssss", $enterNum, $enterID, $enterName, $enterPosition, $enterLocation, $enterDate);
  mysqli_stmt_execute($statement);

  $response = array();
  $response["success"] = true;

  echo json_encode($response);
 ?>
