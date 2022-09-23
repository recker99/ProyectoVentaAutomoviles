package ProyectoBodega;

import java.util.Scanner;

	public class bodega{
	 static Producto[] listaProductos=new Producto[10];
	 static Producto[] listaProductosInicial;
	 static Movimiento[] listaMovimientos=new Movimiento[10];
	 static Scanner sc=new Scanner (System.in);
		
	   public static void recibeProducto(){		   
		   Scanner in=new Scanner (System.in);
		   Producto producto=new Producto();
		   System.out.print("Ingrese codigo : ");			
		   producto.setCodProd(in.next());
		   System.out.print("Ingrese Descripcion : ");			
		   producto.setDescrip(in.next());
		   System.out.print("Ingrese Precio : ");			
		   producto.setPrecio(in.nextInt());
		   System.out.print("Ingrese Stock : ");			
		   producto.setStock(in.nextInt());
		   ingresaProducto(producto);
	   }
	   
            public static void recibeMovimiento(){		 
                int Neto=0;
                int Cantidad=0;
                int preciopro=0;
                String codProd="";
			
                Scanner in=new Scanner (System.in);
                Movimiento mov=new Movimiento();
                System.out.print("Ingrese codigo : ");	
                codProd=in.next();
                mov.setCodProd(codProd);
                        
                	for(int i=0; i<listaProductos.length;i++){
                        if(listaProductos[i]==null){
                        	
                        	}else{
                                   if(listaProductos[i].getCodProd().equals(codProd)){
                                       preciopro=listaProductos[i].getPrecio();
                                   }
                            }
                     }
                		
                		System.out.print("Ingrese Tipo de Movimiento e: entrada o s: salida : ");			
                		mov.setTipoMov(in.next());
                		System.out.print("Ingrese Cantidad : ");
                        Cantidad=in.nextInt();
                        mov.setCantidad(Cantidad);
                        Neto=Cantidad * preciopro;
                        mov.setTotal(Neto);
                        //System.out.print(Neto);
                        ingresaMovimiento(mov);
                        actualizaProducto(mov.getCodProd(), mov.getCantidad(),mov.getTipoMov());
	   				}

	   						public static void ingresaProducto(Producto prod){
	   							int lugar=0; // va a guardar el primer lugar libre en el arreglo de listaProductos
		   
	   							for(int i=0; i<listaProductos.length;){ //recorre el arreglo
	   								if(listaProductos[i]==null){ //Pregunta si esta nulo
	   									System.out.println("Producto incorporado a la Bodega");   
	   									lugar=i;			   
	   									
	   									break;
	   									
	   									}else
	   										i++;
	   									}		   
	   										listaProductos[lugar]=prod;
		  
	   							}
   
	   							public static void ingresaMovimiento(Movimiento mov){
	   								int lugar=0; // va a guardar el primer lugar libre en el arreglo de listaMovimientos
		   
	   								for(int i=0; i<listaMovimientos.length;){ //recorre el arreglo
	   									if(listaMovimientos[i]==null){ //Pregunta si esta nulo
	   										System.out.println("Movimiento incorporado ");   
	   										lugar=i;			   
			   
	   										break;
	   										}else
	   											i++;
	   										}		   
	   											listaMovimientos[lugar]=mov;
		   
	   							}
	   
	   								public static void mostrarProductos(Producto[] lista){
	   
	   									for(int i=0; i<lista.length;i++){
	   										if(lista[i]==null);
	   											
	   											else{
	   												System.out.println("***********Producto "+i);
	   												System.out.println("Codigo del producto      :"+lista[i].getCodProd());
	   												System.out.println("Descripcion del producto :"+lista[i].getDescrip());
	   												System.out.println("Stock del producto       :"+lista[i].getStock());
	   												System.out.println("Producto del producto    :"+lista[i].getPrecio());
	   											}
	   									}	  
	
	   							}
	   								
	   									public static void mostrarProductosUnidades(Producto[] lista){
	   										for(int i=0; i<lista.length;i++){
	   											if(lista[i]==null);
	   												
	   												else{
	   													System.out.println("***********Cantidad Unidades por Producto : "+i+" *********");
	   													//System.out.println("Codigo del producto "+lista[i].getCodProd());
	   													System.out.println("Producto       : "+lista[i].getDescrip());
	   													System.out.println("Stock Producto : "+lista[i].getStock());
	   													//System.out.println("Producto del producto "+lista[i].getPrecio());
	   													System.out.println("*********************************************************");
	   												}
	   										}	  
	
	   								}
	   										public static void mostrarMovimientos(String tipo){
	   											
	   											int cantidadMovimientos=0;
	   											String TipoMov="";
	   											TipoMov=tipo;
	   											for(int i=0; i<listaMovimientos.length;i++){
	   												if(listaMovimientos[i]==null);
	   												
	   												else{
	   													
	   													if(listaMovimientos[i].getTipoMov().toString().equals(tipo.toString())){
	   														
	   														
	   														System.out.println("Movimiento "+i);
	   														System.out.println("Codigo del producto "+listaMovimientos[i].getCodProd());
	   														System.out.println("Cantidad "+listaMovimientos[i].getCantidad());
	   														cantidadMovimientos++;
	   													}
	   											  }
	   												
	   										}	  
	   											System.out.println("Cantidad Movimientos tipo "+TipoMov+" son "+cantidadMovimientos);	
	   									}
	   											
	   										public static void mostrarMovimientosConTipos(String tipo){
	   											String TipoMoviento="";
	   												for(int i=0; i<listaMovimientos.length;i++){
	   													if(listaMovimientos[i]==null);
		   
	   														else{
	   															
	   															if(listaMovimientos[i].getTipoMov().toString().equals(tipo.toString())){
	   																System.out.println("***********Cantidad Producto Movimiento Salida*********");
	   																System.out.println("Numero Movimiento   :"+i);
	   																
	   																if(listaMovimientos[i].getTipoMov().equals("s")){
	   																	TipoMoviento="Salida" ;
                            
	   																	}else{
	   																}    
	   																	System.out.println("Tipo Movimiento     :"+TipoMoviento);
	   																	System.out.println("Codigo del producto :"+listaMovimientos[i].getCodProd());
	   																	System.out.println("Cantidad            :"+listaMovimientos[i].getCantidad());
	   																	System.out.println("*********************************************************");
	   															}
	   														}
	   												}	  
	
	   										}
	   										
	   											public static void mostrarMovimientosTotalSalida(String tipo){
	   												String TipoMoviento="";
	   												int sum=0;
	   												int sumaSalida=0;
	   												int TotalSalidas=0;
	   												System.out.println("***********Movimiento Salida*********");
	   													
	   												for(int i=0; i<listaMovimientos.length;i++){
	   													if(listaMovimientos[i]==null);
		   
	   														else{
		    
	   															if(listaMovimientos[i].getTipoMov().toString().equals(tipo.toString())){

                            
	   																if(listaMovimientos[i].getTipoMov().equals("s")){
	   																	TipoMoviento="Salida" ;
                           
	   																	}else{
                                
	   																}    
	   																	System.out.println("Tipo Movimiento     :"+TipoMoviento);
	   																	System.out.println("Codigo del producto :"+listaMovimientos[i].getCodProd());
	   																	System.out.println("Cantidad            :"+listaMovimientos[i].getCantidad());
	   																	sum=listaMovimientos[i].getTotal();
	   																	sumaSalida= sumaSalida + sum;
                            
                           
	   																}
	   														}
	   												}	
	   																	TotalSalidas=sumaSalida;
	   																	System.out.println("*********************************************************");
	   																	System.out.println("Total Monto Salidas              :"+TotalSalidas);
	   																	System.out.println("*********************************************************");
	   											}
    
	   											public static void mostrarMovimientosTotalEntrada(String tipo){
	   												String TipoMoviento="";
	   												int sum=0;
	   												int sumaEntrada=0;
	   												int TotalEntrada=0;
	   												System.out.println("***********Movimiento Entradas*********");
	   												
	   												for(int i=0; i<listaMovimientos.length;i++){
	   													
	   													if(listaMovimientos[i]==null);
		   
	   														else{
		     
	   															if(listaMovimientos[i].getTipoMov().toString().equals(tipo.toString())){

	   																if(listaMovimientos[i].getTipoMov().equals("e")){
	   																	TipoMoviento="Salida" ;
                            
	   																	}else{
                                
	   																}    
	   																	System.out.println("Tipo Movimiento     :"+TipoMoviento);
	   																	System.out.println("Codigo del producto :"+listaMovimientos[i].getCodProd());
	   																	System.out.println("Cantidad            :"+listaMovimientos[i].getCantidad());
	   																	sum=listaMovimientos[i].getTotal();
	   																	sumaEntrada= sumaEntrada + sum;
                            
	   															    }
	   														   }
	   													}	
	   																	TotalEntrada=sumaEntrada;
	   																	System.out.println("*********************************************************");
	   																	System.out.println("Total Monto Entradas              :"+TotalEntrada);
	   																	System.out.println("*********************************************************");
	   											}
	   											
	   										public static void actualizaProducto(String codProd, int cantidad, String tipoMov){
	   											
	   											for(int i=0; i<listaProductos.length;i++){
		  
	   												if(listaProductos[i]==null);
	   													
	   													else{
	   														int cantIni=listaProductos[i].getStock();
	   														System.out.println("Cantidad inicial era ****"+cantIni);
			   
	   															if(listaProductos[i].getCodProd().equals(codProd.toString())){
				   
	   																if(tipoMov.equals("e")){
	   																	System.out.println("Es entrada"); 
	   																	listaProductos[i].setStock(cantidad+cantIni);
	   																}
				   
	   																	else{
	   																		System.out.println("es salida ");
	   																		listaProductos[i].setStock(cantidad-cantIni);
	   																	}
	   															}	
	   													}
	   											 }	  
	
	   										}
   
	   										public static void menu(){
	   											sc.reset();
	   											String Opcion="";
	   											System.out.println("Opciones de Menu");
	   											System.out.println("***************************************************");
	   											System.out.println("1)  Ingresar Producto.");
	   											System.out.println("2)  Ingresar Movimiento.");
	   											System.out.println("3)  Total de movimientos de Entrada.");
	   											System.out.println("4)  Total de movimientos de Salida.");
	   											System.out.println("5)  Mostrar Productos en Stock al inicio del dia");
	   											System.out.println("6)  Mostrar Productos en Stock al final del dia");
	   											System.out.println("7)  Total de unds ingresadas de cada producto.");
	   											System.out.println("8)  Total de unds salidas de cada producto.");
	   											System.out.println("9)  Monto equivalente a los movimientos de entrada.");
	   											System.out.println("10) Monto equivalente a los movimientos de Salida.");
	   											System.out.println("***************************************************");
	   											System.out.print("Ingrese Numero de Opcion:");
	   											Opcion=sc.next();
	
	   												if(Opcion.equals("1")){
	   													System.out.println("Ingresar Producto");
	   													recibeProducto();	
	   													menu();			
	
	   													}else if(Opcion.equals("2")){
	   														System.out.println("Ingresar un movimiento.");	
	   														recibeMovimiento();
	   														menu();
	   													
	   														}else if(Opcion.equals("3")){
	   															System.out.println("Total de movimientos de entrada.");
	   															mostrarMovimientos("e");
	   															menu();
	
	   															}else if(Opcion.equals("4")){
	   																System.out.println("Total de movimientos de salida.");
	   																mostrarMovimientos("s");
	   																menu();		
	
	   																}else if(Opcion.equals("5")){
	   																	System.out.println("Mostrar stock Inicial.");
	   																	mostrarProductos(listaProductosInicial);
	   																	menu();
	
	   																	}else if(Opcion.equals("6")){
	   																		System.out.println("Mostrar stock Cierre.");
	   																		mostrarProductos(listaProductos);
	   																		menu();
	
	   																}else if(Opcion.equals("7")){
	   																	System.out.println("Total de unds ingresadas de cada producto.");
	   																	mostrarProductosUnidades(listaProductosInicial);
	   																	menu();
	
	   															}else if(Opcion.equals("8")){
	   																System.out.println("Total de unds salidas de cada producto.");
	   																mostrarMovimientosConTipos("s");
	   																menu();
	
	   													}else if(Opcion.equals("9")){
	   														System.out.println("Monto equivalente a los movimientos de entrada.");
	   														mostrarMovimientosTotalEntrada("e");
	   														menu();
	   												
	   												}else if(Opcion.equals("10")){
	   													System.out.println("Monto equivalente a los movimientos de Salida.");
	   													mostrarMovimientosTotalSalida("s");
	   													menu();
	   												}
	   													sc.close();
	   											}

	   										public static void main(String[] args){
	   											Producto producto1=new Producto();
	   											Producto producto2=new Producto();				
	   											Producto producto3=new Producto();
	   											Producto producto4=new Producto();
	   											producto1.setCodProd("001");
	   											producto1.setDescrip("Celular");
	   											producto1.setPrecio(100000);
	   											producto1.setStock(5);		
	   											ingresaProducto(producto1);
	   											//llenar Objeto producto

	   											producto2.setCodProd("002");
	   											producto2.setDescrip("Tv");
	   											producto2.setPrecio(300000);
	   											producto2.setStock(2);	
	   											ingresaProducto(producto2);

	   											producto3.setCodProd("003");
	   											producto3.setDescrip("Notebook");
	   											producto3.setPrecio(350000);
	   											producto3.setStock(10);	
	   											ingresaProducto(producto3);
                        
	   											producto4.setCodProd("004");
	   											producto4.setDescrip("Tablet");
	   											producto4.setPrecio(150000);
	   											producto4.setStock(20);	
	   											ingresaProducto(producto4);
                        
	   									listaProductosInicial=listaProductos.clone();
	   									menu();
			
	   						}
				
			}
