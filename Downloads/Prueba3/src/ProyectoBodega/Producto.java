package ProyectoBodega;

	public class Producto{
		String codProd;
		String descrip;
		int stock;
		int precio;
		
			public String getCodProd(){
				return codProd;
		    }
			
				public void setCodProd(String codProd){
					this.codProd = codProd;
				}
				
					public String getDescrip(){
						return descrip;
					}
	
						public void setDescrip(String descrip){
							this.descrip = descrip;
						}
	
							public int getStock(){
								return stock;
							}
	
						public void setStock(int stock){
							this.stock = stock;
						}
								
					public int getPrecio(){
						return precio;
					}
	
				public void setPrecio(int precio){
					this.precio = precio;
			}
	
	}




 //System.out.println("Cantidad inicial era ****"+cantIni);
