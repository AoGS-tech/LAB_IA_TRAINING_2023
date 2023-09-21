<form method="post" action="{{ route('registerPost') }}">
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
    <label for="email">
            User email:
            <input type="text" name="email"/>
        </label>
        @error('email')
            <p>{{ $message }}</p>
        @enderror
    </div>
    <div>
    <label for="password">
            Password:
            <input type="password" name="password"/>
        </label>
        @error('password')
            <p>{{ $message }}</p>
        @enderror
    </div>
    <div>
    <label for="password_confirmation">
            Confirm password:
            <input type="password" name="password_confirmation"/>
        </label>
    </div>
    <div>
    <label for="role">
            Role:
            <select name="role">
                @foreach($roles as $role)
                    <option value="{{ $role->id }}">{{ $role->name }}</option>
                @endforeach
            </select>
        </label>
    </div>
    <button type="submit">Register</button>
</form>