export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  stockQuantity: number;
  category: string;
}

// the shape for creating — no id
export interface ProductRequest {
  name: string;
  description: string;
  price: number;
  stockQuantity: number;
  category: string;
}