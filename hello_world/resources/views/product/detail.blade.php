<div>
    <div>
    </div>
    <div>
        @foreach($product->order as $order)
            <div>Order number {{ $order->order_number }}</div><br/>
        @endforeach
    </div>
</div>