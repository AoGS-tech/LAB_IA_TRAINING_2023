<div>
    <div>Hello</div>
    @auth
    <div>
        <div>Welcome user {{ auth()->user()->name }}</div>
        <a href="{{ route('product.index') }}">Product</a>
        <form method="post" action="{{route('logout')}}">
            @csrf
            <button type="submit">Logout</button>
        </form>
    </div>
    @else
    <a href="{{ route('register') }}">Register</a>
    <a href="{{ route('login') }}">Login</a>
    @endauth
</div>