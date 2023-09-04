<?php 
require '../DBContext/DBContext.php';
require '../Model/Users.php';

class UserDao {
    function getUsers(){
        $listUsers = [];
        $mysql = createConnection();
        $SQL = "SELECT Fullname, Birthday, Gender, Address FROM users";

        $result = $mysql->query($SQL);

        if($result->num_rows > 0){
            while ($row = $result->fetch_assoc()) {
                $user = new Users($row["Fullname"], $row["Birthday"], $row["Gender"], "Address");
                $listUsers[] = $user;
            }
        }
        else {
            echo "Emty data";
        }

        $mysql->close();

        return $listUsers;
    }

    function login($email, $password){
        $SQL = "SELECT * FROM users WHERE email = '".$email."' AND password = '".$password."'";
        $mysql = createConnection();
        $result = $mysql->query($SQL);
        if($result->num_rows > 0){
            while ($row = $result->fetch_assoc()) {
                $user = new Users($row["Fullname"], $row["Birthday"], $row["Gender"], "Address");
                return $user;
            }
        }

        return null;
    }
}