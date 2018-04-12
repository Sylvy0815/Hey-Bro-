<?php
  $con = mysqli_connect("localhost", "hjune08", "tngkrtngkr06!", "hjune08");

  $recruitNum = $_POST["recruitNum"];
  $recruitID = $_POST["recruitID"];
  $recruitName = $_POST["recruitName"];
  $recruitPosition = $_POST["recruitPosition"];
  $recruitLocation = $_POST["recruitLocation"];
  $recruitDate = $_POST["recruitDate"];

  $statement = mysqli_prepare($con, "INSERT INTO Recruit VALUES (?, ?, ?, ?, ?, ?)");
  mysqli_stmt_bind_param($statement, "isssss", $recruitNum, $recruitID, $recruitName, $recruitPosition, $recruitLocation, $recruitDate);
  mysqli_stmt_execute($statement);

  $response = array();
  $response["success"] = true;

  echo json_encode($response);
 ?>
