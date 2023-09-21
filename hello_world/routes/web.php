<?php

use App\Http\Controllers\HelloController;
use App\Http\Controllers\ProductController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', function () {
    return view('welcome');
})->name('welcome');

Route::get('/welcome', function () {
    return view('hello', ['name' => null]);
});

Route::post('/welcome', [HelloController::class, 'post']);

//product dang nhap moi dung duoc

Route::get('/product', [ProductController::class, 'index'])->name('product.index')->middleware('auth');

Route::get('/product/{product}', [ProductController::class, 'details'])->name('product.details')->middleware('auth');

Route::get('/product/create', [ProductController::class, 'create'])->name('product.create')->middleware('auth');

Route::post('/product/create', [ProductController::class, 'save'])->name('product.save')->middleware('auth');

Route::get('/product/update/{id}', [ProductController::class, 'update'])->name('product.update')->middleware('auth');

Route::post('/product/save/{id}', [ProductController::class, 'confirmUpdate'])->name('product.edit')->middleware('auth');

Route::delete('/product/delete/{id}', [ProductController::class, 'delete'])->name('product.delete')->middleware(['auth','role:admin']);

Route::get('/register', [UserController::class, 'registerForm'])->name('register')->middleware('guest');

Route::post('/register', [UserController::class, 'tryToRegister'])->name('registerPost')->middleware('guest');

Route::post('/logout',[UserController::class,'logout'])->name('logout')->middleware('auth');

Route::get('/login',[UserController::class,'loginForm'])->name('login')->middleware('guest');

Route::post('/login',[UserController::class,'tryToLogin'])->name('loginPost')->middleware('guest');