<form method="post" action="{{ route('product.save') }}">
    @csrf
    <div>
        <label>Name</label>
        <input type='text' name='name'/>
</div>
<div>
    <label>Unit</label>
    <input type='number' name='unit'/>
</div>
<input type='submit' value='Save'/>
</form>