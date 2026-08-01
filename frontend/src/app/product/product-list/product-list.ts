import { Component, inject, OnInit } from '@angular/core';
import { ProductService } from '../product';
import { Product } from '../product.model';

@Component({
  selector: 'app-product-list',
  imports: [],
  templateUrl: './product-list.html',
  styleUrl: './product-list.css',
})
export class ProductList implements OnInit{
  private productService = inject(ProductService);
  products: Product[] = [];

  ngOnInit(): void {
    this.productService.getProducts().subscribe(data => {
      this.products = data;
    }
    )
  }
}
