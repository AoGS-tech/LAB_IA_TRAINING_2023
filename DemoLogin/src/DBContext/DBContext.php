<?php 
    // Sử dụng mysqli 
    function createConnection(){
        $servername = "localhost";
        $username = "root";
        $password = "admin";
        $dbname = "demo";
        $mysql = new mysqli($servername, $username, $password, $dbname);
        // Kiểm tra kết nối
        if ($mysql->connect_error) {
            die("Kết nối thất bại: " . $mysql->connect_error);
        }
        return $mysql;
    }
    
?>