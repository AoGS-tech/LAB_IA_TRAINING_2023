<form method="post" action="{{ route('product.edit',['id'=>$product->id]) }}">
    @csrf
    <div>
        <label>Name</label>
        <input type='text' name='name' value="{{ $product->name }}"/>
</div>
<div>
    <label>Unit</label>
    <input type='number' name='unit' value="{{ $product->unit }}"/>
</div>
<input type='submit' value='Save'/>
</form>