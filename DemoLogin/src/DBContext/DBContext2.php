<?php
    $servername = "localhost";
    $username = "root";
    $password = "admin";
    $dbname = "database_name";

    try {
        $mysql2 = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
        $mysql2->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        // Thực hiện truy vấn
        $sql = "SELECT id, name, email FROM users";
        $stmt = $conn->prepare($sql);
        $stmt->execute();

        // Xử lý kết quả
        $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
        foreach ($result as $row) {
            echo "ID: " . $row["id"]. " - Name: " . $row["name"]. " - Email: " . $row["email"]. "<br>";
        }
    } catch(PDOException $e) {
        echo "Lỗi truy vấn: " . $e->getMessage();
    }

    
?>
