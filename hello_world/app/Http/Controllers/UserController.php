<?php

namespace App\Http\Controllers;

use App\Models\Role;
use App\Models\User;
use Illuminate\Http\Request;

class UserController extends Controller
{
    //
    public function registerForm()
    {
        $roles = Role::all();
        return view('users.register',['roles'=>$roles]);
    }

    public function tryToRegister(Request $request)
    {
        $formFields = $request->validate([
            'name' => ['required', 'min:3', 'max:8'],
            'email' => ['required', 'email'],
            'password' => ['required', 'confirmed', 'min:6', 'max:8']
        ]);

        $formFields['password'] = bcrypt($formFields['password']);

        $formFields['role_id'] = $request['role'];

        $user = User::create($formFields);

        auth()->login($user, false);

        return redirect()->route('welcome');
    }

    public function logout(Request $request) {
        auth()->logout();

        $request->session()->invalidate();
        $request->session()->regenerateToken();

        return redirect()->route('welcome');
    }

    public function loginForm() {
        return view('users.login');
    }

    public function tryToLogin(Request $request){
        $formField = $request->validate([
            'name' => 'required',
            'password' => 'required'
        ]);

        if(auth()->attempt($formField, $request['remember'])) {
            $request->session()->regenerate();
            return redirect()->route('welcome');
        }

        return back()->withErrors(['name' => 'Invalid login attempt.'])->onlyInput('name');
    }
}