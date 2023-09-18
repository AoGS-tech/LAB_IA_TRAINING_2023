<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<a href="{{ route('product.create') }}">create</a>

<table>
    <form action="{{ route('product.index') }}">
        <input type="text" name="search"/>
        <input type='submit' value='Search'/>
    </form>

    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Unit</th>
            <th>Category</th>
            <th rowspan="2">Action</th>
        </tr>
    </thead>
    <tbody>
        @foreach ($products as $product)
            <tr>
                <td><a href="{{ route('product.details', ['product'=>$product]) }}">{{ $product->id }}</a></td>
                <td>{{ $product->name }}</td>
                <td>{{ $product->unit }}</td>
                <td>{{ $product->category->name }}</td>
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
{{ $products->links() }}
</body>
</html>