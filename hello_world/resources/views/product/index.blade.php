<a href="{{ route('product.create') }}">create</a>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Unit</th>
            <th rowspan="2">Action</th>
        </tr>
    </thead>
    <tbody>
        @foreach ($products as $product)
            <tr>
                <td>{{ $product->id }}</td>
                <td>{{ $product->name }}</td>
                <td>{{ $product->unit }}</td>
                <td><a href="{{ route('product.update', $product->id) }}">Edit</a></td>
                <td><form method="post" action='{{ route("product.delete", ["id"=>$product->id]) }}'>
                    @method('DELETE')
                    @csrf
                    <input type='submit' value='Delete'/>
                </form></td>
            </tr>
        @endforeach
    </tbody>
</table>