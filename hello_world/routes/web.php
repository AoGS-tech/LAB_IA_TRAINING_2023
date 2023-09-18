<?php

use App\Http\Controllers\HelloController;
use App\Http\Controllers\ProductController;
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
});

Route::get('/welcome', function () {
    return view('hello', ['name' => null]);
});

Route::post('/welcome', [HelloController::class, 'post']);

Route::get('/product', [ProductController::class, 'index'])->name('product.index');

Route::get('/product/{product}', [ProductController::class, 'details'])->name('product.details');

Route::get('/product/create', [ProductController::class, 'create'])->name('product.create');

Route::post('/product/create', [ProductController::class, 'save'])->name('product.save');

Route::get('/product/update/{id}', [ProductController::class, 'update'])->name('product.update');

Route::post('/product/save/{id}', [ProductController::class, 'confirmUpdate'])->name('product.edit');

Route::delete('/product/delete/{id}', [ProductController::class, 'delete'])->name('product.delete');