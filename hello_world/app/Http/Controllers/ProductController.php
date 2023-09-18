<?php

namespace App\Http\Controllers;

use App\Models\Product;
use App\Models\ProductDetails;
use Illuminate\Http\Request;

class ProductController extends Controller
{
    public function index(Request $request)
    {
        if ($request->query('search')) {
            return view('product.index', ['products' => Product::where('name', 'like', '%' . $request->query('search') . '%')->paginate($_ENV['PAGINATE_NUMBER'])]);
        }
        return view('product.index', ['products' => Product::latest()->paginate($_ENV['PAGINATE_NUMBER'])]);
    }

    public function details($product)
    {
        $find = Product::find($product);
        return view('product.detail', ['product' => $find]);
    }

    public function create()
    {
        return view('product.add');
    }

    public function save(Request $request)
    {
        $formFields = $request->validate(
            [
                'name' => 'required',
                'unit' => ['required', 'gt:0']
            ]
        );
        $data = [
            'name' => $formFields->name,
            'unit' => $formFields->unit
        ];
        // > -> gt (greater than)
// < -> lt (less than)
// >= -> gte (greater than or equals)
// <= -> lte (less than or equals)
        Product::insert($$data);
        return redirect()->route('product.index');
    }

    public function update($id)
    {
        $product = Product::find($id);

        return view('product.edit', ['product' => $product]);
    }

    public function confirmUpdate(Request $request, $id)
    {
        $formFields = $request->validate(
            [
                'name' => 'required',
                'unit' => ['required', 'gt:0']
            ]
        );

        $product = Product::find($id);
        $product->update($formFields);

        return redirect()->route('product.index');
    }

    public function delete($id)
    {
        $product = Product::find($id);
        if ($product == null) {
            return redirect('/welcome');
        }

        $product->delete();
        return redirect()->route('product.index');
    }
}