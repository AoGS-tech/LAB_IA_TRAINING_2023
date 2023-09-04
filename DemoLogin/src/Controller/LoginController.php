<?php
require '../DAO/UserDAO.php';
require '../assets/constant.php';

if(strtoupper($_SERVER["REQUEST_METHOD"]) == "POST"){
    $isValidEmail = isset($_POST['email']) && filter_has_var(INPUT_POST, 'email');
    $isValidPassword = isset($_POST['password']) && filter_has_var(INPUT_POST, 'password');

    $userDAO = new UserDao();
    if($isValidEmail && $isValidPassword){
        $user = $userDAO->login($_POST['email'], $_POST['password']);

        if($user){
            $_SESSION['user'] = $user;
            header("Location: ".URL."/View/home.php");
        }
        else {
            header("Location: ".URL."/View/index.php");
        }
    }

}