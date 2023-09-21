<form method="post" action="{{ route('loginPost') }}">
    @csrf
    <div>
        <label for="name">
            User name:
            <input type="text" name="name"/>
        </label>
        @error('name')
            <p>{{ $message }}</p>
        @enderror
    </div>
    <div>
        <label for="password">
            Password:
            <input type="password" name="password"/>
        </label>
    </div>
    <div>
        <input type="checkbox" name="remember"/> Remember me
    </div>
    <button type="submit">Login</button>
</form>