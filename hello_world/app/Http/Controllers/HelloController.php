<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HelloController extends Controller
{
    function post(Request $request)
    {
        return view('hello', ['name' => $request->name]);
    }

    public function getAPI()
    {
        return response()->json(
            ["name" => "testing", "password" => 1, "isActive" => true, "object" => ["name" => "testing name"]]
            ,
            201
            ,
            ["bro" => "nice"]
        );
    }

    public function postAPI(Request $request)
    {
        $requestHandle = ["name" => $request->name . "123", "isDeactive" => !($request->isActive)];
        return response()->json($requestHandle, 200);
    }
}