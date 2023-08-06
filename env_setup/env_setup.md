# Environment installation

## Ubuntu 22.04

Refer to [this guide](https://ubuntu.com/tutorials/install-ubuntu-desktop) by Ubuntu Software to install.  
Link to download Ubuntu: [click here](https://ubuntu.com/download/desktop)  
![Ubuntu download homepage screenshot](images/ubuntu_download_screenshot.png)

### Update Ubuntu package

- First and foremost, before installing anything in the instructions below, you need to update your Ubuntu package to the lastest version by using two command (no images because it is very large to capture for the first time executing this command):

```shell
sudo apt update && sudo apt upgrade
```

## MySQL 8.0

- Step 1: Finding mysql-server package by using command:

```shell
apt-cache search mysql-server
```

![search for mysql-server package](images/mysql/apt_search_mysql_server.png)  
We will using package **_mysql-server-8.0_** for this course.

- Step 2: Install **_mysql-server-8.0_** package using command:

```shell
sudo apt install mysql-server-8.0
```

![terminal for install mysql-server](images/mysql/install_mysql_server.png)
_Note_: If it show in the first time _'[sudo] password for [username]:'_, just type in your Ubuntu password when install.

- Step 3: Setup MySQL root password
  - First, we run the command to access MySQL console:
  ```shell
  sudo mysql
  ```
  ![mysql console screen](images/mysql/mysql_console.png)
  - Next, we will set the MySQL root password by using this command in MySQL console:
  ```mysql
  ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'your_password';
  ```
  DO change **_your_password_** to your specific password, because you will need to remember it (or if you create another user, remember it in case you want to change password or something, idk :|)  
   In my case, I will change root password to **_Password1@_**.
  ![mysql setup root password](images/mysql/mysql_setup_root_password.png)
  If it show `QUERY OK, 0 rows affected.`, that mean you have changed your root password.
  - Exit the MySQL console and return to shell command to go to next step:
  ```mysql
  exit
  ```
  ![go to shell command from mysql console](images/mysql/mysql_console_to_shell.png)
- Step 4: Setup MySQL installation

  - After go back to shell command (notice the directory of the line your cursor currently at), type in:

  ```shell
  sudo mysql_secure_installation
  ```

  to execute MySQL Secure Installation.

  ![run command start mysql secure install](images/mysql/mysql_secure_install_1.png)

  - Type in your MySQL root password set in the above step:

  ![run command start mysql secure install](images/mysql/mysql_secure_install_2.png)
  You will see MySQL asking for validate password component if you rype in your password correctly.

  - We will use the validate component, so enter 'y' and continue:

  ![run command start mysql secure install](images/mysql/mysql_secure_install_3.png)

  - For this case, we will using level 1, which is medium. Type in '1' and continue:

  ![run command start mysql secure install](images/mysql/mysql_secure_install_4.png)

  - Because we have install our root password before, we will skip the change root password part. Type in 'n' for no and continue.

  ![run command start mysql secure install](images/mysql/mysql_secure_install_5.png)

  - We are not in production environment, so remove anonymous users is not needed. Therefore, we will not remove anonymous user in this step. Type in 'n' for no and continue.

  ![run command start mysql secure install](images/mysql/mysql_secure_install_6.png)

  - We are not using MySQL remotely right now, so we can disallow login MySQL remotely. Type in 'y' and continue.

  ![run command start mysql secure install](images/mysql/mysql_secure_install_7.png)

  - As stated before, we are in testing environment right now, so no need to remove the test database. Type in 'n' for no and continue.

  ![run command start mysql secure install](images/mysql/mysql_secure_install_8.png)

  - We will reload privileges table, as suggested by MySQL Installation. Type in 'y' and continue.

  ![run command start mysql secure install](images/mysql/mysql_secure_install_9.png)

  When it show line `All done!`, you have successfully install MySQL 8.0.

## PHP

- Step 1: Install dependency package using this command:

```shell
sudo apt install -y lsb-release gnupg2 ca-certificates apt-transport-https software-properties-common
```

![install dependency](images/php/php_install_dependency.png)

- Step 2: Add Surý PHP repository by using command:

```shell
add-apt-repository ppa:ondrej/php
```

DO press 'ENTER' when asked.
![add repository](images/php/php_add_repository.png)

- Step 3: Install PHP 8.2 using command:

```shell
sudo apt install php8.2
```

![install php](images/php/php_install.png)
Check PHP installed successfully by using command:

```shell
php -v
```

If it show like in the screen below, you install PHP successfully.
![php check installed](images/php/php_check_version.png)

- Step 4: Install PHP modules (for Laravel framework setup) by using command:

```shell
sudo apt install -y php-gd php-mbstring php-xml php-zip php-curl
```

![install php modules](images/php/php_install_modules.png)
Check modules installes by using command:

```shell
php -m
```

If there existed modules marked in yellow, you installed PHP modules above successfully. If there missing any, please run command above and try again.
![php check modules](images/php/php_check_modules.png)

- Step 5: Install Composer (for Laravel)
  Install curl by using command:

  ```shell
  sudo apt install -y curl
  ```

  ![install curl](images/php/php_install_curl.png)

  - Download installer for composer by using command:

  ```shell
  curl -sS https://getcomposer.org/installer -o composer-setup.php
  ```

  Check if file `composer-setup.php` at home is present at the `Home` folder.
  ![download composer for php](images/php/php_download_composer.png)

  - Install Composer to directory `/usr/local/bin` by using command:

  ```shell
  sudo php composer-setup.php --install-dir=/usr/local/bin --filename=composer
  ```

  Run this command to check if composer is install successfully:

  ```shell
  sudo -u www-data composer --version
  ```

  ![install composer](images/php/php_install_composer.png)

## VIsual Studio Code

- Install Visual Studio Code by using command:

```shell
sudo snap install code --classic
```

Run command `code .` after installing to confirm that Visual Studio Code is installed successfully.
![install visual studio code](images/php/php_install_vscode.png)

# Finished!

If there any question, please ask Hoang Quoc Anh or Giang Seo Ao for helping with installing environment.
