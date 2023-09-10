<?php

use App\Http\Controllers\HelloController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});
// 'duong link'/api/*url*
// vi du: localhost:8000/api/user (get)

Route::get('/hello1', [HelloController::class, 'getAPI'])->name('hello.get');
Route::post('/hello2', [HelloController::class, 'postAPI']);