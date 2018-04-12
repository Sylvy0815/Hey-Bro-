<?php
  $con = mysqli_connect("localhost", "hjune08", "tngkrtngkr06!", "hjune08");

  $userID = $_POST["userID"];
  $userPassword = $_POST["userPassword"];
  $userName = $_POST["userName"];
  $userAge = $_POST["userAge"];
  $userEmail = $_POST["userEmail"];
  $userLocation = $_POST["userLocation"];
  $userPosition = $_POST["userPosition"];

  $statement = mysqli_prepare($con, "INSERT INTO USER VALUES (?, ?, ?, ?, ?, ?, ?)");
  mysqli_stmt_bind_param($statement, "sssisss", $userID, $userPassword, $userName, $userAge, $userEmail, $userLocation, $userPosition);
  mysqli_stmt_execute($statement);

  $response = array();
  $response["success"] = true;

  echo json_encode($response);
 ?>
