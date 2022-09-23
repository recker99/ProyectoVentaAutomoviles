package ProyectoBodega;

	public class Movimiento{
	String codProd;
	String tipoMov;
	int cantidad;
	int Total;

		public String getCodProd(){
			return codProd;
		}
		
			public void setCodProd(String codProd){
				this.codProd = codProd;
			}
			
				public String getTipoMov(){
					return tipoMov;
				}
				
					public void setTipoMov(String tipoMov){
						this.tipoMov = tipoMov;
					}
					
						public int getCantidad(){
							return cantidad;
						}
						
					public void setCantidad(int cantidad){
						this.cantidad = cantidad;
					}
					
				public int getTotal(){
					return Total;
				}
				
			public void setTotal(int Total){
				this.Total = Total;
			}
	 }
