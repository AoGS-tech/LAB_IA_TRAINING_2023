<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Inertia\Inertia;

class TestController extends Controller
{
    public function test()
    {
        return Inertia::render('Test', ["name" => "naming sanse"]);
    }
}