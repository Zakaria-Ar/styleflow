import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductList } from './product/product-list/product-list';
import { ProductForm } from './product/product-form/product-form';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ProductList, ProductForm],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
