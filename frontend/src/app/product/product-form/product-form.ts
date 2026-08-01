import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../product';
import { ProductRequest } from '../product.model';

@Component({
  selector: 'app-product-form',
  imports: [FormsModule],          // ← enables [(ngModel)]
  templateUrl: './product-form.html',
  styleUrl: './product-form.css',
})
export class ProductForm {
  private productService = inject(ProductService);
  product: ProductRequest = {
    name: '',
    description: '',
    price: 0,
    stockQuantity: 0,
    category: ''
  };

  onSubmit(): void {
    this.productService.createProduct(this.product).subscribe({
      next: (created) => {
        console.log('created:', created);
        // reset the form
        this.product = { name: '', description: '', price: 0, stockQuantity: 0, category: '' };
      },
      error: (err) => console.error('create failed:', err)
    });
  }
}