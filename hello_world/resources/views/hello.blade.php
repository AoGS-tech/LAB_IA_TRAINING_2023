<form action='/welcome' method='post'>
    @csrf
    Enter your name: <input type='text' name='name'/>
    <input type='submit' value='Click'/>
</form>
@if( $name != null )
    <div>{{ $name }}</div>
@endif