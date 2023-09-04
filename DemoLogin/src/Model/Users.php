<?php 
class Users {
    public $Fullname;
    public $Birthday;
    public $Gender;
    public $Address;

    public function __construct($Fullname, $Birthday, $Gender, $Address)
    {
        $this->Fullname = $Fullname;
        $this->Birthday = $Birthday;
        $this->Gender = $Gender;
        $this->Address = $Address;
    }
}