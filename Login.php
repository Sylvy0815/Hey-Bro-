<?php
  $con = mysqli_connect("localhost", "hjune08", "tngkrtngkr06!", "hjune08");

  $userID = $_POST["userID"];
  $userPassword = $_POST["userPassword"];

  $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = ? AND userPassword = ?");
  mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
  mysqli_stmt_execute($statement);
  mysqli_stmt_store_result($statement);
  mysqli_stmt_bind_result($statement, $userID, $userPassword, $userName, $userAge, $userEmail, $userLocation, $userPosition);

  $response = array();
  $response["success"] = false;

  while(mysqli_stmt_fetch($statement)){
    $response["success"] = true;
    $response["userID"] = $userID;
    $response["userPassword"] = $userPassword;
    $response["userName"] = $userName;
    $response["userAge"] = $userAge;
    $response["userEmail"] = $userEmail;
    $response["userLocation"] = $userLocation;
    $response["userPosition"] = $userPosition;

  }

  echo json_encode($response);
?>
