<?php

namespace Database\Seeders;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        // \App\Models\User::factory(10)->create();

        // \App\Models\User::factory()->create([
        //     'name' => 'Test User',
        //     'email' => 'test@example.com',
        // ]);

        \App\Models\Category::factory(5)->create();

        \App\Models\Product::factory(5)->create();

        \App\Models\Order::factory(5)->create();

        \App\Models\ProductDetails::factory(5)->create();

        DB::table('product_order')->insert([
            'product_id' => rand(1, 5),
            'order_id' => rand(1, 5)
        ]);
    }
}